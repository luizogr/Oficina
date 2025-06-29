/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Representa um Lote de Compra de uma determinada peça.
 * Armazena a quantidade, o custo unitário e o fornecedor para uma compra específica.
 * @author luizp
 */
public class LotePeca implements Serializable{
    private int idFornecedor;
    private int quantidade;
    private double precoCusto;
    private LocalDate dataCompra;

    /**
     * Construtor para criar um novo lote de peças
     * @param idFornecedor
     * @param quantidade
     * @param precoCusto
     * @param dataCompra 
     */
    public LotePeca(int idFornecedor, int quantidade, double precoCusto, LocalDate dataCompra) {
        this.idFornecedor = idFornecedor;
        this.quantidade = quantidade;
        this.precoCusto = precoCusto;
        this.dataCompra = dataCompra;
    }

    /**
     * Construtor padrão
     */
    public LotePeca() {
    }

    /**
     * 
     * @return 
     */
    public int getIdFornecedor() {
        return idFornecedor;
    }

    /**
     * 
     * @return 
     */
    public double getPrecoCusto() {
        return precoCusto;
    }

    /**
     * 
     * @return 
     */
    public LocalDate getDataCompra() {
        return dataCompra;
    }

    /**
     * Retorna a quantidade de peças restantes neste lote
     * @return 
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * 
     * @param quantidade 
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * Retorna uma representação textual do objeto LotePeca
     * @return 
     */
    @Override
    public String toString() {
        return String.format("Lote | Fornecedor ID: %d | Qtd: %d | Custo: R$%.2f | Data: %s", idFornecedor, quantidade, precoCusto, dataCompra);
    }
}
