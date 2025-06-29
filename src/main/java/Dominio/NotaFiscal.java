/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import Dominio.ItemNota;
import java.io.Serializable;

/**
 * Representa a nota fiscal ou o extrato de uma Ordem de Serviço finalizada
 * @author luizp
 */
public class NotaFiscal implements Serializable{
    private int idOS;
    private int idCliente;
    private LocalDateTime data;
    private ArrayList<ItemNota> itens;
    private double total = 0;

    /**
     * Construtor padrão
     */
    public NotaFiscal() {
    }
    
    /**
     * Construtor para criar uma nova nota fiscal
     * @param idOS
     * @param idCliente 
     */
    public NotaFiscal(int idOS, int idCliente) {
        this.idOS = idOS;
        this.idCliente = idCliente;
        this.data = LocalDateTime.now();
        this.itens = new ArrayList<>();
    }
    
    /**
     * diciona um novo item
     * @param descricao
     * @param quantidade
     * @param valorUnitario 
     */
    public void adicionarItem(String descricao, int quantidade, double valorUnitario){
        ItemNota item = new ItemNota(descricao, quantidade, valorUnitario);
        itens.add(item);
        this.total += item.getValorTotal();
    }
    
    /**
     * Imprime uma representação formatada da nota fiscal no console
     */
    public void imprimir() {
        System.out.println("\n================ NOTA FISCAL / EXTRATO ================");
        System.out.println("Ordem de Serviço Nº: " + idOS);
        System.out.println("Cliente ID: " + idCliente);
        System.out.println("Data de Emissão: " + data.toLocalDate());
        System.out.println("-----------------------------------------------------");
        System.out.printf("%-30s | %-5s | %-11s | %-11s\n", "Descrição", "Qtd", "Vlr. Unit.", "Vlr. Total");
        System.out.println("-----------------------------------------------------");
        for (ItemNota item : itens) {
            System.out.println(item);
        }
        System.out.println("-----------------------------------------------------");
        System.out.printf("VALOR TOTAL: R$ %.2f\n", total);
        System.out.println("=====================================================\n");
    }

    /**
     * 
     * @return 
     */
    public int getIdOS() {
        return idOS;
    }

    /**
     * 
     * @param idOS 
     */
    public void setIdOS(int idOS) {
        this.idOS = idOS;
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
    public ArrayList<ItemNota> getItens() {
        return itens;
    }

    /**
     * 
     * @param itens 
     */
    public void setItens(ArrayList<ItemNota> itens) {
        this.itens = itens;
    }

    /**
     * 
     * @return 
     */
    public double getTotal() {
        return total;
    }

    /**
     * 
     * @param total 
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * Retorna uma representação textual do objeto NotaFiscal
     * @return 
     */
    @Override
    public String toString() {
        return "NotaFiscal | OS #" + idOS + " | Cliente ID: " + idCliente + " | Valor Total: R$" + String.format("%.2f", total);
    }   
}
