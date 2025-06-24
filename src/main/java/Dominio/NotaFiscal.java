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
 *
 * @author luizp
 */
public class NotaFiscal implements Serializable{
    private int idOS;
    private int idCliente;
    private LocalDateTime data;
    private ArrayList<ItemNota> itens;
    private double total = 0;

    public NotaFiscal() {
    }
    
    public NotaFiscal(int idOS, int idCliente) {
        this.idOS = idOS;
        this.idCliente = idCliente;
        this.data = LocalDateTime.now();
        this.itens = new ArrayList<>();
    }
    
    public void adicionarItem(String descricao, int quantidade, double valorUnitario){
        ItemNota item = new ItemNota(descricao, quantidade, valorUnitario);
        itens.add(item);
        this.total += item.getValorTotal();
    }
    
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

    public int getIdOS() {
        return idOS;
    }

    public void setIdOS(int idOS) {
        this.idOS = idOS;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public ArrayList<ItemNota> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemNota> itens) {
        this.itens = itens;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "NotaFiscal | OS #" + idOS + " | Cliente ID: " + idCliente + " | Valor Total: R$" + String.format("%.2f", total);
    }   
}
