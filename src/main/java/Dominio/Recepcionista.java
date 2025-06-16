/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author luizp
 */
public class Recepcionista extends Funcionario implements Observer{

    public Recepcionista(String nome, String login, String senha) {
        super(nome, Cargo.Recepcionista, login, senha);
    }

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
    
    
}
