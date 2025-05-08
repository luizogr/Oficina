/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author luizp
 */
public class Peca {
    //preciso estudar como colocar o id
    private String nome;
    private double preco;
    private int quantide;

    public Peca(String nome, double preco, int quantide) {
        this.nome = nome;
        this.preco = preco;
        this.quantide = quantide;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantide() {
        return quantide;
    }

    public void setQuantide(int quantide) {
        this.quantide = quantide;
    }

    @Override
    public String toString() {
        return "Peca{" + "nome=" + nome + ", preco=" + preco + ", quantide=" + quantide + '}';
    }
}
