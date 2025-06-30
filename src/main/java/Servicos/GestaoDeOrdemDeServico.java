/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicos;

import Dominio.Estoque;
import Dominio.Lancamento;
import Dominio.NotaFiscal;
import Dominio.OrdemDeServico;
import Dominio.Peca;
import Dominio.Servicos;
import Dominio.StatusOS;
import Dominio.TipoLancamento;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Realiza a gestão completa das Ordens de Serviço
 * @author luizp
 */
public class GestaoDeOrdemDeServico {
    @JsonIgnore
    private Estoque estoque;
    @JsonIgnore
    private GestaoFinanceira gestaoFinanceira;
    private Map<Integer, OrdemDeServico> idPorOS;
    private Map<Integer, Integer> idOSPorIdCliente;
    private static final String CAMINHO_ARQUIVO = "gestao_os.json";
    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * Construtor da classe GestaoDeOrdemDeServico
     * @param estoque
     * @param gestaoFinanceira 
     */
    public GestaoDeOrdemDeServico(Estoque estoque, GestaoFinanceira gestaoFinanceira) {
        this.gestaoFinanceira = gestaoFinanceira;
        this.estoque = estoque;
        this.idPorOS = new HashMap<>();
        this.idOSPorIdCliente = new HashMap<>();
        mapper.registerModule(new JavaTimeModule());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    /**
     * Construtor padrão
     */
    public GestaoDeOrdemDeServico() {
        this.idPorOS = new HashMap<>();
        this.idOSPorIdCliente = new HashMap<>();
        mapper.registerModule(new JavaTimeModule());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }
   
    /**
     * Salva o estado atual da gestão de OS em um arquivo JSON
     */
    public void salvarNoArquivo() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(CAMINHO_ARQUIVO), this);
            System.out.println("Gestão de OS salva com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao salvar Gestão de OS: " + e.getMessage());
        }
    }
    
    /**
     * Carrega os dados da gestão de OS de um arquivo JSON
     * @param estoque
     * @param gestaoFinanceira
     * @return 
     */
    public static GestaoDeOrdemDeServico carregarDoArquivo(Estoque estoque, GestaoFinanceira gestaoFinanceira) {
        try {
            File arquivo = new File(CAMINHO_ARQUIVO);
            if (arquivo.exists() && arquivo.length() > 0) {
                ObjectMapper localMapper = new ObjectMapper();
                localMapper.registerModule(new JavaTimeModule());
                GestaoDeOrdemDeServico gestao = localMapper.readValue(arquivo, GestaoDeOrdemDeServico.class);
                
                gestao.setEstoque(estoque);
                gestao.setGestaoFinanceira(gestaoFinanceira);
                
                int maxId = 0;
                for (OrdemDeServico os : gestao.getIdPorOS().values()) {
                    if (os.getIdOS() > maxId) {
                        maxId = os.getIdOS();
                    }
                }
                OrdemDeServico.setContadorOS(maxId);

                return gestao;
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar Gestão de OS: " + e.getMessage());
        }
        return new GestaoDeOrdemDeServico(estoque, gestaoFinanceira);
    }
    
    /**
     * Verifica se uma Ordem de Serviço com o ID especificado existe
     * @param id
     * @return 
     */
    public boolean ordemDeServicoExiste(int id){
        return idPorOS.containsKey(id);
    }
    
    /**
     * Busca e retorna uma Ordem de Serviço pelo seu ID
     * @param id
     * @return 
     */
    public OrdemDeServico buscarOSPorId(int id){
        return idPorOS.get(id);
    }
    
    /**
     * Inicia uma nova Ordem de Serviço e a adiciona ao sistema
     * @param idCliente
     * @param placaVeiculo
     * @param descricao
     * @return 
     */
    public OrdemDeServico iniciarOSdeServico(int idCliente, String placaVeiculo, String descricao) {
        OrdemDeServico novaOS = new OrdemDeServico();
        novaOS.setIdCliente(idCliente);
        novaOS.setPlacaVeiculo(placaVeiculo);
        novaOS.setDescricao(descricao);
        novaOS.setDataInicio(LocalDateTime.now());
        novaOS.setStatusOS(StatusOS.EM_MANUTENCAO);
        
        adicionarOS(novaOS);
        salvarNoArquivo();
        return novaOS;
    }
    
    /**
     * Finaliza uma OS, gera a nota fiscal e registra a receita
     * @param idOS
     * @return 
     */
    public NotaFiscal finalizarEGerarNota(int idOS) {
        OrdemDeServico os = buscarOSPorId(idOS);
        if (os == null) {
            System.err.println("Erro: OS não encontrada para finalizar.");
            return null;
        }

        os.setStatusOS(StatusOS.ENTREGUE);
        os.setDataTermino(LocalDateTime.now());
        
        NotaFiscal nota = new NotaFiscal(os.getIdOS(), os.getIdCliente());
        
        for (Servicos servico : os.getServicosRealizados()) {
            nota.adicionarItem(servico.getDescricao(), 1, servico.getPreco());
        }
        
        for (Map.Entry<Integer, Integer> entry : os.getPecasUtilizadas().entrySet()) {
            Peca peca = estoque.buscarPecaPorId(entry.getKey());
            if (peca != null) {
                nota.adicionarItem(peca.getNome(), entry.getValue(), peca.getPreco());
            }
        }
        
        nota.imprimir();
        
        Lancamento receita = new Lancamento("Receita da OS #" + idOS, nota.getTotal(), LocalDate.now(), TipoLancamento.Receita, null);
        gestaoFinanceira.adicionarLancamento(receita);
        gestaoFinanceira.adicionarNotaFiscal(nota);
        
        salvarNoArquivo();
        return nota;
    }
    
    /**
     * Registra uma venda direta de peças, criando uma OS específica para isso
     * @param idCliente
     * @param pecasVendidas
     * @return 
     */
    public OrdemDeServico registrarVendaDireta(int idCliente, Map<Integer, Integer> pecasVendidas) {
        OrdemDeServico osVenda = iniciarOSdeServico(idCliente, "", "Venda de Balcão");

        for (Map.Entry<Integer, Integer> item : pecasVendidas.entrySet()) {
            adicionarPeca(osVenda.getIdOS(), item.getKey(), item.getValue());
        }
        
        finalizarEGerarNota(osVenda.getIdOS());
        return osVenda;
    }
    
    /**
     * Adiciona uma Ordem de Serviço ao sistema de gestão
     * @param ordemDeServico 
     */
    public void adicionarOS(OrdemDeServico ordemDeServico){
        int id = ordemDeServico.getIdOS();
        if(ordemDeServicoExiste(id) == false){
            idPorOS.put(id, ordemDeServico);
            idOSPorIdCliente.put(id, ordemDeServico.getIdCliente());
        } else{
            throw new RuntimeException("Ordem de Servico Existe");
        }
    }
    
    /**
     * Busca as OS de um cliente específico com base em seu ID
     * @param idCliente
     * @return 
     */
    public ArrayList<OrdemDeServico> buscarOSPorCliente(int idCliente){
        ArrayList<OrdemDeServico> veiculosCliente = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : idOSPorIdCliente.entrySet()){
            if(entry.getValue().equals(idCliente)){
                OrdemDeServico ordemDeServico = idPorOS.get(entry.getKey());
                if(ordemDeServico != null){
                    veiculosCliente.add(ordemDeServico);
                }
            }
        }
        return veiculosCliente;
    }
    
    /**
     * Imprime as OSs de um cliente pelo seu ID
     * @param idCliente 
     */
    public void imprimirOSDoCliente(int idCliente) {
        System.out.println("\n--- Ordens de Serviço para o Cliente ID: " + idCliente + " ---");
        ArrayList<OrdemDeServico> osDoCliente = buscarOSPorCliente(idCliente);
        if (osDoCliente.isEmpty()) {
            System.out.println("Nenhuma Ordem de Serviço encontrada para este cliente.");
        } else {
            osDoCliente.forEach(System.out::println);
        }
        System.out.println("----------------------------------------------");
    }
    
    /**
     * Remove uma OS do sistema de gestão
     * @param id
     * @return 
     */
    public boolean removerOS(int id){
        OrdemDeServico o = buscarOSPorId(id);
        if(o != null){
            idPorOS.remove(id);
            idOSPorIdCliente.remove(id);
            return true;
        }
        return false;
    }
    
    /**
     * Adiciona uma quantidade de peças a lista de peças de uma OS
     * @param idOS
     * @param idPeca
     * @param quantidade
     * @return 
     */
    public boolean adicionarPeca(int idOS, int idPeca, int quantidade){
        OrdemDeServico oS = buscarOSPorId(idOS);
        if(oS == null){
            throw new RuntimeException("Ordem de Serviço não encontrada");
        } else if(estoque.quantidadeSuficiente(idPeca, quantidade)){
            oS.adicionarPeca(idPeca, quantidade);
            estoque.removerPeca(idPeca, quantidade);
            return true;
        }
        return false;
    }
    
    /**
     * Remove peças da lista de peças da OS
     * @param idOS
     * @param idPeca
     * @param quantidade
     * @return 
     */
    public boolean removerPeca(int idOS, int idPeca, int quantidade){
        OrdemDeServico oS = buscarOSPorId(idOS);
        if(oS == null){
            throw new RuntimeException("Ordem de Serviço não encontrada");
        } else if(estoque.quantidadeSuficiente(idPeca, quantidade)){
            oS.removerPeca(idPeca, quantidade);
            Peca peca = estoque.buscarPecaPorId(idPeca);
            int idFornecedorDevolucao = 0;
            estoque.adicionarLote(peca, quantidade, idFornecedorDevolucao, peca.getPreco());
            return true;
        }
        return false;
    }
    
    /**
     * Adiciona um serviço realizado a lista de serviços de uma OS
     * @param idOS
     * @param servico
     * @return 
     */
    public boolean adicionarServico(int idOS, Servicos servico) {
        OrdemDeServico os = buscarOSPorId(idOS);
        if (os == null) {
            throw new RuntimeException("OS não encontrada");
        } else {
            os.getServicosRealizados().add(servico);
            return true;
        }
    }
    
    /**
     * Remove serviço da lista de serviços de uma OS
     * @param idOS
     * @param servico
     * @return 
     */
    public boolean removerServico(int idOS, Servicos servico) {
        OrdemDeServico os = buscarOSPorId(idOS);
        if (os == null) {
            throw new RuntimeException("OS não encontrada");
        } else if(os.getStatusOS() != StatusOS.PRONTO_PARA_ENTREGA || os.getStatusOS() != StatusOS.ENTREGUE){
            return os.getServicosRealizados().remove(servico);
        }
        return false;
    }
    
    /**
     * Edita a descrição de uma OS
     * @param id
     * @param descricao
     * @return 
     */
    public boolean editarDescricao(int id, String descricao){
        OrdemDeServico o = buscarOSPorId(id);
        if(o != null){
            o.setDescricao(descricao);
            return true;
        }
        return false;
    }
    
    /**
     * Edita o elevador de uma OS
     * @param id
     * @param idElevador
     * @return 
     */
    public boolean editarElevador(int id, int idElevador){
        OrdemDeServico o = buscarOSPorId(id);
        if(o != null){
            o.setIdElevador(idElevador);
            return true;
        }
        return false;
    }
    
    /**
     * Altera o mecânico que realizou a OS
     * @param id
     * @param idMecanico
     * @return 
     */
    public boolean alterarMecanico(int id, int idMecanico){
        OrdemDeServico o = buscarOSPorId(id);
        if(o != null){
            o.setIdMecanico(idMecanico);
            return true;
        }
        return false;
    }
    
    /**
     * Altera o Status da OS
     * @param id
     * @param novoStatus
     * @return 
     */
    public boolean alterarStatus(int id, StatusOS novoStatus){
        OrdemDeServico o = buscarOSPorId(id);
        if(o != null && novoStatus != o.getStatusOS()){
            if(novoStatus != StatusOS.PRONTO_PARA_ENTREGA){
                o.setStatusOS(novoStatus);
                return true;
            } 
        }
        return false;
    }
    
    /**
     * Altera a data de termino da OS
     * @param id
     * @param dataTermino
     * @return 
     */
    public boolean alterarDataDeTermino(int id, LocalDateTime dataTermino){
        OrdemDeServico o = buscarOSPorId(id);
        if(o != null){
            if (dataTermino.isBefore(o.getDataInicio())) {
                throw new IllegalArgumentException("Data de término não pode ser antes do início.");
            }else {
                o.setDataTermino(dataTermino);
                return true;
            }
        }
        return false;
    }

    /**
     * 
     * @return 
     */
    public Estoque getEstoque() {
        return estoque;
    }

    /**
     * 
     * @param estoque 
     */
    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    /**
     * 
     * @return 
     */
    public GestaoFinanceira getGestaoFinanceira() {
        return gestaoFinanceira;
    }

    /**
     * 
     * @param gestaoFinanceira 
     */
    public void setGestaoFinanceira(GestaoFinanceira gestaoFinanceira) {
        this.gestaoFinanceira = gestaoFinanceira;
    }

    /**
     * 
     * @return 
     */
    public Map<Integer, OrdemDeServico> getIdPorOS() {
        return idPorOS;
    }

    /**
     * 
     * @param idPorOS 
     */
    public void setIdPorOS(Map<Integer, OrdemDeServico> idPorOS) {
        this.idPorOS = idPorOS;
    }

    /**
     * 
     * @return 
     */
    public Map<Integer, Integer> getIdOSPorIdCliente() {
        return idOSPorIdCliente;
    }

    /**
     * 
     * @param idOSPorIdCliente 
     */
    public void setIdOSPorIdCliente(Map<Integer, Integer> idOSPorIdCliente) {
        this.idOSPorIdCliente = idOSPorIdCliente;
    }
    
    /**
     * Retorna uma representação textual da gestão de OS
     * @return 
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- Relatório de Ordens de Serviço ---\n");
        for (OrdemDeServico os : idPorOS.values()) {
            sb.append(os.toString()).append("\n");
        }
        sb.append("------------------------------------");
        return sb.toString();
    }
    
}
