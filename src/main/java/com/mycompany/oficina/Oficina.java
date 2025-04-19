/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.oficina;

import Dominio.Cargo;
import Dominio.Funcionario;
import Dominio.Gerente;

/**
 *
 * @author luizp
 */
public class Oficina {

    public static void main(String[] args) {
        Gerente gerente = new Gerente("Luiz", Cargo.Gerente, "luizpkk", "L12345");
        System.out.println(gerente.getNome());
    }
}
