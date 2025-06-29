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

    /**
     * Retorna o ID do elevador
     * @return 
     */
    public int getId() {
        return id;
    }

    /**
     * Define o ID do elevado
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Retorna o tipo do elevador
     * @return 
     */
    public TipoElevador getTipo() {
        return tipo;
    }

    /**
     * Define o tipo do elevador
     * @param tipo 
     */
    public void setTipo(TipoElevador tipo) {
        this.tipo = tipo;
    }
    
    /**
     * Retorna uma representação textual do objeto Elevador
     * @return 
     */
    @Override
    public String toString() {
        return "Elevador | ID: " + id + " | Tipo: " + tipo;
    }
}