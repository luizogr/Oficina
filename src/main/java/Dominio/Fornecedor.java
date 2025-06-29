/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.io.Serializable;

/**
 * Representa um fornecedor de peças para a oficina
 * @author luizp
 */
public class Fornecedor implements Serializable{
    private static int contadorId = 0;
    private int idFornecedor;
    private String nome;

    /**
     * Construtor para criar um novo fornecedor
     * @param nome 
     */
    public Fornecedor(String nome) {
        Fornecedor.contadorId += 1;
        this.idFornecedor = Fornecedor.contadorId;
        this.nome = nome;
    }

    /**
     * Construtor padrão
     */
    public Fornecedor() {
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
     * Retorna uma representação textual do objeto Fornecedor
     * @return 
     */
    @Override
    public String toString() {
        return "Fornecedor | ID: " + idFornecedor + " | Nome: " + nome;
    }
    
    
}
