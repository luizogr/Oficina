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
    private static int contadorId = 0;
    private int idFuncionario;
    private String nome;
    private Cargo cargo;
    private String login;
    private String senha;
    
    /**
     * Construtor da classe funcionario
     * @param nome 
     * @param cargo
     * @param login
     * @param senha 
     */
    public Funcionario(String nome, Cargo cargo, String login, String senha){
        this.contadorId += 1;
        this.idFuncionario = contadorId;
        this.nome = nome;
        this.cargo = cargo;
        this. login = login;
        this.senha = senha;
    }
    
    /**
     * Metodo para validar os dados do funcionario
     * @param login
     * @param senha
     * @return Rtorna true se senha e login forem iguais ao do funcionario
     */
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
}
