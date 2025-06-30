/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicos;

import Dominio.Cliente;
import Dominio.Estoque;
import Dominio.Veiculo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Gerencia o cadastro e a relação de veículos e seus respectivos proprietários
 * @author luizp
 */
public class GestaoDeVeiculos {
    private Map<String, Veiculo> placasPorVeiculos;
    private Map<String, Integer> placasPorCliente;
    private static final String CAMINHO_ARQUIVO = "veiculos.json";
    private static final String CAMINHO_CONTADOR = "contador_veiculos.json";
    private static final ObjectMapper mapper = new ObjectMapper();
    
    /**
     * Construtor padrão
     */
    public GestaoDeVeiculos(){
        this.placasPorVeiculos = new HashMap<>();
        this.placasPorCliente = new HashMap<>();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }
    
    /**
     * Carrega os dados da gestão de veículos a partir de arquivos JSON
     * @return 
     */
    public static GestaoDeVeiculos carregarDoArquivo() {
        File arquivoVeiculos = new File(CAMINHO_ARQUIVO);
        File arquivoContador = new File(CAMINHO_CONTADOR);
        try {
            // Carrega o contador primeiro, se ele existir
            if (arquivoContador.exists() && arquivoContador.length() > 0) {
                int contagemVeiculos = mapper.readValue(arquivoContador, Integer.class);
                Cliente.setContadorDeVeiculosPrivate(contagemVeiculos);
            }
            // Em seguida, carrega a gestão de veículos
            if (arquivoVeiculos.exists() && arquivoVeiculos.length() > 0) {
                return mapper.readValue(arquivoVeiculos, GestaoDeVeiculos.class);
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar gestão de veículos: " + e.getMessage());
        }
        return new GestaoDeVeiculos();
    }

    /**
     * Salva o estado atual da gestão de veículos no arquivo JSON
     */
    private void salvarNoArquivo() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(CAMINHO_ARQUIVO), this);
        } catch (IOException e) {
            System.out.println("Erro ao salvar estoque: " + e.getMessage());
        }
    }
   
    /**
     * Metodo publico para salvar alterações
     */
    public void salvar(){
        salvarNoArquivo();
    }
    
    /**
     * Verifica se um veículo com a placa especificada já está cadastrado
     * @param placa
     * @return 
     */
    public boolean veiculoExiste(String placa){
        return placasPorVeiculos.containsKey(placa);
    }
    
    /**
     * Busca e retorna um veículo com base na sua placa
     * @param placa
     * @return 
     */
    public Veiculo buscarVeiculoPorPlaca(String placa){
        return placasPorVeiculos.get(placa);
    }
    
    /**
     * Adiciona um novo veículo ao sistema
     * @param id
     * @param veiculo 
     */
    public void adicionarVeiculo(int id, Veiculo veiculo){
        if(veiculoExiste(veiculo.getPlaca()) == false){
            placasPorVeiculos.put(veiculo.getPlaca(), veiculo);
            placasPorCliente.put(veiculo.getPlaca(), id);
        } else{
            System.out.println("Veiculo existe");
        }  
    }
    
    /**
     * Retorna uma lista de todos os veículos pertencentes a um cliente
     * @param id
     * @return 
     */
    public ArrayList<Veiculo> buscarVeiculosDoProprietario(int id){
        ArrayList<Veiculo> veiculosCliente = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : placasPorCliente.entrySet()){
            if(entry.getValue() == id){
                Veiculo veiculo = placasPorVeiculos.get(entry.getKey());
                if(veiculo != null){
                    veiculosCliente.add(veiculo);
                }
            }
        }
        return veiculosCliente;
    }
    
    /**
     * Remove um veículo do sistema com base na sua placa
     * @param placa
     * @return 
     */
    public boolean removerVeiculo(String placa){
        Veiculo v = buscarVeiculoPorPlaca(placa);
        if(v != null){
            placasPorVeiculos.remove(placa);
            placasPorCliente.remove(placa);
            return true;
        }
        return false;
    }
    
    /**
     * Edita o modelo de um veículo existente
     * @param placa
     * @param modelo
     * @return 
     */
    public boolean editarModelo(String placa, String modelo){
        Veiculo v = buscarVeiculoPorPlaca(placa);
        if(v != null){
            v.setModelo(modelo);
            return true;
        }
        return false;
    }
    
    /**
     * Edita o ano de um veículo existente
     * @param placa
     * @param ano
     * @return 
     */
    public boolean editarAno(String placa, int ano){
        Veiculo v = buscarVeiculoPorPlaca(placa);
        if(v != null){
            v.setAno(ano);
            return true;
        }
        return false;
    }

    /**
     * 
     * @return 
     */
    public Map<String, Veiculo> getPlacasPorVeiculos() {
        return placasPorVeiculos;
    }

    /**
     * 
     * @param placasPorVeiculos 
     */
    public void setPlacasPorVeiculos(Map<String, Veiculo> placasPorVeiculos) {
        this.placasPorVeiculos = placasPorVeiculos;
    }

    /**
     * 
     * @return 
     */
    public Map<String, Integer> getPlacasPorCliente() {
        return placasPorCliente;
    }

    /**
     * 
     * @param placasPorCliente 
     */
    public void setPlacasPorCliente(Map<String, Integer> placasPorCliente) {
        this.placasPorCliente = placasPorCliente;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return "GestaoDeVeiculos{" + "placasPorVeiculos=" + placasPorVeiculos + ", placasPorCliente=" + placasPorCliente + '}';
    }
}
