/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 * Representa um funcionário com o cargo de Mecânico. Esta classe herda de
 * Funcionario e implementa a interface Observer para poder ser notificada sobre
 * mudanças
 * @author luizp
 */
public class Mecanico extends Funcionario implements Observer{
    private String especialidade;

    public Mecanico() {
    }
    
    /**
     * Construtor da classe mecanico
     * @param nome
     * @param cargo
     * @param login
     * @param senha 
     */
    public Mecanico(String nome, String login, String senha, String especialidade) {
        super(nome, Cargo.Mecanico, login, senha);
        this.especialidade = especialidade;
    }

    /**
     * Construtor da classe mecanico
     * @param nome
     * @param cargo
     * @param login
     * @param senha 
     */
    public Mecanico(String nome, Cargo cargo, String login, String senha){
        super(nome, Cargo.Mecanico, login, senha);
    }

    /**
     * Construtor da classe mecanico
     * @param nome
     * @param login
     * @param senha
     * @param salario
     * @param especialidade 
     */
    public Mecanico(String nome, String login, String senha, double salario, String especialidade) {
        super(nome, Cargo.Mecanico, login, senha, salario);
        this.especialidade = especialidade;
    }

    /**
     * Define como o Mecânico reage ao ser notificado por um Subject
     * @param mensagem 
     */
    @Override
    public void atualizar(String mensagem) {
        System.out.println("--- Alerta para o Mecânico " + getNome() + " ---");
        System.out.println(">> Notificação de Serviço: " + mensagem);
        System.out.println("----------------------------------------------\n");
    }

    /**
     * Get especialidade
     * @return 
     */
    public String getEspecialidade() {
        return especialidade;
    }

    /**
     * set especialidade
     * @param especialidade 
     */
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    /**
     * Retorna uma representação textual do objeto Mecanico
     * @return 
     */
    @Override
    public String toString() {
        return super.toString() + " | Especialidade: " + especialidade;
    }
}
