/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.oficina;

import Dominio.Agendamento;
import Dominio.Cargo;
import Dominio.Cliente;
import Dominio.Elevador;
import Dominio.Estoque;
import Dominio.Funcionario;
import Dominio.Gerente;
import Dominio.Mecanico;
import Dominio.OrdemDeServico;
import Dominio.Peca;
import Dominio.Recepcionista;
import Dominio.StatusOS;
import Dominio.Veiculo;
import Servicos.FuncionarioService;
import Servicos.GestaoClientes;
import Servicos.GestaoDeVeiculos;
import java.util.ArrayList;
import static Dominio.Cargo.Recepcionista;
import Dominio.CategoriaDespesa;
import Dominio.ComparaAgendamentoPorCliente;
import Dominio.ComparaAgendamentoPorData;
import Dominio.ComparaClientePorId;
import Dominio.ComparaClientePorNome;
import Dominio.Fornecedor;
import Dominio.Lancamento;
import Dominio.NotaFiscal;
import Dominio.Observer;
import Dominio.Servicos;
import Dominio.StatusAgendamento;
import Dominio.TipoElevador;
import Dominio.TipoLancamento;
import Servicos.Agenda;
import Servicos.GestaoDeOrdemDeServico;
import Servicos.GestaoFinanceira;
import Servicos.SistemaOficina;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author luizp
 */
public class Oficina {

    public static void main(String[] args) {
        //Questão 1 e 3
//        System.out.println("Questão 1 e 3");
//        System.out.println("--------------------------------------------");
//        
//        System.out.println("TESTE DA QUESTÃO 1 e 3");
//        
//        
//        SistemaOficina sO = new SistemaOficina();
//        
//        System.out.println("\n1. Criando funcionarios");
//        Gerente g = new Gerente("Davi", "davi", "1234", 4000);
//        Mecanico m = new Mecanico("Marcos", "marcos", "12345", 5000, "Eletrica");
//        Recepcionista r = new Recepcionista("Maria", "maria", "123", 3000);
//        
//        System.out.println("\n2. Mostrando toString de Cliente e GestaoClientes");
//        System.out.println(g.toString());
//        System.out.println(sO.getGestaoFuncionarios().toString());

        //Questão 2
//        System.out.println("Questão 2");
//        System.out.println("--------------------------------------------");
//        
//        System.out.println("TESTE DA QUESTÃO 2");
//        SistemaOficina sO = new SistemaOficina();
//        
//        Gerente g = new Gerente("Davi", "davi", "1234", 4000);
//        
//        sO.login("davi", "1234");
//        
//        sO.getGestaoFinanceira().adicionarDespesa("produtos", 50, CategoriaDespesa.Uso, sO.getFuncionarioLogado());
//        sO.getGestaoFinanceira().gerarBalancoMes(Month.MAY, 2025, sO.getFuncionarioLogado());
        

        //Questão 4
//        System.out.println("Questão 4");
//        System.out.println("--------------------------------------------");
//        
//        System.out.println("TESTE DA QUESTÃO 4");
//        
//        
//        SistemaOficina sO = new SistemaOficina();
//        
//        System.out.println("\n1. Criando funcionarios");
//        Gerente g = new Gerente("Davi", "davi", "1234", 4000);
//        Mecanico m = new Mecanico("Marcos", "marcos", "12345", 5000, "Eletrica");
//        Recepcionista r = new Recepcionista("Maria", "maria", "123", 3000);
//        
//        sO.getGestaoFuncionarios().adicionarFuncionario(g);
//        sO.getGestaoFuncionarios().adicionarFuncionario(m);
//        sO.getGestaoFuncionarios().adicionarFuncionario(r);
//        sO.getGestaoFuncionarios().salvarFuncionarios();
//        
//        System.out.println("\n2. Testando o super nas subclasses");
//        
//        System.out.println(sO.getGestaoFuncionarios().toString());

        //Questão 5
//        System.out.println("Questão 5");
//        System.out.println("--------------------------------------------");
//        
//        System.out.println("TESTE DA QUESTÃO 5");
//        
//        System.out.println("\n1. Mostrando os elevadores da oficina");
//        SistemaOficina.imprimirStatusElevadores();
        

        //Questão 6
//        System.out.println("Questão 6");
//        System.out.println("--------------------------------------------");
//        
//        System.out.println("TESTE DA QUESTÃO 6");
//        
//        System.out.println("\n1. Cadastrando e exibindo funcionarios");
//        SistemaOficina sO = new SistemaOficina();
//        
//        Gerente g = new Gerente("Davi", "davi", "1234", 4000);
//        Mecanico m = new Mecanico("Marcos", "marcos", "12345", 5000, "Eletrica");
//        Recepcionista r = new Recepcionista("Maria", "maria", "123", 3000);
//        
//        sO.getGestaoFuncionarios().adicionarFuncionario(g);
//        sO.getGestaoFuncionarios().adicionarFuncionario(m);
//        sO.getGestaoFuncionarios().adicionarFuncionario(r);
//        sO.getGestaoFuncionarios().salvarFuncionarios();
//        System.out.println(sO.getGestaoFuncionarios().toString());
//        
//        System.out.println("\n2. Editando dados dos funcionarios");
//        sO.getGestaoFuncionarios().editarNome(3, "Luiz");
//        sO.getGestaoFuncionarios().editarLogin(1, "marcos_m");
//        sO.getGestaoFuncionarios().editarLogin(3, "luiz");
//        sO.getGestaoFuncionarios().editarEspecialidade(2, "Suspensão");
//        sO.getGestaoFuncionarios().editarCargo(3, Cargo.Gerente);
//        sO.getGestaoFuncionarios().editarSenha(3, "4321");
//        sO.getGestaoFuncionarios().editarSalario(3, 3000);
//        System.out.println(sO.getGestaoFuncionarios().toString());

        //Questão 7
//        System.out.println("Questão 7");
//        System.out.println("--------------------------------------------");
//        
//        System.out.println("TESTE DA QUESTÃO 7");
//        
//        System.out.println("\n1. Cadastrando e exibindo clientes");
//        SistemaOficina sO = new SistemaOficina();
//        
//        sO.getGestaoClientes().adicionaCliente(new Cliente("Carlos", "Rua A", "111111", "carlos@gmail",333L));  
//        sO.getGestaoClientes().adicionaCliente(new Cliente("Ana", "Rua B", "2222222", "ana@gmail", 111L));  
//        sO.getGestaoClientes().adicionaCliente(new Cliente("Bruno", "Rua C", "3333333", "bruno@gmail", 222L));
//        System.out.println(sO.getGestaoClientes().toString());
//        
//        System.out.println("\n2. Editando dados dos clientes");
//        sO.getGestaoClientes().editarCpf(2, 444L);
//        sO.getGestaoClientes().editarEmail(1, "carlos_c@gmail");
//        sO.getGestaoClientes().editarEndereco(3, "Rua D");
//        sO.getGestaoClientes().editarTelefone(3, "44444444");
//        sO.getGestaoClientes().editarNome(1, "Carlos Silva");
//        System.out.println(sO.getGestaoClientes().toString());
//        
//        System.out.println("\n2. Excluindo cliente");
//        sO.getGestaoClientes().removerCliente(3);
//        System.out.println(sO.getGestaoClientes().toString());
        
        
        //Questão 8
//        System.out.println("Questão 8");
//        System.out.println("--------------------------------------------");
//        
//        System.out.println("TESTE DA QUESTÃO 8");
//        
//        System.out.println("\n1. Cadastrando e exibindo clientes");
//        SistemaOficina sO = new SistemaOficina();
//        
//        sO.getGestaoClientes().adicionaCliente(new Cliente("Carlos", "Rua A", "111111", "carlos@gmail",333L));  
//        sO.getGestaoClientes().adicionaCliente(new Cliente("Ana", "Rua B", "2222222", "ana@gmail", 111L));  
//        sO.getGestaoClientes().adicionaCliente(new Cliente("Bruno", "Rua C", "3333333", "bruno@gmail", 222L));
//        System.out.println(sO.getGestaoClientes().toString());
//        
//        System.out.println("\n2. Criando veiculos");
//        Veiculo v1 = new Veiculo("Uno", "ABC1234", 2006);
//        Veiculo v2 = new Veiculo("Toyota Corolla", "XYZ7890", 2021);
//        sO.getGestaoVeiculos().adicionarVeiculo(1, v1);
//        sO.getGestaoVeiculos().adicionarVeiculo(2, v2);
//        
//        System.out.println("\n2. Criando OSs");
//        OrdemDeServico oS1 = new OrdemDeServico("ABC1234", 1, "Alinhamento");
//        OrdemDeServico oS2 = new OrdemDeServico("XYZ7890", 2, "Alinhamento");
//        sO.getGestaoOS().adicionarOS(oS1);
//        sO.getGestaoOS().adicionarOS(oS2);
//        sO.getGestaoOS().adicionarServico(oS1.getIdOS(), Servicos.ALINHAMENTO);
//        sO.getGestaoOS().adicionarServico(oS2.getIdOS(), Servicos.ALINHAMENTO);
//        sO.getGestaoOS().finalizarEGerarNota(oS1.getIdOS());
//        sO.getGestaoOS().finalizarEGerarNota(oS2.getIdOS());
//        
//        Peca p1 = new Peca("Filtro de óleo", 50);
//        Fornecedor f1 = new Fornecedor("Autopecas 1");
//        sO.getEstoque().adicionarLote(p1, 30, f1.getIdFornecedor(), 40);
//        Map<Integer, Integer> pecas = new HashMap<>();
//        pecas.put(p1.getIdPeca(), 2);
//        sO.getGestaoOS().registrarVendaDireta(1, pecas);
//        
//        
//        System.out.println("\n3. Verificando OSs do cliente");
//        System.out.println(sO.getGestaoOS().buscarOSPorCliente(1));
//        System.out.println(sO.getGestaoOS().buscarOSPorCliente(2));
//        System.out.println(sO.getGestaoOS().buscarOSPorCliente(3));

        //Questão 9
//        System.out.println("Questão 9");
//        System.out.println("--------------------------------------------");
//        
//        System.out.println("TESTE DA QUESTÃO 9");
//        
//        System.out.println("\n1. Cadastrando e exibindo clientes, estoque e Ordem de serviço");
//        SistemaOficina sO = new SistemaOficina();
//        
//        sO.getGestaoClientes().adicionaCliente(new Cliente("Carlos", "Rua A", "111111", "carlos@gmail",333L));  
//        sO.getGestaoClientes().adicionaCliente(new Cliente("Ana", "Rua B", "2222222", "ana@gmail", 111L));  
//        sO.getGestaoClientes().adicionaCliente(new Cliente("Bruno", "Rua C", "3333333", "bruno@gmail", 222L));
//        System.out.println(sO.getGestaoClientes().toString());
//        
//        Peca p1 = new Peca("Filtro de óleo", 50);
//        Peca p2 = new Peca("Vela", 45);
//        Peca p3 = new Peca("Liquido de arrefecimento", 70);
//        
//        Fornecedor f1 = new Fornecedor("Autopecas 1");
//        Fornecedor f2 = new Fornecedor("Autopecas 2");
//        
//        sO.getEstoque().adicionarLote(p1, 30, f1.getIdFornecedor(), 40);
//        sO.getEstoque().adicionarLote(p2, 50, f1.getIdFornecedor(), 30);
//        sO.getEstoque().adicionarLote(p3, 10, f2.getIdFornecedor(), 55);
//        System.out.println(sO.getEstoque().toString());
//        
//        Map<Integer, Integer> pecas = new HashMap<>();
//        pecas.put(1, 2);
//        Map<Integer, Integer> pecas2 = new HashMap<>();
//        pecas2.put(2, 4);
//        pecas2.put(3, 1);
//        
//        sO.getGestaoOS().registrarVendaDireta(1, pecas);
//        sO.getGestaoOS().registrarVendaDireta(3, pecas2);
//        
//        System.out.println("\n2. Criando novas instâncias de GestaoClientes, Estoque e GestaoDeOrdemDeServico");
//        GestaoClientes gC = GestaoClientes.carregarDoArquivo();
//        System.out.println(gC.toString());
//        
//        Estoque e = Estoque.carregarDoArquivo(sO.getGestaoFinanceira());
//        System.out.println(e.toString());
//        
//        GestaoDeOrdemDeServico gOS = GestaoDeOrdemDeServico.carregarDoArquivo(e, sO.getGestaoFinanceira());
//        System.out.println(gOS.toString());
        
        //Questão 10
//        System.out.println("Questão 10");
//        System.out.println("--------------------------------------------");
//        
//        System.out.println("TESTE DA QUESTÃO 10");
//        
//        System.out.println("\n1. Cadastrando Ordem de serviço");
//        SistemaOficina sO = new SistemaOficina();
//        
//        sO.getGestaoClientes().adicionaCliente(new Cliente("Carlos", "Rua A", "111111", "carlos@gmail",333L)); 
//        
//        Veiculo veiculo = new Veiculo("Toyota Corolla", "XYZ7890", 2021);
//        
//        Peca p1 = new Peca("Filtro de óleo", 50);
//        
//        Fornecedor f1 = new Fornecedor("Autopecas 1");
//        
//        sO.getEstoque().adicionarLote(p1, 30, f1.getIdFornecedor(), 40);
//
//        Map<Integer, Integer> pecas = new HashMap<>();
//        pecas.put(1, 2);
//        sO.getGestaoOS().registrarVendaDireta(1, pecas);
//        
//        
//        sO.getGestaoOS().iniciarOSdeServico(1, veiculo.getPlaca(), "Troca filtro de óleo");
//        sO.getGestaoOS().adicionarServico(1, Servicos.TROCA_DE_OLEO);
//        sO.getGestaoOS().finalizarEGerarNota(1);
//        
//        System.out.println("\n2. Mostrando Balanço e Notas fiscais salvas na gestão financeira");
//        Gerente g = new Gerente("Ana", "ana.g", "123");
//        sO.getGestaoFuncionarios().adicionarFuncionario(g);
//        sO.getGestaoFinanceira().gerarBalancoMes(Month.JUNE, 2025, g);
//        sO.getGestaoFinanceira().imprimirNotasPorCliente(1);


        //Questão 11
//        System.out.println("Questão 11");
//        System.out.println("--------------------------------------------");
//        
//        System.out.println("TESTE DA QUESTÃO 11");
//        
//        System.out.println("\n1. Quantidade inicial dos contadores de veiculos pelas variaveis de classe");
//        
//        System.out.println("Contagem inicial de veículos (private): " + Cliente.getContadorDeVeiculos());
//        System.out.println("Contagem inicial de veículos (protected): " + Cliente.getContadorDeVeiculosProtected());
//
//        System.out.println("\n2. Criando 3 veiculos");
//        Veiculo v = new Veiculo("Fiat Uno", "AAA-1111", 2010);
//        Veiculo v1 = new Veiculo("Chevrolet Onix", "BBB-2222", 2018);
//        Veiculo v2 = new Veiculo("Ford Ka", "CCC-3333", 2020);
//
//        System.out.println("\n3. Quantidade final dos contadores de veiculos pelas variaveis de classe");
//        System.out.println("\nContagem final de veículos (private): " + Cliente.getContadorDeVeiculos());
//        System.out.println("Contagem final de veículos (protected): " + Cliente.getContadorDeVeiculosProtected());
        
        
        //Questão 12
//        System.out.println("Questão 12");
//        System.out.println("--------------------------------------------");
//        
//        System.out.println("TESTE DA QUESTÃO 12");
//        
//        System.out.println("\n1. Metodo de classe para retornar quantas instancias de veiculos criadas");
//        
//        System.out.println("Contagem inicial de veículos pelo metodo de classe): " + Cliente.getContadorDeVeiculos());
//
//        System.out.println("\n2. Criando 3 veiculos");
//        Veiculo v = new Veiculo("Fiat Uno", "AAA-1111", 2010);
//        Veiculo v1 = new Veiculo("Chevrolet Onix", "BBB-2222", 2018);
//        Veiculo v2 = new Veiculo("Ford Ka", "CCC-3333", 2020);
//
//        System.out.println("\n3. retornar quantas instancias de veiculos criadas apos novos veiculos");
//        System.out.println("\nContagem final de veículos pelo metodo de classe: " + Cliente.getContadorDeVeiculos());
        
        
        //Questão 13
//        System.out.println("Questão 13");
//        System.out.println("--------------------------------------------");
//        
//        System.out.println("TESTE DA QUESTÃO 13");
//        
//        System.out.println("\n1. Adiciona clientes a lista");
//        SistemaOficina sO = new SistemaOficina();
//        
//        sO.getGestaoClientes().adicionaCliente(new Cliente("Carlos", "Rua A", "111111", "carlos@gmail",333L));   
//        sO.getGestaoClientes().adicionaCliente(new Cliente("Ana", "Rua B", "2222222", "ana@gmail", 111L));    
//        sO.getGestaoClientes().adicionaCliente(new Cliente("Bruno", "Rua C", "3333333", "bruno@gmail", 222L));
//        
//        System.out.println("\n2. Lista Original (Desordenada)");
//        for (Cliente c : sO.getGestaoClientes().getClientes()) {
//            System.out.println(c);
//        }
//        
//        System.out.println("\n3. Ordenando por NOME");
//        
//        Collections.sort(sO.getGestaoClientes().getClientes(), new ComparaClientePorNome());
//        
//        for (Cliente c : sO.getGestaoClientes().getClientes()) {
//            System.out.println(c);
//        }
//        
//        System.out.println("\n4. Ordenando por ID");
//        
//        Collections.sort(sO.getGestaoClientes().getClientes(), new ComparaClientePorId());
//
//        for (Cliente c : sO.getGestaoClientes().getClientes()) {
//            System.out.println(c);
//        }
//        
//        System.out.println("\n5. Criando 3 veiculos");
//        Veiculo v = new Veiculo("Fiat Uno", "AAA-1111", 2010);
//        Veiculo v1 = new Veiculo("Chevrolet Onix", "BBB-2222", 2018);
//        Veiculo v2 = new Veiculo("Ford Ka", "CCC-3333", 2020);
//        
//        sO.getAgenda().agendar(new Agendamento(v.getPlaca(), 1, "Alinhamento", 1, LocalDateTime.of(2025, 7, 10, 14, 0)));
//        sO.getAgenda().agendar(new Agendamento(v1.getPlaca(), 3, "Troca de óleo", 1, LocalDateTime.of(2025, 7, 10, 10, 0)));
//        sO.getAgenda().agendar(new Agendamento(v2.getPlaca(), 3, "Troca de óleo", 1, LocalDateTime.of(2025, 7, 10, 15, 0)));
//        sO.getAgenda().salvar();
//        
//        System.out.println("\n6. Lista Original (Desordenada)");
//        sO.getAgenda().imprimirAgenda();
//
//        System.out.println("\n3. Ordenando por Data");
//        Collections.sort(sO.getAgenda().getTodosAgendamentos(), new ComparaAgendamentoPorData());
//        sO.getAgenda().imprimirAgenda();
//        
//        System.out.println("\n4. Ordenando por ID");
//        Collections.sort(sO.getAgenda().getTodosAgendamentos(), new ComparaAgendamentoPorCliente());
//        sO.getAgenda().imprimirAgenda();


        //Questão 14
//        System.out.println("Questão 14");
//        System.out.println("--------------------------------------------");
//        
//        System.out.println("TESTE DA QUESTÃO 14");
//        
//        System.out.println("\n1. Criando e salvaldo instancias em cada gestão");
//        SistemaOficina sO = new SistemaOficina();
//        
//        Gerente g = new Gerente("Davi", "davi", "1234", 4000);
//        Mecanico m = new Mecanico("Marcos", "marcos", "12345", 5000, "Eletrica");
//        Recepcionista r = new Recepcionista("Maria", "maria", "123", 3000);
//        
//        sO.getGestaoFuncionarios().adicionarFuncionario(g);
//        sO.getGestaoFuncionarios().adicionarFuncionario(m);
//        sO.getGestaoFuncionarios().adicionarFuncionario(r);
//        sO.getGestaoFuncionarios().salvarFuncionarios();
//        System.out.println(sO.getGestaoFuncionarios().toString());
//        
//        Cliente c = new Cliente("Carlos", "Rua A", "111111", "carlos@gmail",333L);
//        sO.getGestaoClientes().adicionaCliente(c);  
//        System.out.println( sO.getGestaoClientes().toString());
//
//        Veiculo v = new Veiculo("Fiat Uno", "AAA-1111", 2010);
//        sO.getGestaoVeiculos().adicionarVeiculo(c.getIdCliente(), v);
//        sO.getGestaoVeiculos().salvar();
//        System.out.println(sO.getGestaoVeiculos().toString());
//        
//        Peca p1 = new Peca("Filtro de óleo", 50);
//        
//        Fornecedor f1 = new Fornecedor("Autopecas 1");
//        
//        sO.getEstoque().adicionarLote(p1, 30, f1.getIdFornecedor(), 40);
//        System.out.println(sO.getEstoque().toString());
//        
//        Map<Integer, Integer> pecas = new HashMap<>();
//        pecas.put(1, 2);
//        
//        sO.getAgenda().agendar(new Agendamento(v.getPlaca(), 3, "Troca de óleo", 1, LocalDateTime.of(2025, 7, 10, 15, 0)));
//        sO.getAgenda().salvar();
//        sO.getAgenda().imprimirAgenda();
//        
//        sO.getAgenda().IniciarServico(1, m.getIdFuncionario());
//        
//        sO.getGestaoOS().registrarVendaDireta(c.getIdCliente(), pecas);
//        
//        System.out.println(sO.getGestaoFinanceira().toString());
//        
//        System.out.println("\n2. recuperando dados de cada gestão");
//        
//        FuncionarioService gf = FuncionarioService.carregarDoArquivo();
//        System.out.println(gf.toString());
//        
//        GestaoClientes gc = GestaoClientes.carregarDoArquivo();
//        System.out.println(gc.toString());
//        
//        GestaoDeVeiculos gv = GestaoDeVeiculos.carregarDoArquivo();
//        System.out.println(gv.toString()); 
//        
//        GestaoFinanceira gfi = GestaoFinanceira.carregarDoArquivo();
//        System.out.println(gfi.toString());
//        
//        Estoque e = Estoque.carregarDoArquivo(gfi);
//        System.out.println(e.toString()); 
//        
//        Agenda a = Agenda.carregarDoArquivo();
//        System.out.println(a.toString());
//        
//        GestaoDeOrdemDeServico gos = GestaoDeOrdemDeServico.carregarDoArquivo(e, gfi);
//        System.out.println(gos.toString());






        // Questão 15
//        System.out.println("Questão 15");
//        System.out.println("--------------------------------------------");
//        SistemaOficina sistemaOficina = new SistemaOficina();
//        
//        sistemaOficina.getGestaoFuncionarios().adicionarFuncionario(new Gerente("Ana", "ana.g", "123"));
//        sistemaOficina.getGestaoFuncionarios().adicionarFuncionario(new Mecanico("Bruno", "bruno.m", "456", "Motor"));
//        sistemaOficina.getGestaoFuncionarios().adicionarFuncionario(new Mecanico("Carlos", "carlos.m", "789", "Suspensão"));
//        sistemaOficina.getGestaoFuncionarios().salvarFuncionarios();
//        System.out.println("TESTE DA QUESTÃO 15");
//
//        System.out.println("\n1. Percorrendo com Iterator e o laço 'while'");
//        
//        Iterator<Funcionario> iterator = sistemaOficina.getGestaoFuncionarios().getFuncionarios().iterator();
//        
//        while(iterator.hasNext()) {
//            // Imprime o próximo funcionário da lista
//            System.out.println(iterator.next());
//        }
//
//        System.out.println("\n2. Percorrendo com o laço 'foreach'");
//        
//        for (Funcionario f : sistemaOficina.getGestaoFuncionarios().getFuncionarios()) {
//            System.out.println(f);
//        }
        
        
        // Questão 16
//        System.out.println("Questão 16");
//        System.out.println("--------------------------------------------");
//        
//        SistemaOficina sistemaOficina = new SistemaOficina();
//
//        sistemaOficina.getGestaoClientes().adicionaCliente(new Cliente("Carlos", "Rua A", "111111", "carlos@gmail",333L));   // ID: 1
//        sistemaOficina.getGestaoClientes().adicionaCliente(new Cliente("Ana", "Rua B", "2222222", "ana@gmail", 111L));    // ID: 2
//        sistemaOficina.getGestaoClientes().adicionaCliente(new Cliente("Bruno", "Rua C", "3333333", "bruno@gmail", 222L));  // ID: 3
//        
//        System.out.println("TESTE DA QUESTÃO 16");
//
//        // Imprime a lista original, desordenada
//        System.out.println("\n1. Lista Original (Desordenada)");
//        for (Cliente c : sistemaOficina.getGestaoClientes().getClientes()) {
//            System.out.println(c);
//        }
//
//        System.out.println("\n2. Ordenando por NOME");
//        
//        Collections.sort(sistemaOficina.getGestaoClientes().getClientes(), new ComparaClientePorNome());
//        
//        for (Cliente c : sistemaOficina.getGestaoClientes().getClientes()) {
//            System.out.println(c);
//        }
//        
//        System.out.println("\n3. Ordenando por ID");
//        
//        Collections.sort(sistemaOficina.getGestaoClientes().getClientes(), new ComparaClientePorId());
//
//        for (Cliente c : sistemaOficina.getGestaoClientes().getClientes()) {
//            System.out.println(c);
//        }

        // Questão 17
//        System.out.println("Questão 17");
//        System.out.println("--------------------------------------------");
//        
//        System.out.println("TESTE DA QUESTÃO 17");
//        
//        
//        SistemaOficina sO = new SistemaOficina();
//        
//        sO.getGestaoClientes().adicionaCliente(new Cliente("Carlos", "Rua A", "111111", "carlos@gmail",333L));   
//        sO.getGestaoClientes().adicionaCliente(new Cliente("Ana", "Rua B", "2222222", "ana@gmail", 111L));
//        sO.getGestaoClientes().adicionaCliente(new Cliente("Bruno", "Rua C", "3333333", "bruno@gmail", 222L));
//        sO.getGestaoClientes().adicionaCliente(new Cliente("Joao", "Rua D", "4444444", "joao@gmail", 444L));
//        
//        System.out.println("\n1. Testando o nosso método 'find' (Busca Linear)");
//        
//        Cliente clienteBusca = new Cliente();
//        clienteBusca.setNome("Bruno");
//        ComparaClientePorNome comparadorPorNome = new ComparaClientePorNome();
//        
//        System.out.println("Buscando por cliente com nome 'Bruno'...");
//        Cliente encontradoComFind = sO.getGestaoClientes().find(clienteBusca, comparadorPorNome);
//        
//        if (encontradoComFind != null) {
//            System.out.println("Encontrado: " + encontradoComFind);
//        } else {
//            System.out.println("Cliente não encontrado.");
//        }
//
//        System.out.println("\n2. Testando o Collections.binarySearch (Busca Binária)");
//        List<Cliente> listaParaBusca = sO.getGestaoClientes().getClientes();
//        
//        System.out.println("\nOrdenando a lista por nome antes da busca...");
//        Collections.sort(listaParaBusca, comparadorPorNome);
//        
//        System.out.println("Lista ordenada:");
//        listaParaBusca.forEach(System.out::println);
//        
//        System.out.println("\nBuscando por cliente com nome 'Bruno'...");
//        
//        int indice = Collections.binarySearch(listaParaBusca, clienteBusca, comparadorPorNome);
//        
//        if (indice >= 0) {
//            System.out.println("Encontrado: " + listaParaBusca.get(indice) + " no índice " + indice);
//        } else {
//            System.out.println("Cliente não encontrado.");
//        }

        // Questão 18 
//        System.out.println("Questão 18");
//        System.out.println("--------------------------------------------");
//        
//        SistemaOficina sistemaOficina = new SistemaOficina();
//      
//        System.out.println("TESTE DA QUESTÃO 16");
//
//        // Imprime a lista original, desordenada
//        System.out.println("\n1. Criando clientes");
//        Cliente c1 = new Cliente("Ana Silva", "Rua das Flores, 1", "31911111111", "ana.silva@email.com", 11122233344L);
//        Cliente c2 = new Cliente("Bruno Costa", "Av. Principal, 2", "31922222222", "bruno.costa@email.com", 22233344455L);
//        Cliente c3 = new Cliente("Carlos Oliveira", "Praça da Matriz, 3", "31933333333", "carlos.o@email.com", 33344455566L);
//        Cliente c4 = new Cliente("Daniela Pereira", "Alameda dos Anjos, 4", "31944444444", "daniela.p@email.com", 44455566677L);
//        Cliente c5 = new Cliente("Eduardo Ferreira", "Travessa do Sol, 5", "31955555555", "eduardo.f@email.com", 55566677788L);
//        Cliente c6 = new Cliente("Fernanda Rodrigues", "Rodovia Central, km 6", "31966666666", "fernanda.r@email.com", 66677788899L);
//        Cliente c7 = new Cliente("Gustavo Almeida", "Beco da Lua, 7", "31977777777", "gustavo.a@email.com", 77788899900L);
//        Cliente c8 = new Cliente("Helena Lima", "Estrada Nova, 8", "31988888888", "helena.l@email.com", 88899900011L);
//        Cliente c9 = new Cliente("Igor Martins", "Caminho da Serra, 9", "31999999999", "igor.m@email.com", 99900011122L);
//        Cliente c10 = new Cliente("Juliana Barbosa", "Vila do Ouro, 10", "31910101010", "juliana.b@email.com", 10101010101L);
//
//        // Adiciona os clientes à gestão
//        sistemaOficina.getGestaoClientes().adicionaCliente(c1);
//        sistemaOficina.getGestaoClientes().adicionaCliente(c2);
//        sistemaOficina.getGestaoClientes().adicionaCliente(c3);
//        sistemaOficina.getGestaoClientes().adicionaCliente(c4);
//        sistemaOficina.getGestaoClientes().adicionaCliente(c5);
//        sistemaOficina.getGestaoClientes().adicionaCliente(c6);
//        sistemaOficina.getGestaoClientes().adicionaCliente(c7);
//        sistemaOficina.getGestaoClientes().adicionaCliente(c8);
//        sistemaOficina.getGestaoClientes().adicionaCliente(c9);
//        sistemaOficina.getGestaoClientes().adicionaCliente(c10);
//        System.out.println("\n2. Adicionando pecas ao estoque");
//
//        Peca p1 = new Peca("Filtro de óleo", 50);
//        Peca p2 = new Peca("Vela", 45);
//        Peca p3 = new Peca("Liquido de arrefecimento", 70);
//        
//        Fornecedor f1 = new Fornecedor("Autopecas 1");
//        Fornecedor f2 = new Fornecedor("Autopecas 2");
//        
//        sistemaOficina.getEstoque().adicionarLote(p1, 30, f1.getIdFornecedor(), 40);
//        sistemaOficina.getEstoque().adicionarLote(p2, 50, f1.getIdFornecedor(), 30);
//        sistemaOficina.getEstoque().adicionarLote(p3, 10, f2.getIdFornecedor(), 55);
//        System.out.println(sistemaOficina.getEstoque().toString());
//        
//        System.out.println("\n3. Criando e salvando veiculos");
//        
//        Veiculo v1 = new Veiculo("Fiat Uno", "ABC-1111", 2010);
//        Veiculo v2 = new Veiculo("VW Gol", "DEF-2222", 2015);
//        Veiculo v3 = new Veiculo("Chevrolet Onix", "GHI-3333", 2018);
//        Veiculo v4 = new Veiculo("Ford Ka", "JKL-4444", 2020);
//        Veiculo v5 = new Veiculo("Hyundai HB20", "MNO-5555", 2019);
//        Veiculo v6 = new Veiculo("Toyota Corolla", "PQR-6666", 2021);
//
//        // Associa os veículos a alguns dos clientes criados anteriormente
//        sistemaOficina.getGestaoVeiculos().adicionarVeiculo(c1.getIdCliente(), v1); // Veículo da Ana
//        sistemaOficina.getGestaoVeiculos().adicionarVeiculo(c2.getIdCliente(), v2); // Veículo do Bruno
//        sistemaOficina.getGestaoVeiculos().adicionarVeiculo(c2.getIdCliente(), v3); // Segundo veículo do Bruno
//        sistemaOficina.getGestaoVeiculos().adicionarVeiculo(c3.getIdCliente(), v4); // Veículo do Carlos
//        sistemaOficina.getGestaoVeiculos().adicionarVeiculo(c5.getIdCliente(), v5); // Veículo do Eduardo
//        sistemaOficina.getGestaoVeiculos().adicionarVeiculo(c7.getIdCliente(), v6); // Veículo do Gustavo
//        
//        sistemaOficina.getGestaoVeiculos().salvar();
//        
//        System.out.println("\n4. Agendando Servicos");
//        Agendamento ag1 = new Agendamento(v1.getPlaca(), c1.getIdCliente(), "Troca de óleo", 2, LocalDateTime.of(2025, 7, 10, 9, 20));
//        Agendamento ag2 = new Agendamento(v2.getPlaca(), c2.getIdCliente(), "Troca de óleo", 3, LocalDateTime.of(2025, 7, 10, 14, 20));
//        Agendamento ag3 = new Agendamento(v3.getPlaca(), c2.getIdCliente(), "Alinhamento", 1, LocalDateTime.of(2025, 7, 10, 8, 20));
//        Agendamento ag4 = new Agendamento(v4.getPlaca(), c3.getIdCliente(), "Alinhamento", 1, LocalDateTime.of(2025, 7, 10, 10, 20));
//        Agendamento ag5 = new Agendamento(v5.getPlaca(), c5.getIdCliente(), "Troca de óleo", 2, LocalDateTime.of(2025, 7, 10, 15, 20));
//        Agendamento ag6 = new Agendamento(v6.getPlaca(), c6.getIdCliente(), "Troca de óleo", 3, LocalDateTime.of(2025, 7, 10, 16, 20));
//
//        // Adiciona os agendamentos ao sistema
//        sistemaOficina.getAgenda().agendar(ag1);
//        sistemaOficina.getAgenda().agendar(ag2);
//        sistemaOficina.getAgenda().agendar(ag3);
//        sistemaOficina.getAgenda().agendar(ag4);
//        sistemaOficina.getAgenda().agendar(ag5);
//        sistemaOficina.getAgenda().agendar(ag6);
//        sistemaOficina.getAgenda().salvar();
//        
//        System.out.println("\n5. Criando mecanicos");
//        
//        Mecanico m1 = new Mecanico("Roberto Carlos", "roberto.c", "senha123", "Motor e Transmissão");
//        Mecanico m2 = new Mecanico("Ricardo Souza", "ricardo.s", "senha456", "Sistema Elétrico");
//        
//        System.out.println("\n6. Iniciando Servicos");
//        
//        OrdemDeServico os1 = sistemaOficina.getAgenda().IniciarServico(ag1.getIdAgendamento(), m1.getIdFuncionario());
//        OrdemDeServico os2 = sistemaOficina.getAgenda().IniciarServico(ag2.getIdAgendamento(), m1.getIdFuncionario());
//        OrdemDeServico os3 = sistemaOficina.getAgenda().IniciarServico(ag3.getIdAgendamento(), m2.getIdFuncionario());
//        OrdemDeServico os4 = sistemaOficina.getAgenda().IniciarServico(ag4.getIdAgendamento(), m2.getIdFuncionario());
//        OrdemDeServico os5 = sistemaOficina.getAgenda().IniciarServico(ag5.getIdAgendamento(), m2.getIdFuncionario());
//        OrdemDeServico os6 = sistemaOficina.getAgenda().IniciarServico(ag6.getIdAgendamento(), m1.getIdFuncionario());
//        
//        sistemaOficina.getGestaoOS().adicionarOS(os1);
//        sistemaOficina.getGestaoOS().adicionarOS(os2);
//        sistemaOficina.getGestaoOS().adicionarOS(os3);
//        sistemaOficina.getGestaoOS().adicionarOS(os4);
//        sistemaOficina.getGestaoOS().adicionarOS(os5);
//        sistemaOficina.getGestaoOS().adicionarOS(os6);
//        
//        sistemaOficina.getGestaoOS().adicionarServico(os1.getIdOS(), Servicos.TROCA_DE_OLEO);
//        sistemaOficina.getGestaoOS().adicionarServico(os2.getIdOS(), Servicos.TROCA_DE_OLEO);
//        sistemaOficina.getGestaoOS().adicionarServico(os3.getIdOS(), Servicos.ALINHAMENTO);
//        sistemaOficina.getGestaoOS().adicionarServico(os4.getIdOS(), Servicos.ALINHAMENTO);
//        sistemaOficina.getGestaoOS().adicionarServico(os5.getIdOS(), Servicos.TROCA_DE_OLEO);
//        sistemaOficina.getGestaoOS().adicionarServico(os6.getIdOS(), Servicos.TROCA_DE_OLEO);
//        
//        sistemaOficina.getGestaoOS().adicionarPeca(os1.getIdOS(), p1.getIdPeca(), 1);
//        sistemaOficina.getGestaoOS().adicionarPeca(os2.getIdOS(), p1.getIdPeca(), 1);
//        sistemaOficina.getGestaoOS().adicionarPeca(os4.getIdOS(), p1.getIdPeca(), 1);
//        sistemaOficina.getGestaoOS().adicionarPeca(os6.getIdOS(), p1.getIdPeca(), 1);
//        
//        System.out.println("\n7. Finalizando Servicos");
//        sistemaOficina.getGestaoOS().finalizarEGerarNota(os1.getIdOS());
//        sistemaOficina.getGestaoOS().finalizarEGerarNota(os2.getIdOS());
//        sistemaOficina.getGestaoOS().finalizarEGerarNota(os3.getIdOS());
//        sistemaOficina.getGestaoOS().finalizarEGerarNota(os4.getIdOS());
//        sistemaOficina.getGestaoOS().finalizarEGerarNota(os5.getIdOS());
//        sistemaOficina.getGestaoOS().finalizarEGerarNota(os6.getIdOS());
//
//        
//        System.out.println("\n8. Venda direta");
//        Map<Integer, Integer> pecas1 = new HashMap<>();
//        pecas1.put(p2.getIdPeca(), 1);
//        Map<Integer, Integer> pecas2 = new HashMap<>();
//        pecas2.put(p3.getIdPeca(), 1);
//        Map<Integer, Integer> pecas3 = new HashMap<>();
//        pecas3.put(p3.getIdPeca(), 4);
//        Map<Integer, Integer> pecas4 = new HashMap<>();
//        pecas4.put(p3.getIdPeca(), 2);
//        
//        sistemaOficina.getGestaoOS().registrarVendaDireta(c7.getIdCliente(), pecas1);
//        sistemaOficina.getGestaoOS().registrarVendaDireta(c8.getIdCliente(), pecas2);
//        sistemaOficina.getGestaoOS().registrarVendaDireta(c9.getIdCliente(), pecas3);
//        sistemaOficina.getGestaoOS().registrarVendaDireta(c10.getIdCliente(), pecas4);
//        
//        Gerente g = new Gerente("Davi", "davi", "1234", 4000);
//        
//        sistemaOficina.login("davi", "1234");
//        
//        sistemaOficina.getGestaoFinanceira().gerarBalancoMes(Month.JUNE, 2025, sistemaOficina.getFuncionarioLogado());
    }
}
