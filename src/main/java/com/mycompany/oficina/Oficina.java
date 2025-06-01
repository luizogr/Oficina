/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.oficina;

import Dominio.Cargo;
import Dominio.Cliente;
import Dominio.Elevador;
import Dominio.Estoque;
import Dominio.Funcionario;
import Dominio.Gerente;
import Dominio.Mecanico;
import Dominio.Peca;
import Dominio.Veiculo;
import Servicos.FuncionarioService;
import Servicos.GestaoClientes;
import Servicos.GestaoDeVeiculos;
import java.util.ArrayList;

/**
 *
 * @author luizp
 */
public class Oficina {

    public static void main(String[] args) {
//        Gerente gerente = new Gerente("Maria Oliveira", Cargo.Gerente, "maria456", "senha456");
//        Funcionario funcionario1 = new Funcionario("João Silva", Cargo.Funcionario, "joao123", "senha123");
//        Funcionario funcionario3 = new Funcionario("Carlos Souza", Cargo.Funcionario, "carlos789", "senha789");
//        Funcionario funcionario4 = new Funcionario("Ana Costa", Cargo.Funcionario, "ana321", "senha321");
//        FuncionarioService funcionarios = new FuncionarioService();
//        
//        funcionarios.adicionarFuncionario(gerente);
//        funcionarios.adicionarFuncionario(funcionario1);
//        funcionarios.adicionarFuncionario(funcionario3);
//        funcionarios.adicionarFuncionario(funcionario4);
//        
//        System.out.println(funcionarios.getFuncionarios());
//        System.out.println(gerente);
//        System.out.println(funcionario1);
//        System.out.println(gerente.getIdFuncionario());
//        System.out.println(funcionario1.getIdFuncionario());
//        funcionarios.removerFuncionario(2);
//        System.out.println(funcionarios.getFuncionarios());
//        funcionarios.editarNome(3, "João");
//        System.out.println(funcionario3.getNome());
//        System.out.println(funcionario3.getLogin());
//        System.out.println(funcionarios);
// Cria objeto de gestão com lista interna vazia
//        GestaoClientes gestao = new GestaoClientes();
//
//        // Cria e adiciona clientes diretamente via método da gestão
//        gestao.adicionaCliente(new Cliente("João", "Rua A", "99999-1111", "joao@email.com", 123456789));
//        gestao.adicionaCliente(new Cliente("Maria", "Rua B", "99999-2222", "maria@email.com", 987654321));
//        gestao.adicionaCliente(new Cliente("Pedro", "Rua C", "99999-3333", "pedro@email.com", 456789123));
//
//        // Imprime todos os clientes
//        System.out.println("Clientes cadastrados:");
//        for (Cliente c : gestao.getClientes()) {
//            System.out.println("ID: " + c.getIdCliente() + " | " + c);
//        }
//
//        // Testa edição de nome
//        int idMaria = gestao.getClientes().get(1).getIdCliente(); // Pega ID de Maria 
//        System.out.println("\nEditando nome de Maria para Mariana...");
//        gestao.editarNome(idMaria, "Mariana");
//
//        // Imprime todos novamente
//        System.out.println("\nClientes atualizados:");
//        for (Cliente c : gestao.getClientes()) {
//            System.out.println("ID: " + c.getIdCliente() + " | " + c);
//        }
//
//        // Testa remoção de Pedro
//        int idPedro = gestao.getClientes().get(2).getIdCliente(); // ID de Pedro
//        System.out.println("\nRemovendo cliente Pedro...");
//        boolean removido = gestao.removerCliente(idPedro);
//        System.out.println("Remoção bem-sucedida? " + removido);
//
//        // Lista final
//        System.out.println("\nLista final de clientes:");
//        for (Cliente c : gestao.getClientes()) {
//            System.out.println("ID: " + c.getIdCliente() + " | " + c);
//        }
//        System.out.println(Cliente.quantidadeDeInstanciasCliente());
        
        
        Estoque estoque = Estoque.carregarDoArquivo();

//        // Adicionando peças novas
//        Peca p1 = new Peca("Filtro de óleo", 29.90);
//        Peca p2 = new Peca("Pastilha de freio", 89.90);
//
//        boolean novaPeca1 = estoque.adicionarPeca(p1, 10);
//        boolean novaPeca2 = estoque.adicionarPeca(p2, 5);
//
//        System.out.println(novaPeca1 ? "Nova peça adicionada: " + p1.getNome() : "Quantidade atualizada de: " + p1.getNome());
//        System.out.println(novaPeca2 ? "Nova peça adicionada: " + p2.getNome() : "Quantidade atualizada de: " + p2.getNome());
//
//        // Imprimindo estoque inicial
//        System.out.println("\nEstoque atual:");
//        estoque.imprimirEstoque();
//
//        // Remover parcialmente uma peça
//        estoque.removerPeca(p1.getIdPeca(), 3); // Remove 3 do filtro de óleo
//
//        // Tentar remover mais do que há em estoque (deve falhar)
//        estoque.removerPeca(p2.getIdPeca(), 10);
//
//        // Remover o restante da peça
//        estoque.removerPeca(p1.getIdPeca(), 7); // Remove os 7 restantes
//
//        // Editar nome e preço da peça 2
//        estoque.editarNome(p2.getIdPeca(), "Pastilha de freio (Premium)");
//        estoque.editarPreço(p2.getIdPeca(), 109.90);
//
//        // Re-adicionar mais da peça 2
//        estoque.adicionarPeca(p2, 2);


//        //Editar nome e preço da peça 2
//        Peca p2 = estoque.buscarPecaPorId(2);
//        estoque.editarNome(p2.getIdPeca(), "Pastilha de freio");
//        estoque.editarPreço(p2.getIdPeca(), 100.90);
        // Mostrar estoque final
        System.out.println("\nEstoque após alterações:");
        estoque.imprimirEstoque();
        
        Elevador elevador1 = new Elevador(1, "balanceamento");
        System.out.println("Elevador: " + elevador1);
        
        
        
        // Criando instâncias de gerenciamento
        GestaoClientes gestaoClientes = new GestaoClientes();
        GestaoDeVeiculos gestaoVeiculos = GestaoDeVeiculos.carregarDoArquivo();

        // Criando clientes
        Cliente cliente1 = new Cliente("João", "Rua A", "123456789", "joao@email.com", 123456789);
        Cliente cliente2 = new Cliente("Maria", "Rua B", "987654321", "maria@email.com", 987654321);
        gestaoClientes.adicionaCliente(cliente1);
        gestaoClientes.adicionaCliente(cliente2);

        System.out.println("Clientes adicionados:");
        for (Cliente c : gestaoClientes.getClientes()) {
            System.out.println(c);
        }

        // Criando veículos
        Veiculo veiculo1 = new Veiculo("Fiat Uno", "ABC1234", 2010);
        Veiculo veiculo2 = new Veiculo("Ford Ka", "XYZ9876", 2015);
        Veiculo veiculo3 = new Veiculo("Chevrolet Onix", "DEF5678", 2020);

        // Associando veículos aos clientes
        gestaoVeiculos.adicionarVeiculo(cliente1.getIdCliente(), veiculo1);
        gestaoVeiculos.adicionarVeiculo(cliente1.getIdCliente(), veiculo2);
        gestaoVeiculos.adicionarVeiculo(cliente2.getIdCliente(), veiculo3);

        // Buscar veículo por placa
        System.out.println("\nBuscar veículo com placa ABC1234:");
        System.out.println(gestaoVeiculos.buscarVeiculoPorPlaca("ABC1234"));

        // Buscar veículos de um cliente
        System.out.println("\nVeículos do cliente João:");
        ArrayList<Veiculo> veiculosJoao = gestaoVeiculos.buscarVeiculosDoProprietario(cliente1.getIdCliente());
        for (Veiculo v : veiculosJoao) {
            System.out.println(v);
        }

        // Editar dados
        gestaoClientes.editarEmail(cliente1.getIdCliente(), "joao_novo@email.com");
        gestaoVeiculos.editarModelo("XYZ9876", "Ford Fiesta");
        gestaoVeiculos.editarAno("XYZ9876", 2017);

        System.out.println("\nDados atualizados:");
        System.out.println("Cliente João: " + gestaoClientes.buscarCliente(cliente1.getIdCliente()));
        System.out.println("Veículo atualizado: " + gestaoVeiculos.buscarVeiculoPorPlaca("XYZ9876"));

        // Remover veículo
        gestaoVeiculos.removerVeiculo("DEF5678");
        System.out.println("\nVeículos de Maria após remoção:");
        ArrayList<Veiculo> veiculosMaria = gestaoVeiculos.buscarVeiculosDoProprietario(cliente2.getIdCliente());
        for (Veiculo v : veiculosMaria) {
            System.out.println(v);
        }

        // Remover cliente
        gestaoClientes.removerCliente(cliente1.getIdCliente());
        System.out.println("\nClientes após remoção de João:");
        for (Cliente c : gestaoClientes.getClientes()) {
            System.out.println(c);
        }
        
        gestaoVeiculos.salvar();
        
        System.out.println(Cliente.getContadorDeVeiculos());
        
        
        
        
        

    }
}
