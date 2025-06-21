/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author luizp
 */
public class OrdemDeServico implements Subject{
    private static int contadorOS = 0;
    private int idOS;
    private int idVeiculo;
    private int idCliente;
    private String descricao;
    private int idElevador;
    private LocalDateTime dataInicio;
    private LocalDateTime dataTermino;
    private int idMecanico;
    private StatusOS statusOS;
    private Map<Integer, Integer> pecasUtilizadas;
    private List<Servicos> servicosRealizados;
    
    private List<Observer> observers = new ArrayList<>();
    private String ultimaAtualizacao;

    public OrdemDeServico(int idVeiculo, int idCliente, String descricao, int idElevador, LocalDateTime dataInicio, LocalDateTime dataTermino, int idMecanico, Map<Integer, Integer> pecasUtilizadas, List<Servicos> servicosRealizados) {
        OrdemDeServico.contadorOS += 1;
        this.idOS = contadorOS;
        this.idVeiculo = idVeiculo;
        this.idCliente = idCliente;
        this.descricao = descricao;
        this.idElevador = idElevador;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.idMecanico = idMecanico;
        this.pecasUtilizadas = new HashMap<>();
        this.servicosRealizados = new ArrayList<>();
    }

    public OrdemDeServico(int idVeiculo, int idCliente, String descricao, int idElevador, LocalDateTime dataInicio, int idMecanico, StatusOS statusOS, Map<Integer, Integer> pecasUtilizadas, List<Servicos> servicosRealizados) {
        OrdemDeServico.contadorOS += 1;
        this.idOS = contadorOS;
        this.idVeiculo = idVeiculo;
        this.idCliente = idCliente;
        this.descricao = descricao;
        this.idElevador = idElevador;
        this.dataInicio = dataInicio;
        this.idMecanico = idMecanico;
        this.statusOS = statusOS;
        this.pecasUtilizadas = new HashMap<>();
        this.servicosRealizados = new ArrayList<>();
    }

    public OrdemDeServico(int idVeiculo, int idCliente, String descricao, int idElevador, LocalDateTime dataInicio, int idMecanico, StatusOS statusOS) {
        OrdemDeServico.contadorOS += 1;
        this.idOS = contadorOS;
        this.idVeiculo = idVeiculo;
        this.idCliente = idCliente;
        this.descricao = descricao;
        this.idElevador = idElevador;
        this.dataInicio = dataInicio;
        this.idMecanico = idMecanico;
        this.statusOS = statusOS;
        this.pecasUtilizadas = new HashMap<>();
        this.servicosRealizados = new ArrayList<>();
    }

    public OrdemDeServico() {
        OrdemDeServico.contadorOS += 1;
        this.idOS = contadorOS;
        this.pecasUtilizadas = new HashMap<>();
        this.servicosRealizados = new ArrayList<>();
    }
    
    public void adicionarPeca(int idPeca, int quantidade) {
        int qtdAtual = pecasUtilizadas.getOrDefault(idPeca, 0);
        pecasUtilizadas.put(idPeca, qtdAtual + quantidade);
    }
    
    public void removerPeca(int idPeca, int quantidade) {
        int qtdAtual = pecasUtilizadas.getOrDefault(idPeca, 0);
        if(quantidade > qtdAtual){
            throw new RuntimeException("Quantidade a ser removida maior que aquantidade utilizada");
        } else{
           pecasUtilizadas.put(idPeca, qtdAtual - quantidade); 
        }
    }

    @Override
    public void adicionarObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removerObserver(Observer observer) {
        observers.remove(observer);
    }

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
    
    public StatusOS getStatusOS() {
        return statusOS;
    }

    public void setStatusOS(StatusOS statusOS) {
        this.statusOS = statusOS;
        this.ultimaAtualizacao = "A OS #" + idOS + " (" + descricao + ") mudou para: " + statusOS;
        notificarObserver();
    }

    public int getIdOS() {
        return idOS;
    }

    //acho que devemos tirar esse
    public void setIdOS(int idOS) {
        this.idOS = idOS;
    }

    public int getIdVeiculo() {
        return idVeiculo;
    }

    public void setIdVeiculo(int idVeiculo) {
        this.idVeiculo = idVeiculo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdElevador() {
        return idElevador;
    }

    public void setIdElevador(int idElevador) {
        this.idElevador = idElevador;
    }

    public LocalDateTime getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDateTime dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDateTime getDataTermino() {
        return dataTermino;
    }

    public void setDataTermino(LocalDateTime dataTermino) {
        this.dataTermino = dataTermino;
    }

    public int getIdMecanico() {
        return idMecanico;
    }

    public void setIdMecanico(int idMecanico) {
        this.idMecanico = idMecanico;
    }

    public List<Servicos> getServicosRealizados() {
        return servicosRealizados;
    }

    public Map<Integer, Integer> getPecasUtilizadas() {
        return pecasUtilizadas;
    }

    

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }

    public String getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(String ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }
    
    //verificar se vamos deixar o set
    public void setPecasUtilizadas(Map<Integer, Integer> pecasUtilizadas) {
        this.pecasUtilizadas = pecasUtilizadas;
    }

    @Override
    public String toString() {
        return "OrdemDeServico{" + "idOS=" + idOS + ", idVeiculo=" + idVeiculo + ", idCliente=" + idCliente + ", descricao=" + descricao + ", idElevador=" + idElevador + ", dataInicio=" + dataInicio + ", dataTermino=" + dataTermino + ", idMecanico=" + idMecanico + ", pecasUtilizadas=" + pecasUtilizadas + ", servicosRealizados=" + servicosRealizados + '}';
    }    
    
}
