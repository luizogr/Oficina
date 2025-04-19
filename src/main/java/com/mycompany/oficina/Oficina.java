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
        Gerente gerente = new Gerente("Luiz", Cargo.Gerente, "luizpkk", "L12345");
        Funcionario funcionario1 = new Funcionario("João Silva", Cargo.Funcionario, "joao123", "senha123");
        //Mecanico funcionario2 = new Mecanico("Maria Oliveira", Cargo.Mecanico, "maria456", "senha456");
        FuncionarioService funcionarios = new FuncionarioService();
        funcionarios.adicionarFuncionario(gerente);
        funcionarios.adicionarFuncionario(funcionario1);
        System.out.println(funcionarios.getFuncionarios());
        System.out.println(gerente);
        System.out.println(funcionario1);
    }
}
