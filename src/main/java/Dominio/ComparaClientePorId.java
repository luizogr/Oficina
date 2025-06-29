/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.Comparator;

/**
 * Implementa a interface Comparator para comparar dois objetos Cliente com base em seu ID
 * @author luizp
 */
public class ComparaClientePorId implements Comparator<Cliente>{
    /**
     * Compara dois clientes com base em seus IDs
     * @param c1 o primeiro cliente a ser comparado
     * @param c2 o segundo cliente a ser comparado
     * @return 
     */
    @Override
    public int compare(Cliente c1, Cliente c2) {
        if(c1.getIdCliente() < c2.getIdCliente()){
            return -1;
        }
        if(c1.getIdCliente() > c2.getIdCliente()){
            return 1;
        }
        return 0;
    }
}
