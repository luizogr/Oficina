/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.io.Serializable;

/**
 *
 * @author luizp
 */
public class Peca implements Serializable{
    private static int contadorPeca = 0;
    private int idPeca;
    private String nome;
    private double precoVenda;
    
    /**
     * Construtor padrão
     */
    public Peca(){
    }

    /**
     * Construtor para criar uma nova peça.
     * Atribui um ID único e incrementa o contador global de peças.
     * @param nome
     * @param preco 
     */
    public Peca(String nome, double preco) {
        Peca.contadorPeca += 1;
        this.idPeca = Peca.contadorPeca;
        this.nome = nome;
        this.precoVenda = preco;
        //this.quantide = quantide;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return precoVenda;
    }

    public void setPreco(double preco) {
        this.precoVenda = preco;
    }

//    public int getQuantide() {
//        return quantide;
//    }
//
//    public void setQuantide(int quantide) {
//        this.quantide = quantide;
//    }

    public static int getContadorPeca() {
        return contadorPeca;
    }

    public int getIdPeca() {
        return idPeca;
    }

    public static void setContadorPeca(int contadorPeca) {
        Peca.contadorPeca = contadorPeca;
    }

    public void setIdPeca(int idPeca) {
        this.idPeca = idPeca;
    }

    @Override
    public String toString() {
        return "Peca{" + "nome=" + nome + ", preco=" + precoVenda + ", quantide=" + '}';
    }
}
