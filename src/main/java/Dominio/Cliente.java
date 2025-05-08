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
    private String nome;
    private String endereco;
    private String telefone;
    private String email;
    private int cpf;
    
    public Cliente(String nome, String endereco, String telefone, String email, int cpf) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
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
    
    public void setCpf(int cpf) {
        this.cpf = cpf;
    }
    
    public int getCpf() {
        return cpf;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + ", endereco=" + endereco + ", telefone=" + telefone + ", email=" + email + ", cpf=" + cpf + '}';
    }    
}
