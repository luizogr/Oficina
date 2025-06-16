/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author luizp
 */
public class Mecanico extends Funcionario implements Observer{
    private String especialidade;
    
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

    @Override
    public String toString() {
        return "Mecanico{" + "especialidade=" + especialidade + '}';
    }
}
