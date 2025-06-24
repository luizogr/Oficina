/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.Comparator;

/**
 *
 * @author luizp
 */
public class ComparaAgendamentoPorCliente implements Comparator<Agendamento>{
    @Override
    public int compare(Agendamento a1, Agendamento a2) {
        return Integer.compare(a1.getIdCliente(), a2.getIdCliente());
    }
}
