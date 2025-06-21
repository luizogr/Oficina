/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import Dominio.Peca;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Gerencia o inventário de peças da oficina.
 * Controla a quantidade de cada peça e os detalhes da peça em si.
 * @author luizp
 */
public class Estoque {
    private Map<Integer, List<LotePeca>> lotesPorPeca;
    private Map<Integer, Peca> pecasPorId;
    private static final String CAMINHO_ARQUIVO = "estoque.json";
    private static final ObjectMapper mapper = new ObjectMapper();

    public Estoque() {
        this.lotesPorPeca = new HashMap<>();
        this.pecasPorId = new HashMap<>();
        
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    public boolean contemPeca(int id){
        return lotesPorPeca.containsKey(id);
    }
    
    public boolean quantidadeSuficiente(int id, int quantidade){
        if (!contemPeca(id)) return false;
        
        int totalDisponivel = lotesPorPeca.get(id).stream()
            .mapToInt(LotePeca::getQuantidade)
            .sum();
        
        return totalDisponivel >= quantidade;
    }
    
    /**
     * 
     * @param id
     * @return 
     */
    public Peca buscarPecaPorId(int id){
        return pecasPorId.get(id);
    }
    
    /**
     * Metodo para carregar os arquivos do .json
     * @return 
     */
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

    public void salvarNoArquivo() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(CAMINHO_ARQUIVO), this);
        } catch (IOException e) {
            System.out.println("Erro ao salvar estoque: " + e.getMessage());
        }
    }
    
    /**
     * 
     * @param peca
     * @param quantidade
     * @param idFornecedor
     * @param precoUnitario
     * @return 
     */
    public boolean adicionarLote(Peca peca, int quantidade, int idFornecedor, double precoUnitario) {
        if (quantidade <= 0 || precoUnitario <= 0) {
            System.out.println("Quantidade e preço devem ser positivos.");
            return false;
        }

        // Calcula preço de custo com margem de 20%
        double precoCusto = precoUnitario * 1.20;

        // Cria novo lote
        LotePeca lote = new LotePeca(idFornecedor, quantidade, precoCusto, LocalDate.now());

        // Cadastra peça se for a primeira vez
        if (pecasPorId.containsKey(peca.getIdPeca()) == false) {
            pecasPorId.put(peca.getIdPeca(), peca);
            lotesPorPeca.put(peca.getIdPeca(), new ArrayList<>());
        }

        lotesPorPeca.get(peca.getIdPeca()).add(lote);
        salvarNoArquivo();

        System.out.println("Lote adicionado com sucesso!");
        return true;
    }
    /*}*/
    
    
    /**
     *  Adiciona uma nova peça ou incrementa a quantidade de uma peça existente no estoque.
     * @param peca
     * @param quantidade
     * @return 
//     */
//    public boolean adicionarPeca(Peca peca, int quantidade){
//        boolean pecaExiste = contemPeca(peca.getIdPeca());
//        if(pecaExiste == false){
//            pecasPorId.put(peca.getIdPeca(), peca);
//            lotesPorPeca.put(peca.getIdPeca(), quantidade);
//            salvarNoArquivo();
//            return true; //Se retornar True mensagem de nova peça adicionada
//        } else{
//            int quantidadeAtual = lotesPorPeca.get(peca.getIdPeca());
//            lotesPorPeca.put(peca.getIdPeca(), quantidadeAtual + quantidade);
//            salvarNoArquivo();
//            return false; //Se retornar false mensagem de quantidade atualizada
//        }
//    }
    
    /**
     *  Remove uma certa quantidade de uma peça do estoque.
     * @param id
     * @param quantidade
     * @return 
     */
    public boolean removerPeca(int id, int quantidade){
        if(quantidade <= 0){
            throw new IllegalArgumentException("A quantidade deve ser positiva");
        }
       
        if(contemPeca(id) == false){
            throw new IllegalArgumentException("A peça não existe no estoque");
        }
        
        List<LotePeca> lotes = lotesPorPeca.get(id);
        int totalDisponivel = 0;
        for (int i = 0; i < lotes.size(); i++) {
            totalDisponivel += lotes.get(i).getQuantidade();
        }
        if(quantidade > totalDisponivel){
            System.out.println("Impossivel remover, pois quantidade a ser removida " + quantidade + " é maior que a quantidade em estoque: " + totalDisponivel);
            return false;
        } 
        
        int restante = quantidade;
        for (int i = 0; i < lotes.size(); i++) {
            if (restante <= 0) break;

            LotePeca lote = lotes.get(i);
            int qntdNoLote = lote.getQuantidade();

            if (qntdNoLote <= restante) {
                restante -= qntdNoLote;
                lote.setQuantidade(0);
            } else {
                lote.setQuantidade(qntdNoLote - restante);
                restante = 0;
            }
        }
        
        for (int i = 0; i < lotes.size(); i++) {
            if (lotes.get(i).getQuantidade() == 0) {
                lotes.remove(i);
                i--; 
            }
        }
        
        if (lotes.isEmpty()) {
            lotesPorPeca.remove(id);
            pecasPorId.remove(id);
            System.out.println("Todos os lotes da peça foram removidos");
        } else {
            System.out.println("Peça removida parcialmente. Ainda restam lotes.");
        }

        salvarNoArquivo();
        return true;
        
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
    
        public boolean editarPreco(int id, double preco){
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
    
    public void imprimirEstoque(Map<Integer, Fornecedor> fornecedoresCadastrados) {
        if (lotesPorPeca.isEmpty()) {
            System.out.println("Estoque vazio.");
            return;
        }

        for (Map.Entry<Integer, List<LotePeca>> entry : lotesPorPeca.entrySet()) {
            int idPeca = entry.getKey();
            Peca peca = pecasPorId.get(idPeca);
            List<LotePeca> lotes = entry.getValue();

            System.out.println("===================================================");
            System.out.println("ID: " + idPeca + " | Nome: " + peca.getNome() + " | Preço de venda: R$ " + peca.getPreco());
            int totalUnidades = 0;

            for (int i = 0; i < lotes.size(); i++) {
                LotePeca lote = lotes.get(i);
                totalUnidades += lote.getQuantidade();

                Fornecedor fornecedor = fornecedoresCadastrados.get(lote.getIdFornecedor());
                String nomeFornecedor = (fornecedor != null) ? fornecedor.getNome() : "Desconhecido";

                System.out.println("  Lote " + (i + 1) + ":");
                System.out.println("    Quantidade: " + lote.getQuantidade());
                System.out.println("    Preço custo unitário: R$ " + lote.getPrecoCusto());
                System.out.println("    Fornecedor: " + nomeFornecedor + " (ID: " + lote.getIdFornecedor() + ")");
                System.out.println("    Data de compra: " + lote.getDataCompra());
            }

            System.out.println("  Total em estoque: " + totalUnidades + " unidades");
        }
    }


    public Map<Integer, List<LotePeca>> getLotesPorPeca() {
        return lotesPorPeca;
    }

    public void setLotesPorPeca(Map<Integer, List<LotePeca>> lotesPorPeca) {
        this.lotesPorPeca = lotesPorPeca;
    }

    public Map<Integer, Peca> getPecasPorId() {
        return pecasPorId;
    }

    public void setPecasPorId(Map<Integer, Peca> pecasPorId) {
        this.pecasPorId = pecasPorId;
    }
}
