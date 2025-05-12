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

    /**
     * Construtor da classe que inicia o ArrayList
     */
    public GestaoClientes() {
        this.clientes = new ArrayList<>();
    }
    
    /**
     * Adiciona clinte a ArrayList
     * @param cliente 
     */
    public void adicionaCliente(Cliente cliente){
        clientes.add(cliente);
    }
    
    /**
     * Realiza a busca do cliente pelo ID
     * @param id
     * @return o cliente caso encontre e null caso não
     */
    public Cliente buscarCliente(int id){
        for(Cliente i: clientes){
            if(i.getIdCliente() == id){
                return i;
            }
        }
        return null;
    }
    
    /**
     * Remove o cliente da ArrayList pelo ID
     * @param id
     * @return 
     */
    public boolean removerCliente(int id){
        Cliente cliente = buscarCliente(id);
        if(cliente != null){
            clientes.remove(cliente);
            return true;
        }
        return false;
    }
    
    /**
     * Edita o nome do cliente que é passado pelo ID
     * @param id
     * @param nome
     * @return 
     */
    public boolean editarNome(int id, String nome){
        Cliente cliente = buscarCliente(id);
        if(cliente != null){
            cliente.setNome(nome);
            return true;
        }
        return false;
    }
    
    /**
     * Edita o endereço do cliente que é passado pelo ID
     * @param id
     * @param endereco
     * @return 
     */
    public boolean editarEndereco(int id, String endereco){
        Cliente cliente = buscarCliente(id);
        if(cliente != null){
            cliente.setEndereco(endereco);
            return true;
        }
        return false;
    }
    
    /**
     * Edita o telefone do cliente que é passado pelo ID
     * @param id
     * @param telefone
     * @return 
     */
    public boolean editarTelefone(int id, String telefone){
        Cliente cliente = buscarCliente(id);
        if(cliente != null){
            cliente.setTelefone(telefone);
            return true;
        }
        return false;
    }
    
    /**
     * Edita o email do cliente que é passado pelo ID
     * @param id
     * @param email
     * @return 
     */
    public boolean editarEmail(int id, String email){
        Cliente cliente = buscarCliente(id);
        if(cliente != null){
            cliente.setEmail(email);
            return true;
        }
        return false;
    }
    
    /**
     * Edita o cpf do cliente que é passado pelo ID
     * @param id
     * @param cpf
     * @return 
     */
    public boolean editarCpf(int id, int cpf){
        Cliente cliente = buscarCliente(id);
        if(cliente != null){
            cliente.setCpf(cpf);
            return true;
        }
        return false;
    }

    /**
     * retorna os clientes no ArrayList
     * @return 
     */
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    //Não sei se precisa ter esse set para clientes
    /**
     * Faz o set de clientes
     * @param clientes 
     */
    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
}
