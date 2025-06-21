/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.oficina;

import Dominio.Estoque;
import Dominio.Fornecedor;
import Dominio.Peca;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author luizp
 */
public class Interface {
    Scanner scanner = new Scanner(System.in);

        Estoque estoque = new Estoque();
        Map<Integer, Fornecedor> fornecedores = new HashMap<>();

//        boolean x = true;
//        while(x == true) {
//            System.out.println("\n==== MENU ESTOQUE ====");
//            System.out.println("1. Adicionar fornecedor");
//            System.out.println("2. Adicionar peça");
//            System.out.println("3. Remover peça do estoque");
//            System.out.println("4. Editar nome da peça");
//            System.out.println("5. Editar preço de venda da peça");
//            System.out.println("6. Verificar quantidade suficiente");
//            System.out.println("7. Imprimir estoque completo");
//            System.out.println("0. Sair");
//            System.out.print("Escolha: ");
//
//            int opcao = scanner.nextInt();
//            scanner.nextLine(); // consumir quebra de linha
//
//            switch (opcao) {
//                case 1:
//                    System.out.print("Nome do fornecedor: ");
//                    String nomeFornecedor = scanner.nextLine();
//                    Fornecedor f = new Fornecedor(nomeFornecedor);
//                    fornecedores.put(f.getIdFornecedor(), f);
//                    System.out.println("Fornecedor cadastrado com ID: " + f.getIdFornecedor());
//                    break;
//
//                case 2:
//                    System.out.print("Nome da peça: ");
//                    String nomePeca = scanner.nextLine();
//                    System.out.print("Preço de venda: ");
//                    double precoVenda = scanner.nextDouble();
//                    System.out.print("Quantidade: ");
//                    int qtd = scanner.nextInt();
//                    System.out.print("ID do fornecedor: ");
//                    int idForn = scanner.nextInt();
//                    System.out.print("Preço unitário (compra): ");
//                    double precoUnitario = scanner.nextDouble();
//
//                    if (!fornecedores.containsKey(idForn)) {
//                        System.out.println("Fornecedor não encontrado!");
//                        break;
//                    }
//
//                    Peca p = new Peca(nomePeca, precoVenda);
//                    estoque.adicionarLote(p, qtd, idForn, precoUnitario);
//                    break;
//
//                case 3:
//                    System.out.print("ID da peça a remover: ");
//                    int idRemover = scanner.nextInt();
//                    System.out.print("Quantidade a remover: ");
//                    int qtdRemover = scanner.nextInt();
//                    estoque.removerPeca(idRemover, qtdRemover);
//                    break;
//
//                case 4:
//                    System.out.print("ID da peça: ");
//                    int idEditarNome = scanner.nextInt();
//                    scanner.nextLine();
//                    System.out.print("Novo nome: ");
//                    String novoNome = scanner.nextLine();
//                    estoque.editarNome(idEditarNome, novoNome);
//                    break;
//
//                case 5:
//                    System.out.print("ID da peça: ");
//                    int idEditarPreco = scanner.nextInt();
//                    System.out.print("Novo preço de venda: ");
//                    double novoPreco = scanner.nextDouble();
//                    estoque.editarPreco(idEditarPreco, novoPreco);
//                    break;
//
//                case 6:
//                    System.out.print("ID da peça: ");
//                    int idVerificar = scanner.nextInt();
//                    System.out.print("Quantidade desejada: ");
//                    int qtdVerificar = scanner.nextInt();
//                    boolean disponivel = estoque.quantidadeSuficiente(idVerificar, qtdVerificar);
//                    System.out.println("Tem estoque suficiente? " + (disponivel ? "Sim" : "Não"));
//                    break;
//
//                case 7:
//                    estoque.imprimirEstoque(fornecedores);
//                    break;
//
//                case 0:
//                    System.out.println("Encerrando...");
//                    return x = false;
//
//                default:
//                    System.out.println("Opção inválida!");
//            }
//        }
}
