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
 *
 * @author luizp
 */
public class GestaoDeVeiculos {
    private Map<String, Veiculo> placasPorVeiculos;
    private Map<String, Integer> placasPorCliente;
    private static final String CAMINHO_ARQUIVO = "veiculos.json";
    private static final String CAMINHO_CONTADOR = "contador_veiculos.json";
    private static final ObjectMapper mapper = new ObjectMapper();
    
    public GestaoDeVeiculos(){
        this.placasPorVeiculos = new HashMap<>();
        this.placasPorCliente = new HashMap<>();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }
    
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

    private void salvarNoArquivo() {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(CAMINHO_ARQUIVO), this);
        } catch (IOException e) {
            System.out.println("Erro ao salvar estoque: " + e.getMessage());
        }
    }
    
    public void salvar(){
        salvarNoArquivo();
    }
        
    public boolean veiculoExiste(String placa){
        return placasPorVeiculos.containsKey(placa);
    }
    
    public Veiculo buscarVeiculoPorPlaca(String placa){
        return placasPorVeiculos.get(placa);
    }
    
    public void adicionarVeiculo(int id, Veiculo veiculo){
        if(veiculoExiste(veiculo.getPlaca()) == false){
            placasPorVeiculos.put(veiculo.getPlaca(), veiculo);
            placasPorCliente.put(veiculo.getPlaca(), id);
        } else{
            throw new RuntimeException("Veiculo existe");
        }  
    }
    
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
    
    public boolean removerVeiculo(String placa){
        Veiculo v = buscarVeiculoPorPlaca(placa);
        if(v != null){
            placasPorVeiculos.remove(placa);
            placasPorCliente.remove(placa);
            return true;
        }
        return false;
    }
    
    public boolean editarModelo(String placa, String modelo){
        Veiculo v = buscarVeiculoPorPlaca(placa);
        if(v != null){
            v.setModelo(modelo);
            return true;
        }
        return false;
    }
    
    public boolean editarAno(String placa, int ano){
        Veiculo v = buscarVeiculoPorPlaca(placa);
        if(v != null){
            v.setAno(ano);
            return true;
        }
        return false;
    }

    public Map<String, Veiculo> getPlacasPorVeiculos() {
        return placasPorVeiculos;
    }

    public void setPlacasPorVeiculos(Map<String, Veiculo> placasPorVeiculos) {
        this.placasPorVeiculos = placasPorVeiculos;
    }

    public Map<String, Integer> getPlacasPorCliente() {
        return placasPorCliente;
    }

    public void setPlacasPorCliente(Map<String, Integer> placasPorCliente) {
        this.placasPorCliente = placasPorCliente;
    }

    @Override
    public String toString() {
        return "GestaoDeVeiculos{" + "placasPorVeiculos=" + placasPorVeiculos + ", placasPorCliente=" + placasPorCliente + '}';
    }
}
