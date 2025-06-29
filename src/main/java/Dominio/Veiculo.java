/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.io.Serializable;

/**
 * Representa um veiculo
 * @author Hudson
 */
public class Veiculo implements Serializable{
    private String modelo;
    private String placa;
    private int ano;

    /**
     * Construtor padrão
     */
    public Veiculo(){
        Cliente.incrementaContadorDeVeiculos();
        Cliente.contadorDeVeiculos += 1;
    }
    
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
        Cliente.incrementaContadorDeVeiculos();
        Cliente.contadorDeVeiculos += 1;
    }
    
    /**
     * Set para alterar o modelo
     * @param modelo 
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    /**
     * Get para retorar o modelo
     * @return 
     */
    public String getModelo() {
        return modelo;
    }
    
    /**
     * 
     * @param placa 
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    /**
     * 
     * @return 
     */
    public String getPlaca(){
        return placa;
    }
    
    /**
     * 
     * @param ano 
     */
    public void setAno(int ano) {
        this.ano = ano;
    }
    
    /**
     * 
     * @return 
     */
    public int getAno() {
        return ano;
    }

    /**
     * Retorna uma representação textual do veiculo
     * @return 
     */
    @Override
    public String toString() {
        return "Modelo: " + modelo + "| Placa: " + placa + "| Ano: " + ano;
    }
}
