/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author luizp
 */
public class Fornecedor {
    private static int contadorId = 0;
    private int idFornecedor;
    private String nome;

    public Fornecedor(String nome) {
        Fornecedor.contadorId += 1;
        this.idFornecedor = Fornecedor.contadorId;
        this.nome = nome;
    }

    public Fornecedor() {
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public String toString() {
        return "Fornecedor | ID: " + idFornecedor + " | Nome: " + nome;
    }
    
    
}
