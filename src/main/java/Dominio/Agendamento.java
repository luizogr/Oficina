/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Representa um agendamento de serviço na oficina
 * @author luizp
 */
public class Agendamento implements Serializable{
    private static int contadorId = 0;
    private int idAgendamento;
    private String placaVeiculo;
    private int idCliente;
    private String descricao;
    private ArrayList<Servicos> servicosNecessarios;
    private int idElevador;
    private StatusAgendamento status;
    private LocalDateTime data;
    private double preco;

    /**
     * Construtor padrão
     */
    public Agendamento() {
    }
    
    /**
     * Construtor completo para criar um novo agendamento.
     * @param placaVeiculo
     * @param idCliente
     * @param descricao
     * @param servicosNecessarios
     * @param idElevador
     * @param data
     * @param preco 
     */
    public Agendamento(String placaVeiculo, int idCliente, String descricao, ArrayList<Servicos> servicosNecessarios, int idElevador, LocalDateTime data, double preco) {
        Agendamento.contadorId += 1;
        this.idAgendamento = contadorId;
        this.placaVeiculo = placaVeiculo;
        this.idCliente = idCliente;
        this.descricao = descricao;
        this.servicosNecessarios = servicosNecessarios;
        this.idElevador = idElevador;
        this.status = StatusAgendamento.Agendado;
        this.data = data;
        this.preco = preco;
    }

    /**
     * Construtor simplificado
     * @param placaVeiculo
     * @param idCliente
     * @param descricao
     * @param servicosNecessarios
     * @param idElevador
     * @param data 
     */
    public Agendamento(String placaVeiculo, int idCliente, String descricao, ArrayList<Servicos> servicosNecessarios, int idElevador, LocalDateTime data) {
        Agendamento.contadorId += 1;
        this.idAgendamento = contadorId;
        this.placaVeiculo = placaVeiculo;
        this.idCliente = idCliente;
        this.descricao = descricao;
        this.servicosNecessarios = servicosNecessarios;
        this.idElevador = idElevador;
        this.status = StatusAgendamento.Agendado;
        this.data = data;
    }

    /**
     * Construtor simplificado
     * @param placaVeiculo
     * @param idCliente
     * @param descricao
     * @param idElevador
     * @param data 
     */
    public Agendamento(String placaVeiculo, int idCliente, String descricao, int idElevador, LocalDateTime data) {
        Agendamento.contadorId += 1;
        this.idAgendamento = contadorId;
        this.placaVeiculo = placaVeiculo;
        this.idCliente = idCliente;
        this.descricao = descricao;
        this.idElevador = idElevador;
        this.status = StatusAgendamento.Agendado;
        this.data = data;
    }
    
    /**
     * Verifica se este agendamento conflita com outro em termos de horário e elevador
     * @param agendamento2
     * @return 
     */
    public boolean conflita(Agendamento agendamento2){
        return this.data.equals(agendamento2.getData()) && this.idElevador == agendamento2.getIdElevador();
    }

    /**
     * 
     * @return 
     */
    public static int getContadorId() {
        return contadorId;
    }
    
    /**
     * 
     * @param contador 
     */
    public static void setContadorId(int contador) { 
        Agendamento.contadorId = contador; 
    }

    /**
     * 
     * @return 
     */
    public int getIdAgendamento() {
        return idAgendamento;
    }

    /**
     * 
     * @param idAgendamento 
     */
    public void setIdAgendamento(int idAgendamento) {
        this.idAgendamento = idAgendamento;
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
    public StatusAgendamento getStatus() {
        return status;
    }

    /**
     * 
     * @param status 
     */
    public void setStatus(StatusAgendamento status) {
        this.status = status;
    }

    /**
     * 
     * @return 
     */
    public LocalDateTime getData() {
        return data;
    }

    /**
     * 
     * @param data 
     */
    public void setData(LocalDateTime data) {
        this.data = data;
    }

    /**
     * 
     * @return 
     */
    public double getPreco() {
        return preco;
    }

    /**
     * 
     * @param preco 
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * 
     * @return 
     */
    public ArrayList<Servicos> getServicosNecessarios() {
        return servicosNecessarios;
    }

    /**
     * 
     * @param servicosNecessarios 
     */
    public void setServicosNecessarios(ArrayList<Servicos> servicosNecessarios) {
        this.servicosNecessarios = servicosNecessarios;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return "Agendamento | ID: " + idAgendamento + 
               " | Data: " + data +
               " | Cliente ID: " + idCliente + 
               " | Status: " + status;
    }
}
