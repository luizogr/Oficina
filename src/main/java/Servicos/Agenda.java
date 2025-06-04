/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicos;

import Dominio.Agendamento;
import Dominio.Elevador;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author luizp
 */
public class Agenda {
    private Map<LocalDateTime, Map<Integer, Agendamento>> dataElevadorAgendamento;
    private Map<Integer, List<Agendamento>> agendamentosPorElevador;

    public Agenda() {
        this.dataElevadorAgendamento = new HashMap<>();
        this.agendamentosPorElevador = new HashMap<>();
    }
    
    public boolean agendar(Agendamento a){
        LocalDateTime data = a.getData();
        return false;
    }
    
}
