/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicos;

import Dominio.Cliente;
import java.util.ArrayList;

/**
 *
 * @author luizp
 */
public class GestaoClientes {
    private ArrayList<Cliente> clientes;

    public GestaoClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    public void adicionaCliente(Cliente cliente){
        clientes.add(cliente);
    }
    
    public Cliente buscarCliente(int id){
        for(Cliente i: clientes){
            if(i.getIdCliente() == id){
                return i;
            }
        }
        return null;
    }
    
    public boolean removerCliente(int id){
        Cliente cliente = buscarCliente(id);
        if(cliente != null){
            clientes.remove(cliente);
            return true;
        }
        return false;
    }
    
    public boolean editarNome(int id, String nome){
        Cliente cliente = buscarCliente(id);
        if(cliente != null){
            cliente.setNome(nome);
            return true;
        }
        return false;
    }
    
    public boolean editarEndereco(int id, String endereco){
        Cliente cliente = buscarCliente(id);
        if(cliente != null){
            cliente.setEndereco(endereco);
            return true;
        }
        return false;
    }
    
    public boolean editarTelefone(int id, String telefone){
        Cliente cliente = buscarCliente(id);
        if(cliente != null){
            cliente.setTelefone(telefone);
            return true;
        }
        return false;
    }
    
    public boolean editarEmail(int id, String email){
        Cliente cliente = buscarCliente(id);
        if(cliente != null){
            cliente.setEmail(email);
            return true;
        }
        return false;
    }
    
    public boolean editarCpf(int id, int cpf){
        Cliente cliente = buscarCliente(id);
        if(cliente != null){
            cliente.setCpf(cpf);
            return true;
        }
        return false;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
}
