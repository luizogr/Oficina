/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicos;

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
     * 
     * Adiciona funcionario ao array de funcionarios
     */
    public void adicionarFuncionario(Funcionario funcionario){
        funcionarios.add(funcionario);
    }
    
    public void removerFuncionario(Funcionario funcionario){
        funcionarios.remove(funcionario);
    }
    
    public boolean removerFuncionario(int id){
        //preciso percorrer e buscar o id no arrayList
        for(Funcionario i:funcionarios){
            if(i.getIdFuncionario() == id){
                funcionarios.remove(i);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }
    
    //Talvez tirar não sei se é util
    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
    
}
