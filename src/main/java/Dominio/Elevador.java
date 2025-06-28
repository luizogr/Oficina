/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

/**
 * Representa um elevador físico na oficina.
 * @author dtiDigital
 */
public class Elevador {
    private int id;
    private TipoElevador tipo;

    /**
     * Construtor padrão para o Jackson
     */
    public Elevador() {
    }
    
    /**
     * Construtor para criar um novo elevador.
     * Por padrão, um novo elevador é sempre inicializado como não ocupado.
     * @param id
     * @param tipo 
     */
    public Elevador(int id, TipoElevador tipo) {
        this.id = id;
        this.tipo = tipo;
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
    
    @Override
    public String toString() {
        return "Elevador | ID: " + id + " | Tipo: " + tipo;
    }
}