/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicos;

import Dominio.Agendamento;
import Dominio.Elevador;
import Dominio.OrdemDeServico;
import Dominio.StatusAgendamento;
import Dominio.StatusOS;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
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
    private ArrayList<Agendamento> todosAgendamentos;
    private static final String CAMINHO_ARQUIVO = "agenda.json";
    private static final ObjectMapper mapper = new ObjectMapper();

    public Agenda() {
        this.dataElevadorAgendamento = new HashMap<>();
        this.todosAgendamentos = new ArrayList<>();
    }
    
    public void salvarNoArquivo() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(CAMINHO_ARQUIVO), this);
            System.out.println("Agenda salva com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao salvar a agenda: " + e.getMessage());
        }
    }
    
    public static Agenda carregarDoArquivo() {
        try {
            File arquivo = new File(CAMINHO_ARQUIVO);
            if (arquivo.exists()) {
                return mapper.readValue(arquivo, Agenda.class);
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar a agenda: " + e.getMessage());
        }
        return new Agenda(); // se falhar, retorna uma agenda vazia
    }
    
    public boolean existeAgendamento(LocalDateTime data, int idElevador){
        return (dataElevadorAgendamento.containsKey(data) && dataElevadorAgendamento.get(data).containsKey(idElevador));
    }
    
    public Agendamento buscarAgendamentoPorId(int id) {
        for (Agendamento agendamento : todosAgendamentos) {
            if (agendamento.getIdAgendamento() == id) {
                return agendamento;
            }
        }
        return null;
    }
    
    public boolean agendar(Agendamento a){
        LocalDateTime data = a.getData();
        int idElevador = a.getIdElevador();
        
        if(existeAgendamento(data, idElevador) == false){
            dataElevadorAgendamento.computeIfAbsent(data, k -> new HashMap<>()).put(idElevador, a);
            todosAgendamentos.add(a);
            salvarNoArquivo();
            return true;
        }
        return false;
    }
    
    public boolean cancelarAgendamento(int idAgendamento){
        Agendamento a = buscarAgendamentoPorId(idAgendamento);
        
        if (a == null){
            System.err.println("Erro: Agendamento com ID " + idAgendamento + " não encontrado.");
            return false;
        } else if(a.getStatus() == StatusAgendamento.Agendado){
            LocalDateTime data = a.getData();
            int idElevador = a.getIdElevador();
            if (dataElevadorAgendamento.containsKey(data)) {
                dataElevadorAgendamento.get(data).remove(idElevador);
                if(dataElevadorAgendamento.get(data).isEmpty()) {
                    dataElevadorAgendamento.remove(data);
                }
            }
            todosAgendamentos.remove(a);
            salvarNoArquivo();
            return true;
        } else {
            return false;
        }
    }
    
    public OrdemDeServico IniciarServico(int idAgendamento, int idMecanico){
        Agendamento a = buscarAgendamentoPorId(idAgendamento);

        if (a == null) {
            System.err.println("Erro: Agendamento com ID " + idAgendamento + " não encontrado.");
            return null;
        }
        if (a.getStatus() != StatusAgendamento.Agendado) {
            System.err.println("Erro: Este serviço não pode ser iniciado, pois seu status é " + a.getStatus());
            return null;
        }
        
        a.setStatus(StatusAgendamento.EmManutencao);
        OrdemDeServico os = new OrdemDeServico(a.getIdVeiculo(), a.getIdCliente(), a.getDescricao(), a.getIdElevador(), LocalDateTime.now(), idMecanico, StatusOS.EM_MANUTENCAO);
        return os;
    }

    public Map<LocalDateTime, Map<Integer, Agendamento>> getDataElevadorAgendamento() {
        return dataElevadorAgendamento;
    }

    public void setDataElevadorAgendamento(Map<LocalDateTime, Map<Integer, Agendamento>> dataElevadorAgendamento) {
        this.dataElevadorAgendamento = dataElevadorAgendamento;
    }

    public ArrayList<Agendamento> getTodosAgendamentos() {
        return todosAgendamentos;
    }

    public void setTodosAgendamentos(ArrayList<Agendamento> todosAgendamentos) {
        this.todosAgendamentos = todosAgendamentos;
    }

    @Override
    public String toString() {
        return "Agenda{" + "dataElevadorAgendamento=" + dataElevadorAgendamento + ", todosAgendamentos=" + todosAgendamentos + '}';
    }
    
    
    
}
