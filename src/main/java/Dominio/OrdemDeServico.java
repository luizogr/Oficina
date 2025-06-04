/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luizp
 */
public class OrdemDeServico {
    private static int contadorOS = 0;
    private int idOS;
    private int idVeiculo;
    private int idCliente;
    private String descricao;
    private int idElevador;
    private LocalDateTime dataInicio;
    private LocalDateTime dataTermino;
    private int idMecanico;
    private List<Peca> pecasUtilizadas;
    private List<Servicos> servicosRealizados
            ;

    public OrdemDeServico(int idVeiculo, int idCliente, String descricao, int idElevador, LocalDateTime dataInicio, LocalDateTime dataTermino, int idMecanico, List<Peca> pecasUtilizadas, List<Servicos> servicosRealizados) {
        OrdemDeServico.contadorOS += 1;
        this.idOS = contadorOS;
        this.idVeiculo = idVeiculo;
        this.idCliente = idCliente;
        this.descricao = descricao;
        this.idElevador = idElevador;
        this.dataInicio = dataInicio;
        this.dataTermino = dataTermino;
        this.idMecanico = idMecanico;
        this.pecasUtilizadas = new ArrayList<>();
        this.servicosRealizados = new ArrayList<>();
    }

    public OrdemDeServico() {
        OrdemDeServico.contadorOS += 1;
        this.idOS = contadorOS;
        this.pecasUtilizadas = new ArrayList<>();
        this.servicosRealizados = new ArrayList<>();
    }

    public int getIdOS() {
        return idOS;
    }

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

    public List<Peca> getPecasUtilizadas() {
        return pecasUtilizadas;
    }
    
    //verificar se vamos deixar o set
    public void setPecasUtilizadas(List<Peca> pecasUtilizadas) {
        this.pecasUtilizadas = pecasUtilizadas;
    }

    @Override
    public String toString() {
        return "OrdemDeServico{" + "idOS=" + idOS + ", idVeiculo=" + idVeiculo + ", idCliente=" + idCliente + ", descricao=" + descricao + ", idElevador=" + idElevador + ", dataInicio=" + dataInicio + ", dataTermino=" + dataTermino + ", idMecanico=" + idMecanico + ", pecasUtilizadas=" + pecasUtilizadas + ", servicosRealizados=" + servicosRealizados + '}';
    }    
    
}
