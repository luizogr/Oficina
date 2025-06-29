/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Representa uma única transação financeira no sistema, que pode ser uma receita ou uma despesa
 * @author luizp
 */
public class Lancamento implements Serializable{
    private String descricao;
    private double valor;
    private LocalDate data;
    private TipoLancamento tipo;
    private CategoriaDespesa categoria;

    /**
     * Construtor padrão
     */
    public Lancamento() {
    }

    /**
     * Construtor para criar um novo lançamento financeiro
     * @param descricao
     * @param valor
     * @param data
     * @param tipo
     * @param categoria 
     */
    public Lancamento(String descricao, double valor, LocalDate data, TipoLancamento tipo, CategoriaDespesa categoria) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.tipo = tipo;
        this.categoria = categoria;
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
    public double getValor() {
        return valor;
    }

    /**
     * 
     * @param valor 
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * 
     * @return 
     */
    public LocalDate getData() {
        return data;
    }

    /**
     * 
     * @param data 
     */
    public void setData(LocalDate data) {
        this.data = data;
    }

    /**
     * 
     * @return 
     */
    public TipoLancamento getTipo() {
        return tipo;
    }

    /**
     * 
     * @param tipo 
     */
    public void setTipo(TipoLancamento tipo) {
        this.tipo = tipo;
    }

    /**
     * 
     * @return 
     */
    public CategoriaDespesa getCategoria() {
        return categoria;
    }

    /**
     * 
     * @param categoria 
     */
    public void setCategoria(CategoriaDespesa categoria) {
        this.categoria = categoria;
    }
    
    /**
     * Retorna uma representação textual do objeto Lancamento
     * @return 
     */
    @Override
    public String toString() {
        String tipoStr = (tipo == TipoLancamento.Receita) ? "RECEITA" : "DESPESA";
        String categoriaStr = (categoria != null) ? categoria.toString() : "N/A";
        return String.format("%s | %-10s | %-35s | Categoria: %-15s | Valor: R$ %.2f", data, tipoStr, descricao, categoriaStr, valor);
    }
    
    
}
