/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author luizp
 */
public class Agendamento {
    private int idVeiculo;
    private int idCliente;
    private String descricao;
    private ArrayList<Servicos> servicosNecessarios;
    private int idElevador;
    private StatusAgendamento status;
    private LocalDateTime data;
    private double preco;

    public Agendamento(int idVeiculo, int idCliente, String descricao, ArrayList<Servicos> servicosNecessarios, int idElevador, LocalDateTime data, double preco) {
        this.idVeiculo = idVeiculo;
        this.idCliente = idCliente;
        this.descricao = descricao;
        this.servicosNecessarios = servicosNecessarios;
        this.idElevador = idElevador;
        this.status = StatusAgendamento.Agendado;
        this.data = data;
        this.preco = preco;
    }

    public Agendamento(int idVeiculo, int idCliente, String descricao, ArrayList<Servicos> servicosNecessarios, int idElevador, LocalDateTime data) {
        this.idVeiculo = idVeiculo;
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
        return "Agendamento{" + "idVeiculo=" + idVeiculo + ", idCliente=" + idCliente + ", descricao=" + descricao + ", servicosNecessarios=" + servicosNecessarios + ", idElevador=" + idElevador + ", status=" + status + ", data=" + data + ", preco=" + preco + '}';
    }
    
    
}
