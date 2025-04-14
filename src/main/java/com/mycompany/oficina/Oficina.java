/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.oficina;

import Dominio.Funcionario;

/**
 *
 * @author luizp
 */
public class Oficina {

    public static void main(String[] args) {
        Funcionario funcionario = new Funcionario("Luiz", "Gerente", "luizpkk", "L12345");
        System.out.println(funcionario.validaDados("luizpkk", "L12345"));
    }
}
