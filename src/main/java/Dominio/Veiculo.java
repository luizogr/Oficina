/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author Hudson
 */
public class Veiculo {
    private String modelo;
    private String placa;
    private int ano;
    private Cliente cliente;
    
    /**
     * Construtor da Classe Veiculo
     * @param modelo
     * @param placa
     * @param ano 
     */
    public Veiculo(String modelo, String placa, int ano) {
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
    }
    
    public Veiculo(Cliente cliente, String modelo, String placa, int ano){
        this.cliente = cliente;
        this.modelo = modelo;
        this.ano = ano;
        this.placa = placa;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    public String getPlaca(){
        return placa;
    }
    
    public void setAno(int ano) {
        this.ano = ano;
    }
    
    public int getAno() {
        return ano;
    }
}
