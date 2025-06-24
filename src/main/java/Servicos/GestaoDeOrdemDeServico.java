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
 *
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

    public GestaoDeOrdemDeServico(Estoque estoque, GestaoFinanceira gestaoFinanceira) {
        this.gestaoFinanceira = gestaoFinanceira;
        this.estoque = estoque;
        this.idPorOS = new HashMap<>();
        this.idOSPorIdCliente = new HashMap<>();
        mapper.registerModule(new JavaTimeModule());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }
    
    public void salvarNoArquivo() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(CAMINHO_ARQUIVO), this);
            System.out.println("Gestão de OS salva com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao salvar Gestão de OS: " + e.getMessage());
        }
    }
    
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
    
    public boolean ordemDeServicoExiste(int id){
        return idPorOS.containsKey(id);
    }
    
    public OrdemDeServico buscarOSPorId(int id){
        return idPorOS.get(id);
    }
    
    public OrdemDeServico iniciarOSdeServico(int idCliente, String placaVeiculo, String descricao) {
        OrdemDeServico novaOS = new OrdemDeServico(); // O construtor já cria o ID
        novaOS.setIdCliente(idCliente);
        novaOS.setPlacaVeiculo(placaVeiculo);
        novaOS.setDescricao(descricao);
        novaOS.setDataInicio(LocalDateTime.now());
        novaOS.setStatusOS(StatusOS.EM_MANUTENCAO);
        
        adicionarOS(novaOS);
        salvarNoArquivo();
        return novaOS;
    }
    
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
        
        // Integração com o financeiro
        Lancamento receita = new Lancamento(
            "Receita da OS #" + idOS, nota.getTotal(), LocalDate.now(), TipoLancamento.Receita, null
        );
        gestaoFinanceira.adicionarLancamento(receita);
        
        salvarNoArquivo();
        return nota;
    }
    
//    public NotaFiscal gerarNotaFiscal(int idOS){
//        OrdemDeServico os = buscarOSPorId(idOS);
//        if(os == null){
//            System.err.println("OS não encontrada");
//            return null;
//        }
//        
//        NotaFiscal nota = new NotaFiscal(os.getIdOS(), os.getIdCliente());
//        for(Servicos servico : os.getServicosRealizados()){
//            nota.adicionarItem(servico.getDescricao(), 1, servico.getPreco());
//        }
//        
//        for(Map.Entry<Integer, Integer> entry : os.getPecasUtilizadas().entrySet()){
//            int idPeca = entry.getKey();
//            int quantidade = entry.getValue();
//            Peca peca = estoque.buscarPecaPorId(idPeca);
//            nota.adicionarItem(peca.getNome(), quantidade, peca.getPreco());
//        }
//        nota.imprimir(); // questão 8 olhar se é isso
//        Lancamento receita = new Lancamento("Receita da OS #" + idOS, nota.getTotal(), LocalDate.now(), TipoLancamento.Receita, null);
//        gestaoFinanceira.adicionarLancamento(receita);
//        return nota;
//    }
    
    public OrdemDeServico registrarVendaDireta(int idCliente, Map<Integer, Integer> pecasVendidas) {
        OrdemDeServico osVenda = iniciarOSdeServico(idCliente, "", "Venda de Balcão");

        for (Map.Entry<Integer, Integer> item : pecasVendidas.entrySet()) {
            adicionarPeca(osVenda.getIdOS(), item.getKey(), item.getValue());
        }
        
        finalizarEGerarNota(osVenda.getIdOS());
        return osVenda;
    }
    
    // Criar um metodo para finalizar venda
    
    public void adicionarOS(OrdemDeServico ordemDeServico){
        int id = ordemDeServico.getIdOS();
        if(ordemDeServicoExiste(id) == false){
            idPorOS.put(id, ordemDeServico);
            idOSPorIdCliente.put(id, ordemDeServico.getIdCliente());
        } else{
            throw new RuntimeException("Ordem de Servico Existe");
        }
    }
    
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
    
    public boolean removerOS(int id){
        OrdemDeServico o = buscarOSPorId(id);
        if(o != null){
            idPorOS.remove(id);
            idOSPorIdCliente.remove(id);
            return true;
        }
        return false;
    }
    
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
    
    public boolean adicionarServico(int idOS, Servicos servico) {
        OrdemDeServico os = buscarOSPorId(idOS);
        if (os == null) {
            throw new RuntimeException("OS não encontrada");
        } else {
            os.getServicosRealizados().add(servico);
            return true;
        }
    }
    
    public boolean removerServico(int idOS, Servicos servico) {
        OrdemDeServico os = buscarOSPorId(idOS);
        if (os == null) {
            throw new RuntimeException("OS não encontrada");
        } else if(os.getStatusOS() != StatusOS.PRONTO_PARA_ENTREGA || os.getStatusOS() != StatusOS.ENTREGUE){
            return os.getServicosRealizados().remove(servico);
        }
        return false;
    }
    
    public boolean editarDescricao(int id, String descricao){
        OrdemDeServico o = buscarOSPorId(id);
        if(o != null){
            o.setDescricao(descricao);
            return true;
        }
        return false;
    }
    
    public boolean editarElevador(int id, int idElevador){
        OrdemDeServico o = buscarOSPorId(id);
        if(o != null){
            o.setIdElevador(idElevador);
            return true;
        }
        return false;
    }
    
    public boolean alterarMecanico(int id, int idMecanico){
        OrdemDeServico o = buscarOSPorId(id);
        if(o != null){
            o.setIdMecanico(idMecanico);
            return true;
        }
        return false;
    }
    
    public boolean alterarStatus(int id, StatusOS novoStatus){
        OrdemDeServico o = buscarOSPorId(id);
        if(o != null && novoStatus != o.getStatusOS()){
            o.setStatusOS(novoStatus);
            return true;
        }
        return false;
    }
    
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

    public Estoque getEstoque() {
        return estoque;
    }

    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    public GestaoFinanceira getGestaoFinanceira() {
        return gestaoFinanceira;
    }

    public void setGestaoFinanceira(GestaoFinanceira gestaoFinanceira) {
        this.gestaoFinanceira = gestaoFinanceira;
    }

    public Map<Integer, OrdemDeServico> getIdPorOS() {
        return idPorOS;
    }

    public void setIdPorOS(Map<Integer, OrdemDeServico> idPorOS) {
        this.idPorOS = idPorOS;
    }

    public Map<Integer, Integer> getIdOSPorIdCliente() {
        return idOSPorIdCliente;
    }

    public void setIdOSPorIdCliente(Map<Integer, Integer> idOSPorIdCliente) {
        this.idOSPorIdCliente = idOSPorIdCliente;
    }
    
    

    @Override
    public String toString() {
        return "GestaoDeOrdemDeServico{" + "estoque=" + estoque + ", gestaoFinanceira=" + gestaoFinanceira + ", idPorOS=" + idPorOS + ", idOSPorIdCliente=" + idOSPorIdCliente + '}';
    }
    
}
