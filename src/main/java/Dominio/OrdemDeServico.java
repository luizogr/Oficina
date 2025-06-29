/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Representa uma Ordem de Serviço
 * @author luizp
 */
public class OrdemDeServico implements Subject, Serializable{
    private static int contadorOS = 0;
    private int idOS;
    private String placaVeiculo;
    private int idCliente;
    private String descricao;
    private int idElevador;
    private LocalDateTime dataInicio;
    private LocalDateTime dataTermino;
    private int idMecanico;
    private StatusOS statusOS;
    private Map<Integer, Integer> pecasUtilizadas;
    private List<Servicos> servicosRealizados;
    
    @JsonIgnore
    private List<Observer> observers = new ArrayList<>();
    @JsonIgnore
    private String ultimaAtualizacao;

    /**
     * Construtor para criar uma Ordem de Serviço
     * @param placaVeiculo
     * @param idCliente
     * @param descricao
     * @param idElevador
     * @param dataInicio
     * @param dataTermino
     * @param idMecanico
     * @param pecasUtilizadas
     * @param servicosRealizados 
     */
    public OrdemDeServico(String placaVeiculo, int idCliente, String descricao, int idElevador, LocalDateTime dataInicio, LocalDateTime dataTermino, int idMecanico, Map<Integer, Integer> pecasUtilizadas, List<Servicos> servicosRealizados) {
        OrdemDeServico.contadorOS += 1;
        this.idOS = contadorOS;
        this.placaVeiculo = placaVeiculo;
        this.idCliente = idCliente;
        this.descricao = descricao;
        this.idElevador = idElevador;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.idMecanico = idMecanico;
        this.pecasUtilizadas = new HashMap<>();
        this.servicosRealizados = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    /**
     * Construtor para criar uma Ordem de Serviço
     * @param placaVeiculo
     * @param idCliente
     * @param descricao
     * @param idElevador
     * @param dataInicio
     * @param idMecanico
     * @param statusOS
     * @param pecasUtilizadas
     * @param servicosRealizados 
     */
    public OrdemDeServico(String placaVeiculo, int idCliente, String descricao, int idElevador, LocalDateTime dataInicio, int idMecanico, StatusOS statusOS, Map<Integer, Integer> pecasUtilizadas, List<Servicos> servicosRealizados) {
        OrdemDeServico.contadorOS += 1;
        this.idOS = contadorOS;
        this.placaVeiculo = placaVeiculo;
        this.idCliente = idCliente;
        this.descricao = descricao;
        this.idElevador = idElevador;
        this.dataInicio = dataInicio;
        this.idMecanico = idMecanico;
        this.statusOS = statusOS;
        this.pecasUtilizadas = new HashMap<>();
        this.servicosRealizados = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    /**
     * Construtor para criar uma Ordem de Serviço
     * @param placaVeiculo
     * @param idCliente
     * @param descricao
     * @param idElevador
     * @param dataInicio
     * @param idMecanico
     * @param statusOS 
     */
    public OrdemDeServico(String placaVeiculo, int idCliente, String descricao, int idElevador, LocalDateTime dataInicio, int idMecanico, StatusOS statusOS) {
        OrdemDeServico.contadorOS += 1;
        this.idOS = contadorOS;
        this.placaVeiculo = placaVeiculo;
        this.idCliente = idCliente;
        this.descricao = descricao;
        this.idElevador = idElevador;
        this.dataInicio = dataInicio;
        this.idMecanico = idMecanico;
        this.statusOS = statusOS;
        this.pecasUtilizadas = new HashMap<>();
        this.servicosRealizados = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    /**
     * Construtor para criar uma Ordem de Serviço
     * @param placaVeiculo
     * @param idCliente
     * @param descricao 
     */
    public OrdemDeServico(String placaVeiculo, int idCliente, String descricao) {
        OrdemDeServico.contadorOS += 1;
        this.idOS = contadorOS;
        this.placaVeiculo = placaVeiculo;
        this.idCliente = idCliente;
        this.descricao = descricao;
        this.pecasUtilizadas = new HashMap<>();
        this.servicosRealizados = new ArrayList<>();
        this.observers = new ArrayList<>();
    }

    /**
     * Construtor padrão
     */
    public OrdemDeServico() {
        OrdemDeServico.contadorOS += 1;
        this.idOS = contadorOS;
        this.pecasUtilizadas = new HashMap<>();
        this.servicosRealizados = new ArrayList<>();
        this.observers = new ArrayList<>();
    }
  
    /**
     * Adiciona uma quantidade de uma determinada peça à lista de peças utilizadas
     * @param idPeca
     * @param quantidade 
     */
    public void adicionarPeca(int idPeca, int quantidade) {
        int qtdAtual = pecasUtilizadas.getOrDefault(idPeca, 0);
        pecasUtilizadas.put(idPeca, qtdAtual + quantidade);
    }
 
    /**
     * Remove uma quantidade de uma determinada peça da lista
     * @param idPeca
     * @param quantidade 
     */
    public void removerPeca(int idPeca, int quantidade) {
        int qtdAtual = pecasUtilizadas.getOrDefault(idPeca, 0);
        if(quantidade > qtdAtual){
            throw new RuntimeException("Quantidade a ser removida maior que aquantidade utilizada");
        } else{
           pecasUtilizadas.put(idPeca, qtdAtual - quantidade); 
        }
    }

    /**
     * Adiciona observadores
     * @param observer 
     */
    @Override
    public void adicionarObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Remove observadores
     * @param observer 
     */
    @Override
    public void removerObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Dispara notificação aos observadores
     */
    @Override
    public void notificarObserver() {
        for(Observer o: observers){
            try{
                o.atualizar(ultimaAtualizacao);
            } catch (Exception e){
                System.err.println("Falha ao notificar observadores");
            }
        }
    }
  
    /**
     * 
     * @return 
     */
    public StatusOS getStatusOS() {
        return statusOS;
    }

    /**
     * 
     * @param statusOS 
     */
    public void setStatusOS(StatusOS statusOS) {
        this.statusOS = statusOS;
        this.ultimaAtualizacao = "A OS #" + idOS + " (" + descricao + ") mudou para: " + statusOS;
        notificarObserver();
    }

    /**
     * 
     * @return 
     */
    public int getIdOS() {
        return idOS;
    }

    /**
     * 
     * @param idOS 
     */
    public void setIdOS(int idOS) {
        this.idOS = idOS;
    }

    /**
     * 
     * @return 
     */
    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    /**
     * 
     * @param placaVeiculo 
     */
    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }
 
    /**
     * 
     * @return 
     */
    public int getIdCliente() {
        return idCliente;
    }

    /**
     * 
     * @param idCliente 
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * 
     * @return 
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * 
     * @param descricao 
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * 
     * @return 
     */
    public int getIdElevador() {
        return idElevador;
    }

    /**
     * 
     * @param idElevador 
     */
    public void setIdElevador(int idElevador) {
        this.idElevador = idElevador;
    }

    /**
     * 
     * @return 
     */
    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    /**
     * 
     * @param dataInicio 
     */
    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * 
     * @return 
     */
    public LocalDateTime getDataTermino() {
        return dataTermino;
    }

    /**
     * 
     * @param dataTermino 
     */
    public void setDataTermino(LocalDateTime dataTermino) {
        this.dataTermino = dataTermino;
    }

    /**
     * 
     * @return 
     */
    public int getIdMecanico() {
        return idMecanico;
    }

    /**
     * 
     * @param idMecanico 
     */
    public void setIdMecanico(int idMecanico) {
        this.idMecanico = idMecanico;
    }

    /**
     * 
     * @return 
     */
    public List<Servicos> getServicosRealizados() {
        return servicosRealizados;
    }

    /**
     * 
     * @return 
     */
    public Map<Integer, Integer> getPecasUtilizadas() {
        return pecasUtilizadas;
    }
    
    /**
     * 
     * @return 
     */
    public List<Observer> getObservers() {
        return observers;
    }

    /**
     * 
     * @param observers 
     */
    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }

    /**
     * 
     * @return 
     */
    public String getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    /**
     * 
     * @param ultimaAtualizacao 
     */
    public void setUltimaAtualizacao(String ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }
    
    /**
     * 
     * @param pecasUtilizadas 
     */
    public void setPecasUtilizadas(Map<Integer, Integer> pecasUtilizadas) {
        this.pecasUtilizadas = pecasUtilizadas;
    }

    /**
     * 
     * @return 
     */
    public static int getContadorOS() {
        return contadorOS;
    }

    /**
     * 
     * @param contadorOS 
     */
    public static void setContadorOS(int contadorOS) {
        OrdemDeServico.contadorOS = contadorOS;
    }
    
    /**
     * Gera uma representação textual da Ordem de Serviço
     * @return 
     */
    @Override
    public String toString() {
        return "Id Ordem de Servico" + idOS + "|  Status:" + statusOS + "|  Placa Veiculo:" + placaVeiculo + "|  Id Cliente:" + idCliente +  "| Descricao: " + descricao;
    }    
    
}
