/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import Dominio.Peca;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author luizp
 */
public class Estoque {
    private Map<Integer, Integer> estoqueQuantidades;
    private Map<Integer, Peca> pecasPorId;

    public Estoque() {
        this.estoqueQuantidades = new HashMap<>();
        this.pecasPorId = new HashMap<>();
    }
    
    public boolean contemPeca(int id){
        return estoqueQuantidades.containsKey(id);
    }
    
    public boolean adicionarPeca(Peca peca, int quantidade){
        boolean pecaExiste = contemPeca(peca.getIdPeca());
        if(pecaExiste == false){
            pecasPorId.put(peca.getIdPeca(), peca);
            estoqueQuantidades.put(peca.getIdPeca(), quantidade);
            return true; //Se retornar True mensagem de nova peça adicionada
        } else{
            int quantidadeAtual = estoqueQuantidades.get(peca.getIdPeca());
            estoqueQuantidades.put(peca.getIdPeca(), quantidadeAtual + quantidade);
            return false; //Se retornar false mensagem de quantidade atualizada
        }
    }
    
    public void imprimirEstoque(){
        for(Map.Entry<Integer, Integer> entry : estoqueQuantidades.entrySet()){
            Peca peca = pecasPorId.get(entry.getKey());
            System.out.println("ID: " + peca.getIdPeca() + " | Nome: " + peca.getNome() + " | Quantidade: " + entry.getValue());
        }
    }
}
