/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.oficina;

import Dominio.Cargo;
import Dominio.Funcionario;
import Dominio.Gerente;
import Dominio.Mecanico;
import Servicos.FuncionarioService;

/**
 *
 * @author luizp
 */
public class Oficina {

    public static void main(String[] args) {
        Gerente gerente = new Gerente("Maria Oliveira", Cargo.Gerente, "maria456", "senha456");
        Funcionario funcionario1 = new Funcionario("João Silva", Cargo.Funcionario, "joao123", "senha123");
        Funcionario funcionario3 = new Funcionario("Carlos Souza", Cargo.Funcionario, "carlos789", "senha789");
        Funcionario funcionario4 = new Funcionario("Ana Costa", Cargo.Funcionario, "ana321", "senha321");
        FuncionarioService funcionarios = new FuncionarioService();
        
        funcionarios.adicionarFuncionario(gerente);
        funcionarios.adicionarFuncionario(funcionario1);
        funcionarios.adicionarFuncionario(funcionario3);
        funcionarios.adicionarFuncionario(funcionario4);
        
        System.out.println(funcionarios.getFuncionarios());
        System.out.println(gerente);
        System.out.println(funcionario1);
        System.out.println(gerente.getIdFuncionario());
        System.out.println(funcionario1.getIdFuncionario());
        funcionarios.removerFuncionario(2);
        System.out.println(funcionarios.getFuncionarios());
    }
}
