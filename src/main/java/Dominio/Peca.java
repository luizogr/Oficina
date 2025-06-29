/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.io.Serializable;

/**
 * Representa uma Peça
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

    /**
     * 
     * @return 
     */
    public String getNome() {
        return nome;
    }

    /**
     * 
     * @param nome 
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * 
     * @return 
     */
    public double getPreco() {
        return precoVenda;
    }

    /**
     * 
     * @param preco 
     */
    public void setPreco(double preco) {
        this.precoVenda = preco;
    }

    /**
     * 
     * @return 
     */
    public static int getContadorPeca() {
        return contadorPeca;
    }

    /**
     * 
     * @return 
     */
    public int getIdPeca() {
        return idPeca;
    }

    /**
     * 
     * @param contadorPeca 
     */
    public static void setContadorPeca(int contadorPeca) {
        Peca.contadorPeca = contadorPeca;
    }

    /**
     * 
     * @param idPeca 
     */
    public void setIdPeca(int idPeca) {
        this.idPeca = idPeca;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return "Peça | ID #" + idPeca + " | Nome: " + nome + " | Preço: R$" + String.format("%.2f", precoVenda);
    }
}
