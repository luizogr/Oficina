/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Representa um cliente da oficina mecânica.
 * Esta classe armazena os dados pessoais do cliente e gerencia um contador estático
 * para o número total de clientes.
 * @author Hudson
 */
public class Cliente implements Serializable{
    private static int contadorClientes = 0;
    protected static int contadorDeVeiculos = 0;
    private static int contadorDeVeiculosPrivate = 0;
    
    private int idCliente;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private long cpf;

    /**
     * Construtor padrão
     */
    public Cliente() {
    }
    
    /**
     * Construtor para criar um novo cliente. Atribui um ID único e incrementa o
     * contador de clientes.
     * @param nome
     * @param endereco
     * @param telefone
     * @param email
     * @param cpf 
     */
    public Cliente(String nome, String endereco, String telefone, String email, long cpf) {
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
     
    /**
     * 
     * @param nome 
     */
    public void setNome(String nome){
        this.nome = nome;
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
     * @param endereco 
     */
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    
    /**
     * 
     * @return 
     */
    public String getEndereco(){
        return endereco;
    }
    
    /**
     * 
     * @param telefone 
     */
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    
    /**
     * 
     * @return 
     */
    public String getTelefone() {
        return telefone;
    }
    
    /**
     * 
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * 
     * @return 
     */
    public String getEmail() {
        return email;
    }
    
    /**
     * 
     * @param cpf 
     */
    public void setCpf(long cpf) {
        this.cpf = cpf;
    }
    
    /**
     * 
     * @return 
     */
    public long getCpf() {
        return cpf;
    }
    /**
     * Retorna o CPF de forma pseudo-anonimizada
     * @return 
     */
    @JsonIgnore
    public String getCpfAnonimizado() {
        String cpfStr = String.format("%011d", cpf);
        return "***.***." + cpfStr.substring(6, 9) + "-" + cpfStr.substring(9);
    }

    /**
     * 
     * @return 
     */
    @JsonIgnore
    public static int getContadorClientes() {
        return contadorClientes;
    }

    /**
     * 
     * @param contadorClientes 
     */
    @JsonIgnore
    public static void setContadorClientes(int contadorClientes) {
        Cliente.contadorClientes = contadorClientes;
    }

    /**
     * 
     * @return 
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * 
     * @param idCliente 
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Incrementa o contador de veículos de forma segura
     */
    public static void incrementaContadorDeVeiculos(){
        contadorDeVeiculosPrivate += 1;
    }
    
    /**
     * Retorna a contagem de veículos
     * @return 
     */
    public static int getContadorDeVeiculos(){
        return contadorDeVeiculosPrivate;
    }

    /**
     * Define a contagem de veículos
     * @param contadorDeVeiculosPrivate 
     */
    public static void setContadorDeVeiculosPrivate(int contadorDeVeiculosPrivate) {
        Cliente.contadorDeVeiculosPrivate = contadorDeVeiculosPrivate;
    }
    
    /**
     * Retorna a contagem de veículos do contador protected
     * @return 
     */
    public static int getContadorDeVeiculosProtected() {
        return contadorDeVeiculos;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return "Cliente | ID: " + idCliente + " | Nome: " + nome + " | E-mail: " + email + " | Endereço: " + endereco + " | CPF: " + getCpfAnonimizado();
    }    
}
