/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.ArrayList;

/**
 * Representa um cliente da oficina mecânica.
 * Esta classe armazena os dados pessoais do cliente e gerencia um contador estático
 * para o número total de clientes.
 * @author Hudson
 */
public class Cliente {
    protected static int contadorDeVeiculos = 0;
    private static int contadorDeVeiculosPrivate = 0;
    private static int contadorClientes = 0;
    private int idCliente;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private long cpf;
    
    /**
     * Construtor para criar um novo cliente. Atribui um ID único e incrementa o
     * contador de clientes.
     * @param nome
     * @param endereco
     * @param telefone
     * @param email
     * @param cpf 
     */
    public Cliente(String nome, String endereco, String telefone, String email, int cpf) {
        Cliente.contadorClientes += 1;
        this.idCliente = this.contadorClientes;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
    }
    
    /**
     * Método de classe para obter a contagem de clientes instanciados.
     * @return 
     */
    public static String quantidadeDeInstanciasCliente(){
        return "A quantidade de clientes instânciados no sistema é: " + contadorClientes;
    }
     
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    
    public String getEndereco(){
        return endereco;
    }
    
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    public String getTelefone() {
        return telefone;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
    
    public long getCpf() {
        return cpf;
    }

    public int getContadorClientes() {
        return contadorClientes;
    }

    public void setContadorClientes(int contadorClientes) {
        this.contadorClientes = contadorClientes;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public static void incrementaContadorDeVeiculos(){
        contadorDeVeiculosPrivate += 1;
    }
    
    public static int getContadorDeVeiculos(){
        return contadorDeVeiculosPrivate;
    }

    public static void setContadorDeVeiculosPrivate(int contadorDeVeiculosPrivate) {
        Cliente.contadorDeVeiculosPrivate = contadorDeVeiculosPrivate;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone + ", email=" + email + ", cpf=" + cpf + '}';
    }    
}
