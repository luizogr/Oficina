/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.io.Serializable;

/**
 * Representa um item dentro de uma NotaFiscal
 * @author luizp
 */
public class ItemNota implements Serializable{
    private String descricao;
    private int quantidade;
    private double valorUnitario;
    private double valorTotal;

    /**
     * Construtor para criar um novo item de nota fiscal
     * @param descricao
     * @param quantidade
     * @param valorUnitario 
     */
    public ItemNota(String descricao, int quantidade, double valorUnitario) {
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valorUnitario = valorUnitario;
        this.valorTotal = quantidade * valorUnitario;
    }

    /**
     * Construtor padrão
     */
    public ItemNota() {
    }

    /**
     * 
     * @return 
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * 
     * @param descricao 
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * 
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
     * 
     * @return 
     */
    public double getValorUnitario() {
        return valorUnitario;
    }

    /**
     * 
     * @param valorUnitario 
     */
    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    /**
     * 
     * @return 
     */
    public double getValorTotal() {
        return valorTotal;
    }

    /**
     * 
     * @param valorTotal 
     */
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    /**
     * Retorna uma representação textual do objeto ItemNota
     * @return 
     */
    @Override
    public String toString() {
        return String.format("%-30s | %-5d | R$ %-8.2f | R$ %-8.2f", descricao, quantidade, valorUnitario, valorTotal);
    }
}
