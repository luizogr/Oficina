/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.time.LocalDate;

/**
 * Representa um Lote de Compra de uma determinada peça.
 * Armazena a quantidade, o custo unitário e o fornecedor para uma compra específica.
 * @author luizp
 */
public class LotePeca {
    private int idFornecedor;
    private int quantidade;
    private double precoCusto;
    private LocalDate dataCompra;

    public LotePeca(int idFornecedor, int quantidade, double precoCusto, LocalDate dataCompra) {
        this.idFornecedor = idFornecedor;
        this.quantidade = quantidade;
        this.precoCusto = precoCusto;
        this.dataCompra = dataCompra;
    }

    public LotePeca() {
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public double getPrecoCusto() {
        return precoCusto;
    }

    public LocalDate getDataCompra() {
        return dataCompra;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "LotePeca{" + "idFornecedor=" + idFornecedor + ", quantidade=" + quantidade + ", precoCusto=" + precoCusto + ", dataCompra=" + dataCompra + '}';
    }
}
