/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 * Representa um funcionário com o cargo de Gerente
 * @author luizp
 */
public class Gerente extends Funcionario implements Observer{

    /**
     * Construtor padrão
     */
    public Gerente() {
    }
    
    /**
     * Construtor da classe gerente
     * @param nome
     * @param cargo
     * @param login
     * @param senha 
     */
    public Gerente(String nome, String login, String senha){
        super(nome, Cargo.Gerente, login, senha);
    }  

    /**
     * Construtor da classe gerente
     * @param nome
     * @param cargo
     * @param login
     * @param senha
     * @param salario 
     */
    public Gerente(String nome, String login, String senha, double salario) {
        super(nome, Cargo.Gerente, login, senha, salario);
    }

    /**
     * Define como o Gerente reage ao ser notificado por um Subject
     * @param mensagem 
     */
    @Override
    public void atualizar(String mensagem) {
        System.out.println("--- Alerta para o Gerente " + getNome() + " ---");
        System.out.println(">> Evento: " + mensagem);
        System.out.println("----------------------------------------------\n");
    }
    
    /**
     * Retorna uma representação textual do objeto Gerente
     * @return 
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
