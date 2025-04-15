/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author luizp
 */
public class Funcionario {
    private String nome;
    private String cargo;
    private String login;
    private String senha;
    
    public Funcionario(String nome, String cargo, String login, String senha){
        this.nome = nome;
        this.cargo = cargo;
        this. login = login;
        this.senha = senha;
    }
    
    public boolean validaDados(String login, String senha){
        if (this.login == login && this.senha == senha){
            return true;
        } else {
            return false;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }
}
