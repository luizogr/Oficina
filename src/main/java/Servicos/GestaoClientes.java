/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicos;

import Dominio.Cliente;
import Dominio.Estoque;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author luizp
 */
public class GestaoClientes {
    private ArrayList<Cliente> clientes;
    private static final String CAMINHO_ARQUIVO = "gestaoclientes.json";
    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * Construtor da classe que inicia o ArrayList
     */
    public GestaoClientes() {
        this.clientes = new ArrayList<>();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }
    
    /**
     * Carrega a lista de clientes e o estado dos contadores a partir de um arquivo JSON.
     * @return 
     */
    public static GestaoClientes carregarDoArquivo() {
        try {
            File arquivo = new File(CAMINHO_ARQUIVO);
            if (arquivo.exists() && arquivo.length() > 0) {
                GestaoClientes gestao = mapper.readValue(arquivo, GestaoClientes.class);
                // CORREÇÃO: Ajusta o contador de IDs após carregar para evitar duplicatas
                int maxId = 0;
                for (Cliente c : gestao.getClientes()) {
                    if (c.getIdCliente() > maxId) {
                        maxId = c.getIdCliente();
                    }
                }
                Cliente.setContadorClientes(maxId);
                return gestao;
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar gestão de clientes: " + e.getMessage());
        }
        return new GestaoClientes();
    }

    /**
     * Salva a lista de clientes e o estado dos contadores em um arquivo JSON.
     */
    private void salvarNoArquivo() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(CAMINHO_ARQUIVO), this);
        } catch (IOException e) {
            System.out.println("Erro ao salvar gestaoClientes: " + e.getMessage());
        }
    }
    
    public void salvar(){
        salvarNoArquivo();
    }
    
    /**
     * Adiciona clinte a ArrayList e salva no arquivo
     * @param cliente 
     */
    public void adicionaCliente(Cliente cliente){
        clientes.add(cliente);
        salvarNoArquivo();
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
            salvarNoArquivo();
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
            salvarNoArquivo();
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
            salvarNoArquivo();
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
            salvarNoArquivo();
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
            salvarNoArquivo();
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
            salvarNoArquivo();
            return true;
        }
        return false;
    }
    
    public Cliente find(Cliente clienteBusca, Comparator<Cliente> comparator){
        Iterator<Cliente> iterator = clientes.iterator();
        
        int contadorIterações = 0;
        while(iterator.hasNext()){
            contadorIterações += 1;
            Cliente c = iterator.next();
            if(comparator.compare(c, clienteBusca) == 0){
                return c, contadorIterações;
            }   
        }
        return null;
    }

    /**
     * retorna os clientes do ArrayList
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

    @Override
    public String toString() {
        return "GestaoClientes{" + "clientes=" + clientes + '}';
    }
    
}
