/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicos;

import Dominio.Cargo;
import Dominio.Funcionario;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author luizp
 */
public class FuncionarioService {
    private ArrayList<Funcionario> funcionarios;
    private static final String CAMINHO_ARQUIVO = "funcionarios.json";
    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * Cria uma ArrayList dos funcionarios
     */
    public FuncionarioService() {
        this.funcionarios = new ArrayList<>();
    }
    
    public static FuncionarioService carregarDoArquivo() {
        try {
            File arquivo = new File(CAMINHO_ARQUIVO);
            if (arquivo.exists() && arquivo.length() > 0) {
                return mapper.readValue(arquivo, FuncionarioService.class);
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar dados dos funcionários: " + e.getMessage());
        }
        return new FuncionarioService();
    }
    
    private void salvarNoArquivo() {
        try {
            mapper.writeValue(new File(CAMINHO_ARQUIVO), this);
        } catch (IOException e) {
            System.err.println("Erro ao salvar dados dos funcionários: " + e.getMessage());
        }
    }
    
    /**
     * 
     * @param funcionario 
     */
    public void adicionarFuncionario(Funcionario funcionario){
        if(buscaFuncionario(funcionario.getIdFuncionario()) == null) {
            funcionarios.add(funcionario);
        } else {
            System.err.println("Erro: Já existe um funcionário com o ID " + funcionario.getIdFuncionario());
        }
    }
    
    /**
     * função para remover o funcionário pelo objeto
     * @param funcionario 
     */
    public void removerFuncionario(Funcionario funcionario){
        funcionarios.remove(funcionario);
    }
    
    /**
     * busca um funcionario por seu id
     * @param id
     * @return caso encontre retorna o funcionario, caso não retorna null
     */
    public Funcionario buscaFuncionario(int id){
        for(Funcionario i: funcionarios){
            if(i.getIdFuncionario() == id){
                return i;
            }
        }
        return null;
    }
    
    /**
     * Função para remover um funcionario pelo seu id
     * @param id
     * @return true se for excluido e false caso não seja excluido
     */
    public boolean removerFuncionario(int id){
        Funcionario funcionario = buscaFuncionario(id);
        if(funcionario != null){
            funcionarios.remove(funcionario);
            return true;
        }
        return false;
    }
    
    /**
     * função para editar nome
     * @param id
     * @param nome
     * @return true se bem sucedido e false se não
     */
    public boolean editarNome(int id, String nome){
        Funcionario f = buscaFuncionario(id);
        if(f != null){
            f.setNome(nome);
            return true;
        }
        return false;
    }
    
    /**
     * função para editar cargo
     * @param id
     * @param cargo
     * @return true se bem sucedido e false se não
     */
    public boolean editarCargo(int id, Cargo cargo){
        Funcionario f = buscaFuncionario(id);
        if(f != null){
            f.setCargo(cargo);
            return true;
        }
        return false;
    }
    
    /**
     * função para editar login
     * @param id
     * @param login
     * @return true se bem sucedido e false se não
     */
    public boolean editarLogin(int id, String login){
        Funcionario f = buscaFuncionario(id);
        if(f != null){
            f.setLogin(login);
            return true;
        }
        return false;
    }
    
    /**
     * função para editar senha
     * @param id
     * @param senha
     * @return true se bem sucedido e false se não
     */
    public boolean editarSenha(int id, String senha){
        Funcionario f = buscaFuncionario(id);
        if (f != null) {
            f.setSenha(senha);
            return true;
        }
        return false;
    }
    
    public boolean editarSalario(int id, double salario){
        Funcionario f = buscaFuncionario(id);
        if (f != null) {
            f.setSalario(salario);
            return true;
        }
        return false;
    }

    /**
     * função get para retornar a lista de funcionários
     * @return 
     */
    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }
    
    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Override
    public String toString() {
        return "FuncionarioService{" + "funcionarios=" + funcionarios + '}';
    }
}
