/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author luizp
 */
public class Gerente extends Funcionario implements Observer{

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

    @Override
    public void atualizar(String mensagem) {
        System.out.println("--- Alerta para o Gerente " + getNome() + " ---");
        System.out.println(">> Evento: " + mensagem);
        System.out.println("----------------------------------------------\n");
    }
    
    @Override
    public String toString() {
        return super.toString();
    }
}
