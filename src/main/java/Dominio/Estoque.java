/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import Dominio.Peca;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
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
    private static final String CAMINHO_ARQUIVO = "estoque.json";
    private static final ObjectMapper mapper = new ObjectMapper();

    public Estoque() {
        this.estoqueQuantidades = new HashMap<>();
        this.pecasPorId = new HashMap<>();
    }
    
    public boolean contemPeca(int id){
        return estoqueQuantidades.containsKey(id);
    }
    
    public Peca buscarPecaPorId(int id){
        return pecasPorId.get(id);
    }
    
    public static Estoque carregarDoArquivo() {
        try {
            File arquivo = new File(CAMINHO_ARQUIVO);
            if (arquivo.exists()) {
                return mapper.readValue(arquivo, Estoque.class);
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar estoque: " + e.getMessage());
        }
        return new Estoque();
    }

    private void salvarNoArquivo() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(CAMINHO_ARQUIVO), this);
        } catch (IOException e) {
            System.out.println("Erro ao salvar estoque: " + e.getMessage());
        }
    }
    
    public boolean adicionarPeca(Peca peca, int quantidade){
        boolean pecaExiste = contemPeca(peca.getIdPeca());
        if(pecaExiste == false){
            pecasPorId.put(peca.getIdPeca(), peca);
            estoqueQuantidades.put(peca.getIdPeca(), quantidade);
            salvarNoArquivo();
            return true; //Se retornar True mensagem de nova peça adicionada
        } else{
            int quantidadeAtual = estoqueQuantidades.get(peca.getIdPeca());
            estoqueQuantidades.put(peca.getIdPeca(), quantidadeAtual + quantidade);
            salvarNoArquivo();
            return false; //Se retornar false mensagem de quantidade atualizada
        }
    }
    
    public boolean removerPeca(int id, int quantidade){
        if(quantidade <= 0){
            throw new IllegalArgumentException("A quantidade deve ser positiva");
        }
        
        if(contemPeca(id) == false){
            throw new IllegalArgumentException("A peça não existe no estoque");
        }
        
        int quantidadeAtual = estoqueQuantidades.get(id);
        
        if(quantidade > quantidadeAtual){
            System.out.println("Impossivel remover, pois quantidade a ser removida " + quantidade + " é maior que a quantidade em estoque: " + quantidadeAtual);
            return false;
        } else if(quantidade == quantidadeAtual){
            estoqueQuantidades.remove(id);
            pecasPorId.remove(id);
            System.out.println("Peça removida do estoque");
            salvarNoArquivo();
            return true;
        } else {
            estoqueQuantidades.put(id, quantidadeAtual - quantidade);
            System.out.println("Removido " + quantidade + " peças do estoque");
            salvarNoArquivo();
            return true;
        }
    }
    
    public boolean editarNome(int id, String nome){
        boolean pecaExiste = contemPeca(id);
        if(pecaExiste == false){
            System.out.println("Peça não está em estoque");
            return false;
        } else {
            Peca p = buscarPecaPorId(id);
            p.setNome(nome);
            salvarNoArquivo();
            return true;
        }  
    }
    
        public boolean editarPreço(int id, double preco){
        boolean pecaExiste = contemPeca(id);
        if(pecaExiste == false){
            System.out.println("Peça não está em estoque");
            return false;
        } else {
            Peca p = buscarPecaPorId(id);
            p.setPreco(preco);
            salvarNoArquivo();
            return true;
        }  
    }
    
    public void imprimirEstoque(){
        for(Map.Entry<Integer, Integer> entry : estoqueQuantidades.entrySet()){
            Peca peca = pecasPorId.get(entry.getKey());
            System.out.println("ID: " + peca.getIdPeca() + " | Nome: " + peca.getNome() + " | Preço: " + peca.getPreco()+ " | Quantidade: " + entry.getValue());
        }
    }

    public Map<Integer, Integer> getEstoqueQuantidades() {
        return estoqueQuantidades;
    }

    public void setEstoqueQuantidades(Map<Integer, Integer> estoqueQuantidades) {
        this.estoqueQuantidades = estoqueQuantidades;
    }

    public Map<Integer, Peca> getPecasPorId() {
        return pecasPorId;
    }

    public void setPecasPorId(Map<Integer, Peca> pecasPorId) {
        this.pecasPorId = pecasPorId;
    }
}
