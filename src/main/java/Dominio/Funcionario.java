/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.io.Serializable;

/**
 * Representa um funcionário genérico da oficina.
 * @author luizp
 */
public class Funcionario implements Serializable{
    private static int contadorId = 0;
    private int idFuncionario;
    private String nome;
    private Cargo cargo;
    private String login;
    private String senha;
    private double salario;

    /**
     * Contrutor padrao para o Jackson
     */
    public Funcionario() {
    }
    
    /**
     * Construtor da classe funcionario
     * @param nome 
     * @param cargo
     * @param login
     * @param senha 
     */
    public Funcionario(String nome, Cargo cargo, String login, String senha){
        Funcionario.contadorId += 1;
        this.idFuncionario = contadorId;
        this.nome = nome;
        this.cargo = cargo;
        this.login = login;
        this.senha = senha;
    }

    /**
     * Construtor da classe funcionario
     * @param nome
     * @param cargo
     * @param login
     * @param senha
     * @param salario 
     */
    public Funcionario(String nome, Cargo cargo, String login, String senha, double salario) {
        Funcionario.contadorId += 1;
        this.idFuncionario = contadorId;
        this.nome = nome;
        this.cargo = cargo;
        this.login = login;
        this.senha = senha;
        this.salario = salario;
    }

    public Funcionario(String nome, String login, String senha) {
        Funcionario.contadorId += 1;
        this.idFuncionario = contadorId;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public static int getContadorId() {
        return contadorId;
    }

    public static void setContadorId(int contadorId) {
        Funcionario.contadorId = contadorId;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
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

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    /**
     * Sobrescreve o metodo toString
     * @return 
     */
    @Override
    public String toString() {
        return "Funcionario | ID: " + idFuncionario + " | Nome: " + nome + " | Cargo: " + cargo;
    }
}
