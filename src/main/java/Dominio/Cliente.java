/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author Hudson
 */
public class Cliente {
    private static int contadorClientes = 0;
    private int idCliente;
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private long cpf;
    
    public Cliente(String nome, String endereco, String telefone, String email, int cpf) {
        this.contadorClientes += 1;
        this.idCliente = this.contadorClientes;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
    }
    
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
    
    

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone + ", email=" + email + ", cpf=" + cpf + '}';
    }    
}
