/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
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

    public Agendamento() {
    }
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
    
    public boolean conflita(Agendamento agendamento2){
        return this.data.equals(agendamento2.getData()) && this.idElevador == agendamento2.getIdElevador();
    }

    public int getIdAgendamento() {
        return idAgendamento;
    }

    public void setIdAgendamento(int idAgendamento) {
        this.idAgendamento = idAgendamento;
    }

    public static void setContadorId(int contadorId) {
        Agendamento.contadorId = contadorId;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
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

    public StatusAgendamento getStatus() {
        return status;
    }

    public void setStatus(StatusAgendamento status) {
        this.status = status;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public ArrayList<Servicos> getServicosNecessarios() {
        return servicosNecessarios;
    }

    public void setServicosNecessarios(ArrayList<Servicos> servicosNecessarios) {
        this.servicosNecessarios = servicosNecessarios;
    }

    @Override
    public String toString() {
        return "Agendamento | ID: " + idAgendamento + 
               " | Data: " + data +
               " | Cliente ID: " + idCliente + 
               " | Status: " + status;
    }
}
