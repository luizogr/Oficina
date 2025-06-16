/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicos;

import Dominio.Estoque;
import Dominio.OrdemDeServico;
import Dominio.Peca;
import Dominio.Servicos;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author luizp
 */
public class GestaoDeOrdemDeServico {
    private Estoque estoque;
    private Map<Integer, OrdemDeServico> idPorOS;
    private Map<Integer, Integer> idOSPorIdCliente;

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
            if(entry.getValue() == idCliente){
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
            estoque.adicionarPeca(peca, quantidade);
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
}
