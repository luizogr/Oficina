/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import Dominio.Peca;
import java.util.ArrayList;

/**
 *
 * @author luizp
 */
public class Servico {
    private static int contadorServicos = 0;
    private int idServico;
    //Criar Id para cada serviço, fazer uma classe para gestão contendo adição de peças ao serviços, o preço, tipo, excluir serviço, adicionar novo serviço
    private String tipo;
    private double preco;
    private ArrayList<Peca> peca;

    public Servico(String tipo, double preco) {
        this.contadorServicos += 1;
        this.idServico = contadorServicos;
        this.tipo = tipo;
        this.preco = preco;
    }
    
    //Conferir se deve ficar
    public Servico(String tipo, double preco, ArrayList<Peca> peca) {
        this.contadorServicos += 1;
        this.idServico = contadorServicos;
        this.tipo = tipo;
        this.preco = preco;
        this.peca = peca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public ArrayList<Peca> getPeca() {
        return peca;
    }

    public static int getContadorServicos() {
        return contadorServicos;
    }

    public static void setContadorServicos(int contadorServicos) {
        Servico.contadorServicos = contadorServicos;
    }

    public int getIdServico() {
        return idServico;
    }

    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }
    
    @Override
    public String toString() {
        return "Servico{" + "tipo=" + tipo + ", preco=" + preco + ", peca=" + peca + '}';
    }
}
