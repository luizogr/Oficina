/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.time.LocalDate;

/**
 *
 * @author luizp
 */
public class Lancamento {
    private String descricao;
    private double valor;
    private LocalDate data;
    private TipoLancamento tipo;
    private CategoriaDespesa categoria;

    public Lancamento(String descricao, double valor, LocalDate data, TipoLancamento tipo, CategoriaDespesa categoria) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.tipo = tipo;
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public TipoLancamento getTipo() {
        return tipo;
    }

    public void setTipo(TipoLancamento tipo) {
        this.tipo = tipo;
    }

    public CategoriaDespesa getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDespesa categoria) {
        this.categoria = categoria;
    }
    
    

    @Override
    public String toString() {
        return "Lancamento{" + "descricao=" + descricao + ", valor=" + valor + ", data=" + data + ", tipo=" + tipo + ", categoria=" + categoria + '}';
    }
    
    
}
