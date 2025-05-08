/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author luizp
 */
public class Gerente extends Mecanico{
    /**
     * Construtor da classe gerente
     * @param nome
     * @param cargo
     * @param login
     * @param senha 
     */
    public Gerente(String nome, Cargo cargo, String login, String senha){
        super(nome, Cargo.Gerente, login, senha);
        setCargo(Cargo.Gerente);
    }                           
}
