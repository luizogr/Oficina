/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.Comparator;

/**
 * Implementa a interface Comparator para comparar dois objetos Agendamento com base no ID do cliente
 * @author luizp
 */
public class ComparaAgendamentoPorCliente implements Comparator<Agendamento>{
    /**
     * Compara dois agendamentos com base em seus IDs de cliente
     * @param a1 o primeiro agendamento a ser comparado
     * @param a2 o segundo agendamento a ser comparado
     * @return 
     */
    @Override
    public int compare(Agendamento a1, Agendamento a2) {
        if(a1.getIdCliente() < a2.getIdCliente()){
            return -1;
        }
        if(a1.getIdCliente() > a2.getIdCliente()){
            return 1;
        }
        return 0;
    }
}
