/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dominio;

import java.util.Comparator;

/**
 * Implementa a interface Comparator para comparar dois objetos Cliente com base em seu nome
 * @author luizp
 */
public class ComparaClientePorNome implements Comparator<Cliente>{
    /**
     * Compara dois clientes com base em seus nomes
     * @param c1 o primeiro cliente a ser comparado
     * @param c2 o segundo cliente a ser comparado
     * @return 
     */
    @Override
    public int compare(Cliente c1, Cliente c2) {
        String nome1 = c1.getNome();
        String nome2 = c2.getNome();
        
        int tamanhoMenor = Math.min(nome1.length(), nome2.length());
        
        for (int i = 0; i < tamanhoMenor; i++) {
            char char1 = nome1.charAt(i);
            char char2 = nome2.charAt(i);
            
            if (char1 != char2) {
                return char1 - char2;
            }
        }
        return nome1.length() - nome2.length();
    }
}
