/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicos;

import Dominio.Cargo;
import Dominio.Funcionario;
import java.util.ArrayList;

/**
 *
 * @author luizp
 */
public class FuncionarioService {
    private ArrayList<Funcionario> funcionarios;

    /**
     * Cria uma ArrayList dos funcionarios
     */
    public FuncionarioService() {
        this.funcionarios = new ArrayList<>();
    }
    
    /**
     * 
     * @param funcionario 
     */
    public void adicionarFuncionario(Funcionario funcionario){
        funcionarios.add(funcionario);
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

    /**
     * função get para retornar a lista de funcionários
     * @return 
     */
    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }
    
    //Talvez tirar não sei se é util
    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Override
    public String toString() {
        return "FuncionarioService{" + "funcionarios=" + funcionarios + '}';
    }
}
