/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.time.LocalDateTime;
import java.util.Comparator;

/**
 * Implementa a interface Comparator para comparar dois objetos Agendamento com base na data do agendamento
 * @author luizp
 */
public class ComparaAgendamentoPorData implements Comparator<Agendamento>{
    /**
     * Compara dois agendamentos com base na data e hora
     * @param a1 primeiro agendamento
     * @param a2 segundo agendamento
     * @return 
     */
    @Override
    public int compare(Agendamento a1, Agendamento a2) {
        LocalDateTime data1 = a1.getData();
        LocalDateTime data2 = a2.getData();

        if (data1.isBefore(data2)) {
            return -1; // a1 vem antes de a2
        } else if (data1.isAfter(data2)) {
            return 1;  // a1 vem depois de a2
        } else {
            return 0;  // as datas são iguais
        }
    }
}
