/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dominio;

/**
 * Define o contrato para objetos que tem um estado que possa ser observado
 * @author luizp
 */
public interface Subject {
    void adicionarObserver(Observer observer);
    void removerObserver(Observer observer);
    void notificarObserver();
}
