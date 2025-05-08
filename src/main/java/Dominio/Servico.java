/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import Dominio.Peca;
import java.util.ArrayList;

/**
 *
 * @author luizp
 */
public class Servico {
    private String tipo;
    private double preco;
    private ArrayList<Peca> peca;

    public Servico(String tipo, double preco) {
        this.tipo = tipo;
        this.preco = preco;
    }

    public Servico(String tipo, double preco, ArrayList<Peca> peca) {
        this.tipo = tipo;
        this.preco = preco;
        this.peca = peca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public ArrayList<Peca> getPeca() {
        return peca;
    }

    public void setPeca(ArrayList<Peca> peca) {
        this.peca = peca;
    }

    @Override
    public String toString() {
        return "Servico{" + "tipo=" + tipo + ", preco=" + preco + ", peca=" + peca + '}';
    }
}
