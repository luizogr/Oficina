/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicos;

import Dominio.Estoque;
import Dominio.NotaFiscal;
import Dominio.OrdemDeServico;
import Dominio.Peca;
import Dominio.Servicos;
import Dominio.StatusOS;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
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
    private Map<Integer, OrdemDeServico> idPorOS;
    private Map<Integer, Integer> idOSPorIdCliente;
    private static final String CAMINHO_ARQUIVO = "gestao_os.json";
    private static final ObjectMapper mapper = new ObjectMapper();
    
    public void salvarNoArquivo() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(CAMINHO_ARQUIVO), this);
            System.out.println("Gestão de OS salva com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao salvar Gestão de OS: " + e.getMessage());
        }
    }
    
    public static GestaoDeOrdemDeServico carregarDoArquivo(Estoque estoque) {
        try {
            File arquivo = new File(CAMINHO_ARQUIVO);
            if (arquivo.exists()) {
                GestaoDeOrdemDeServico gestao = mapper.readValue(arquivo, GestaoDeOrdemDeServico.class);
                gestao.estoque = estoque; // reatribui a referência do estoque
                return gestao;
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar Gestão de OS: " + e.getMessage());
        }
        return new GestaoDeOrdemDeServico(estoque);
    }

    public GestaoDeOrdemDeServico(Estoque estoque) {
        this.estoque = estoque;
        this.idPorOS = new HashMap<>();
        this.idOSPorIdCliente = new HashMap<>();
    }
    
    public boolean ordemDeServicoExiste(int id){
        return idPorOS.containsKey(id);
    }
    
    public OrdemDeServico buscarOSPorId(int id){
        return idPorOS.get(id);
    }
    
    public NotaFiscal gerarNotaFiscal(int idOS){
        OrdemDeServico os = buscarOSPorId(idOS);
        if(os == null){
            System.err.println("OS não encontrada");
            return null;
        }
        
        NotaFiscal nota = new NotaFiscal(os.getIdOS(), os.getIdCliente());
        for(Servicos servico : os.getServicosRealizados()){
            nota.adicionarItem(servico.getDescricao(), 1, servico.getPreco());
        }
        
        for(Map.Entry<Integer, Integer> entry : os.getPecasUtilizadas().entrySet()){
            int idPeca = entry.getKey();
            int quantidade = entry.getValue();
            Peca peca = estoque.buscarPecaPorId(idPeca);
            nota.adicionarItem(peca.getNome(), quantidade, peca.getPreco());
        }
        nota.imprimir(); // questão 8 olhar se é isso
        return nota;
    }
    
    public OrdemDeServico vendaDireta(int idCliente, Map<Integer, Integer> pecasVenda){
        OrdemDeServico os = new OrdemDeServico();
        editarDescricao(os.getIdOS(), "Venda Direta");
        os.setIdCliente(idCliente);
        os.setDataInicio(LocalDateTime.now());
        
        for(Map.Entry<Integer, Integer> entry : pecasVenda.entrySet()){
            adicionarPeca(os.getIdOS(), entry.getKey(), entry.getValue());
        }
        
        alterarDataDeTermino(os.getIdOS(), LocalDateTime.now());
        alterarStatus(os.getIdOS(), StatusOS.ENTREGUE);
        adicionarOS(os);
        
        return os;
    }
    
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
}
