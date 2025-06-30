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
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Gerencia o agendamento de serviços nos elevadores da oficina
 * @author luizp
 */
public class Agenda {
    private Map<LocalDateTime, Map<Integer, Agendamento>> dataElevadorAgendamento;
    private ArrayList<Agendamento> todosAgendamentos;
    private static final String CAMINHO_ARQUIVO = "agenda.json";
    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * Construtor padrão
     */
    public Agenda() {
        this.dataElevadorAgendamento = new HashMap<>();
        this.todosAgendamentos = new ArrayList<>();
        mapper.registerModule(new JavaTimeModule());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }
    
    /**
     * Salva o estado atual da lista de agendamentos em um arquivo JSON
     */
    private void salvarNoArquivo() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(CAMINHO_ARQUIVO), this);
            System.out.println("Agenda salva com sucesso.");
        } catch (IOException e) {
            System.err.println("Erro ao salvar a agenda: " + e.getMessage());
        }
    }
    
    /**
     * Carrega a agenda a partir do arquivo JSON
     * @return 
     */
    public static Agenda carregarDoArquivo() {
        try {
            File arquivo = new File(CAMINHO_ARQUIVO);
            if (arquivo.exists() && arquivo.length() > 0) {
                ObjectMapper localMapper = new ObjectMapper();
                localMapper.registerModule(new JavaTimeModule());
                Agenda agenda = localMapper.readValue(arquivo, Agenda.class);
                
                agenda.reconstruirMapaDeConflitos(); 
                
                int maxIdAgendamento = 0;
                if (agenda.getTodosAgendamentos() != null) {
                    for(Agendamento a : agenda.getTodosAgendamentos()){
                        if(a.getIdAgendamento() > maxIdAgendamento){ 
                            maxIdAgendamento = a.getIdAgendamento(); 
                        }
                    }
                }
                Agendamento.setContadorId(maxIdAgendamento);
                
                return agenda;
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar a agenda: " + e.getMessage());
        }
        return new Agenda();
    }
    
    /**
     * Reconstrói o mapa de verificação de conflitos a partir da lista principal de agendamentos
     */
    private void reconstruirMapaDeConflitos() {
        this.dataElevadorAgendamento.clear();
        for (Agendamento ag : this.todosAgendamentos) {
            if (ag.getStatus() == StatusAgendamento.Agendado) {
                 dataElevadorAgendamento.computeIfAbsent(ag.getData(), k -> new HashMap<>()).put(ag.getIdElevador(), ag);
            }
        }
    }
    
    /**
     * Metodo para salvar publico
     */
    public void salvar(){
        salvarNoArquivo();
    }
    
    /**
     * Verifica se já existe um agendamento para uma data e elevador
     * @param data
     * @param idElevador
     * @return 
     */
    public boolean existeAgendamento(LocalDateTime data, int idElevador){
        return (dataElevadorAgendamento.containsKey(data) && dataElevadorAgendamento.get(data).containsKey(idElevador));
    }
    
    /**
     * Busca um agendamento na lista principal pelo seu ID
     * @param id
     * @return 
     */
    public Agendamento buscarAgendamentoPorId(int id) {
        for (Agendamento agendamento : todosAgendamentos) {
            if (agendamento.getIdAgendamento() == id) {
                return agendamento;
            }
        }
        return null;
    }
    
    /**
     * Tenta adicionar um novo agendamento à agenda
     * @param a
     * @return 
     */
    public boolean agendar(Agendamento a){
        LocalDateTime data = a.getData();
        int idElevador = a.getIdElevador();
        
        if(existeAgendamento(data, idElevador) == false){
            dataElevadorAgendamento.computeIfAbsent(data, k -> new HashMap<>()).put(idElevador, a);
            todosAgendamentos.add(a);
            return true;
        }
        System.out.println("Horario Ocupado");
        return false;
    }
    
    /**
     * Cancela um agendamento existente
     * @param idAgendamento
     * @return 
     */
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
            a.setStatus(StatusAgendamento.Cancelado);
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Inicia o serviço de um agendamento
     * @param idAgendamento
     * @param idMecanico
     * @return 
     */
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
        OrdemDeServico os = new OrdemDeServico(a.getPlacaVeiculo(), a.getIdCliente(), a.getDescricao(), a.getIdElevador(), LocalDateTime.now(), idMecanico, StatusOS.EM_MANUTENCAO);
        return os;
    }
    
    /**
     * Imprime todos os agendamentos contidos na lista
     */
    public void imprimirAgenda() {
        System.out.println("--- Lista de Todos os Agendamentos ---");
        if (todosAgendamentos.isEmpty()) {
            System.out.println("Nenhum agendamento encontrado.");
        } else {
            for (Agendamento ag : todosAgendamentos) {
                System.out.println(ag);
            }
        }
        System.out.println("--------------------------------------");
    }

    /**
     * 
     * @return 
     */
    public Map<LocalDateTime, Map<Integer, Agendamento>> getDataElevadorAgendamento() {
        return dataElevadorAgendamento;
    }

    /**
     * 
     * @param dataElevadorAgendamento 
     */
    public void setDataElevadorAgendamento(Map<LocalDateTime, Map<Integer, Agendamento>> dataElevadorAgendamento) {
        this.dataElevadorAgendamento = dataElevadorAgendamento;
    }

    /**
     * 
     * @return 
     */
    public ArrayList<Agendamento> getTodosAgendamentos() {
        return todosAgendamentos;
    }

    /**
     * 
     * @param todosAgendamentos 
     */
    public void setTodosAgendamentos(ArrayList<Agendamento> todosAgendamentos) {
        this.todosAgendamentos = todosAgendamentos;
    }

    /**
     * Retorna uma representação textual da agenda
     * @return 
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- Relatório de Agendamentos ---\n");
        for (Agendamento ag : todosAgendamentos) {
            sb.append(ag.toString()).append("\n");
        }
        sb.append("---------------------------------");
        return sb.toString();
    }
}
