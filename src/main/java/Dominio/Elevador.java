/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 *
 * @author dtiDigital
 */
public class Elevador {
    private int id;
    private TipoElevador tipo;
    private boolean ocupado;
    
    /**
     * Construtor de elevador
     * @param id
     * @param tipo 
     */
    public Elevador(int id, TipoElevador tipo) {
        this.id = id;
        this.tipo = tipo;
        this.ocupado = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoElevador getTipo() {
        return tipo;
    }

    public void setTipo(TipoElevador tipo) {
        this.tipo = tipo;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }
    
    @Override
    public String toString() {
     return "Elevador {" + "id: " + id + ", tipo: " + tipo + ", ocupado: " + ocupado + '}';
    }
}