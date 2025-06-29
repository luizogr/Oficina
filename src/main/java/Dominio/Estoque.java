/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import Dominio.Peca;
import Servicos.GestaoFinanceira;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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
    @JsonIgnore
    private GestaoFinanceira gestaoFinanceira;
    private static final String CAMINHO_ARQUIVO = "estoque.json";
    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * Construtor para Estoque
     * @param gestaoFinanceira 
     */
    public Estoque(GestaoFinanceira gestaoFinanceira) {
        this.gestaoFinanceira = gestaoFinanceira;
        this.lotesPorPeca = new HashMap<>();
        this.pecasPorId = new HashMap<>();
        mapper.registerModule(new JavaTimeModule());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    /**
     * Construtor padrão
     */
    public Estoque() {
        this.lotesPorPeca = new HashMap<>();
        this.pecasPorId = new HashMap<>();
        mapper.registerModule(new JavaTimeModule());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }
    
    /**
     * Verifica se uma peça, dado seu ID, existe no catálogo de peças do estoque
     * @param id
     * @return 
     */
    public boolean contemPeca(int id){
        return lotesPorPeca.containsKey(id);
    }
    
    /**
     * Verifica se a quantidade total de uma peça em estoque é suficiente para atender a uma determinada demanda
     * @param id
     * @param quantidade
     * @return 
     */
    public boolean quantidadeSuficiente(int id, int quantidade){
        if (!contemPeca(id)) return false;
        
        int totalDisponivel = lotesPorPeca.get(id).stream()
            .mapToInt(LotePeca::getQuantidade)
            .sum();
        
        return totalDisponivel >= quantidade;
    }
    
    /**
     * Busca e retorna um objeto Peca pelo seu ID
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
    public static Estoque carregarDoArquivo(GestaoFinanceira gestaoFinanceira) {
        try {
            File arquivo = new File(CAMINHO_ARQUIVO);
            if (arquivo.exists() && arquivo.length() > 0) {
                ObjectMapper localMapper = new ObjectMapper();
                localMapper.registerModule(new JavaTimeModule());
                Estoque gestao = localMapper.readValue(arquivo, Estoque.class);
                
                // Reconecta a dependência externa que não foi salva no JSON
                gestao.setGestaoFinanceira(gestaoFinanceira);
                
                // Ajusta os contadores estáticos
                int maxIdPeca = 0;
                if (gestao.getPecasPorId() != null) {
                    for(Peca p : gestao.getPecasPorId().values()){
                        if(p.getIdPeca() > maxIdPeca){ maxIdPeca = p.getIdPeca(); }
                    }
                }
                Peca.setContadorPeca(maxIdPeca);
                
                return gestao;
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar estoque: " + e.getMessage());
        }
        return new Estoque(gestaoFinanceira);
    }

    /**
     * Salva o estado atual do estoque em um arquivo JSON
     */
    public void salvarNoArquivo() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(CAMINHO_ARQUIVO), this);
        } catch (IOException e) {
            System.out.println("Erro ao salvar estoque: " + e.getMessage());
        }
    }
    
    /**
     * Adiciona um novo lote de peças ao estoque e registra a compra como uma despesa
     * @param peca tipo de peça que está sendo recebido
     * @param quantidade quantidade de peças recebidas
     * @param idFornecedor O ID do fornecedor
     * @param precoUnitario preço de custo de cada peça neste lote
     * @return true se o lote foi adicionado com sucesso, false caso contrário
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
        
        double valorTotalCompra = quantidade * precoCusto;
        Lancamento despesa = new Lancamento(
            "Compra de " + quantidade + "x " + peca.getNome(), valorTotalCompra, lote.getDataCompra(), TipoLancamento.Despesa, CategoriaDespesa.Compra_De_Peca);
        gestaoFinanceira.adicionarLancamento(despesa);

        System.out.println("Lote adicionado com sucesso!");
        return true;
    }
    
    /**
     *  Remove uma certa quantidade de uma peça do estoque, utilizando a estratégia FIFO
     * @param id ID da peça a ser removida
     * @param quantidade A quantidade a ser removida
     * @return true se a remoção foi bem-sucedida
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
    
    /**
     * Calcula a quantidade total de uma peça somando todos os seus lotes
     * @param id O ID da peça
     * @return A quantidade total em estoque
     */
    public int getQuantidadeTotal(int id) {
        if (!lotesPorPeca.containsKey(id)) return 0;
        return lotesPorPeca.get(id).stream().mapToInt(LotePeca::getQuantidade).sum();
    }
    
    /**
     * Edita o nome de um tipo de peça no catálogo
     * @param id
     * @param nome
     * @return 
     */
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
    
    /**
     * Edita o preço de venda de um tipo de peça no catálogo
     * @param id
     * @param preco
     * @return 
     */
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
    
    /**
     * Imprime um relatório detalhado do estoque, mostrando cada lote e seu fornecedor
     * @param fornecedoresCadastrados 
     */
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
    public Map<Integer, List<LotePeca>> getLotesPorPeca() {
        return lotesPorPeca;
    }

    /**
     * 
     * @param lotesPorPeca 
     */
    public void setLotesPorPeca(Map<Integer, List<LotePeca>> lotesPorPeca) {
        this.lotesPorPeca = lotesPorPeca;
    }

    /**
     * 
     * @return 
     */
    public Map<Integer, Peca> getPecasPorId() {
        return pecasPorId;
    }

    /**
     * Gera uma representação textual simples do estado atual do estoque
     * @param pecasPorId 
     */
    public void setPecasPorId(Map<Integer, Peca> pecasPorId) {
        this.pecasPorId = pecasPorId;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        if (pecasPorId.isEmpty()) {
            return "Estoque Vazio.";
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("--- Resumo do Estoque ---\n");
        
        for (Peca peca : pecasPorId.values()) {
            int quantidadeTotal = getQuantidadeTotal(peca.getIdPeca());
            sb.append("- ").append(peca.getNome())
              .append(" (ID: ").append(peca.getIdPeca()).append(")")
              .append(": ").append(quantidadeTotal).append(" unidades\n");
        }
        
        sb.append("-------------------------");
        return sb.toString();
    }
}
