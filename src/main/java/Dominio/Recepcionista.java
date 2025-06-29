/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 * Representa um funcionário com o cargo de Recepcionista.
 * @author luizp
 */
public class Recepcionista extends Funcionario implements Observer{

    public Recepcionista() {
    }

    /**
     * Construtor da classe Recepcionista
     * @param nome
     * @param login
     * @param senha 
     */
    public Recepcionista(String nome, String login, String senha) {
        super(nome, Cargo.Recepcionista, login, senha);
    }

    /**
     * Construtor para criar um Recepcionista
     * @param nome
     * @param login
     * @param senha
     * @param salario 
     */
    public Recepcionista(String nome, String login, String senha, double salario) {
        super(nome, Cargo.Recepcionista, login, senha, salario);
    }
    
    /**
     * Recebe atualização e exibe uma notificação no console
     * @param mensagem 
     */
    @Override
    public void atualizar(String mensagem) {
        System.out.println("--- Alerta para o Recepcionista " + getNome() + " ---");
        if (mensagem.contains("PRONTO_PARA_ENTREGA")){
            System.out.println("Entrar em contato com cliente");
            System.out.println(">> Notificação de Serviço: " + mensagem);
            System.out.println("----------------------------------------------\n");
        } else{
            System.out.println(">> Notificação de Serviço: " + mensagem);
            System.out.println("----------------------------------------------\n");
        }
        
    }
    
    /**
     * Retorna a representação textual do funcionário
     * @return 
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
