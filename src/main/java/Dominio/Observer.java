/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dominio;

/**
 * Define o contrato para objetos que desejam ser notificados
 * @author luizp
 */
public interface Observer {
    /**
     * Metodo para receber uma notificação
     * @param mensagem
     */
    void atualizar(String mensagem);
}
