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
import Dominio.ComparaClientePorId;
import Dominio.ComparaClientePorNome;
import Dominio.Fornecedor;
import Dominio.Lancamento;
import Dominio.NotaFiscal;
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
        
        //----------------------------------------
//        Estoque estoque = Estoque.carregarDoArquivo();

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
        //-----------------------------------------------------
//        System.out.println("\nEstoque após alterações:");
//        estoque.imprimirEstoque();
//        
//        Elevador elevador1 = new Elevador(1, "balanceamento");
//        System.out.println("Elevador: " + elevador1);
//        
//        
//        
//        // Criando instâncias de gerenciamento
//        GestaoClientes gestaoClientes = new GestaoClientes();
//        GestaoDeVeiculos gestaoVeiculos = GestaoDeVeiculos.carregarDoArquivo();
//
//        // Criando clientes
//        Cliente cliente1 = new Cliente("João", "Rua A", "123456789", "joao@email.com", 123456789);
//        Cliente cliente2 = new Cliente("Maria", "Rua B", "987654321", "maria@email.com", 987654321);
//        gestaoClientes.adicionaCliente(cliente1);
//        gestaoClientes.adicionaCliente(cliente2);
//
//        System.out.println("Clientes adicionados:");
//        for (Cliente c : gestaoClientes.getClientes()) {
//            System.out.println(c);
//        }
//
//        // Criando veículos
//        Veiculo veiculo1 = new Veiculo("Fiat Uno", "ABC1234", 2010);
//        Veiculo veiculo2 = new Veiculo("Ford Ka", "XYZ9876", 2015);
//        Veiculo veiculo3 = new Veiculo("Chevrolet Onix", "DEF5678", 2020);
//
//        // Associando veículos aos clientes
//        gestaoVeiculos.adicionarVeiculo(cliente1.getIdCliente(), veiculo1);
//        gestaoVeiculos.adicionarVeiculo(cliente1.getIdCliente(), veiculo2);
//        gestaoVeiculos.adicionarVeiculo(cliente2.getIdCliente(), veiculo3);
//
//        // Buscar veículo por placa
//        System.out.println("\nBuscar veículo com placa ABC1234:");
//        System.out.println(gestaoVeiculos.buscarVeiculoPorPlaca("ABC1234"));
//
//        // Buscar veículos de um cliente
//        System.out.println("\nVeículos do cliente João:");
//        ArrayList<Veiculo> veiculosJoao = gestaoVeiculos.buscarVeiculosDoProprietario(cliente1.getIdCliente());
//        for (Veiculo v : veiculosJoao) {
//            System.out.println(v);
//        }
//
//        // Editar dados
//        gestaoClientes.editarEmail(cliente1.getIdCliente(), "joao_novo@email.com");
//        gestaoVeiculos.editarModelo("XYZ9876", "Ford Fiesta");
//        gestaoVeiculos.editarAno("XYZ9876", 2017);
//
//        System.out.println("\nDados atualizados:");
//        System.out.println("Cliente João: " + gestaoClientes.buscarCliente(cliente1.getIdCliente()));
//        System.out.println("Veículo atualizado: " + gestaoVeiculos.buscarVeiculoPorPlaca("XYZ9876"));
//
//        // Remover veículo
//        gestaoVeiculos.removerVeiculo("DEF5678");
//        System.out.println("\nVeículos de Maria após remoção:");
//        ArrayList<Veiculo> veiculosMaria = gestaoVeiculos.buscarVeiculosDoProprietario(cliente2.getIdCliente());
//        for (Veiculo v : veiculosMaria) {
//            System.out.println(v);
//        }
//
//        // Remover cliente
//        gestaoClientes.removerCliente(cliente1.getIdCliente());
//        System.out.println("\nClientes após remoção de João:");
//        for (Cliente c : gestaoClientes.getClientes()) {
//            System.out.println(c);
//        }
//        
//        Veiculo veiculo4 = new Veiculo("Chevrolet Onix", "DEF5678", 2020);
//        
//        System.out.println(gestaoVeiculos.toString());
//        gestaoVeiculos.salvar();
//        
//        System.out.println(Cliente.getContadorDeVeiculos());
       


//        Gerente gerente = new Gerente("Sérgio", "sergio.g", "123");
//        Mecanico mecanico = new Mecanico("Roberto", "roberto.m", "456", "Motor");
//
//        //Criando a Ordem de Serviço
//        OrdemDeServico os = new OrdemDeServico();
//        os.setDescricao("Revisão completa do motor");
//        
//        //Registrando o Gerente e o Mecânico como observadores
//        System.out.println("Registrando Gerente e Mecânico como observadores desta OS");
//        os.adicionarObserver(gerente);
//        os.adicionarObserver(mecanico);
//        
//        System.out.println("\n======================================================\n");
//
//        // Ambos, Gerente e Mecânico, serão notificados
//        System.out.println("Trocando o status da OS");
//        os.setStatusOS(StatusOS.EM_MANUTENCAO);
//        
//        // Finalizando o serviço
//        os.setStatusOS(StatusOS.PRONTO_PARA_ENTREGA);
//        
//        System.out.println("\n======================================================\n");
//        
//        //Criado classe Recepcionista e instânciado um objeto
//        Recepcionista recepcionista1 = new Recepcionista("João", "joão", "789");
//        
//        //Criado outro mecânico
//        Mecanico mecanico2 = new Mecanico("Maria", "maria", "321", "Suspensão");
//        
//        //Novas Ordens de serviço
//        OrdemDeServico os2 = new OrdemDeServico();
//        os2.setDescricao("Alinhamento");
//        OrdemDeServico os3 = new OrdemDeServico();
//        os3.setDescricao("Revisão da suspensão");
//        
//        //Adicionado observadores para OS2
//        System.out.println("Registrando Gerente, Mecânico e Recepcionista como observadores da OS2");
//        os2.adicionarObserver(gerente);
//        os2.adicionarObserver(mecanico);
//        os2.adicionarObserver(recepcionista1);
//        
//        //Adicionado observadores para OS3
//        System.out.println("Registrando Mecânico2 e Recepcionista como observadores da OS3");
//        os3.adicionarObserver(mecanico2);
//        os3.adicionarObserver(recepcionista1);
//        
//        System.out.println("\n======================================================\n");
//        
//        //Trocas de Status
//        System.out.println("Trocando o status da OS2");
//        os2.setStatusOS(StatusOS.RECEBIDO);
//        System.out.println("\n======================================================\n");
//        System.out.println("Trocando o status da OS3");
//        os3.setStatusOS(StatusOS.EM_MANUTENCAO);
//        System.out.println("\n======================================================\n");
//        
//        System.out.println("Trocando o status da OS2 e OS3");
//        os2.setStatusOS(StatusOS.PRONTO_PARA_ENTREGA);
//        os3.setStatusOS(StatusOS.PRONTO_PARA_ENTREGA);
//        
//        System.out.println("\n======================================================\n");
        
        
        // Criar o estoque e fornecedores simulados
//        Estoque estoque = new Estoque();
//        Fornecedor fornecedor1 = new Fornecedor("AutoParts");
//        Fornecedor fornecedor2 = new Fornecedor("MegaPeças");
//
//        // Criar o mapa de fornecedores
//        Map<Integer, Fornecedor> fornecedores = new HashMap<>();
//        fornecedores.put(fornecedor1.getIdFornecedor(), fornecedor1);
//        fornecedores.put(fornecedor2.getIdFornecedor(), fornecedor2);
//
//        // Criar peças
//        Peca peca1 = new Peca("Pastilha de Freio", 120.0); // preço de venda
//        Peca peca2 = new Peca("Filtro de Óleo", 50.0);
//
//        // Adicionar lotes
//        System.out.println("== ADICIONANDO LOTE DE PASTILHA ==");
//        estoque.adicionarLote(peca1, 10, fornecedor1.getIdFornecedor(), 90.0); // custo
//
//        System.out.println("== ADICIONANDO OUTRO LOTE DE PASTILHA ==");
//        estoque.adicionarLote(peca1, 5, fornecedor2.getIdFornecedor(), 85.0);
//
//        System.out.println("== ADICIONANDO LOTE DE FILTRO ==");
//        estoque.adicionarLote(peca2, 20, fornecedor1.getIdFornecedor(), 30.0);
//
//        // Editar nome e preço
//        estoque.editarNome(peca2.getIdPeca(), "Filtro de Óleo Premium");
//        estoque.editarPreco(peca1.getIdPeca(), 130.0);
//
//        // Remover peças
//        System.out.println("== REMOVENDO 3 UNIDADES DE PASTILHA ==");
//        estoque.removerPeca(peca1.getIdPeca(), 3);
//
//        System.out.println("== REMOVENDO 20 UNIDADES DE FILTRO (TOTAL) ==");
//        estoque.removerPeca(peca2.getIdPeca(), 20);
//
//        // Verificar quantidade
//        boolean temEstoque = estoque.quantidadeSuficiente(peca1.getIdPeca(), 5);
//        System.out.println("Ainda tem 5 pastilhas no estoque? " + temEstoque);
//
//        // Impressão final
//        System.out.println("\n== ESTOQUE ATUAL ==");
//        estoque.imprimirEstoque(fornecedores);
        
//        // 1. Carregar estoque
//        Estoque estoque = Estoque.carregarDoArquivo();
//
//        // 2. Criar instância de gestão de OS
//        GestaoDeOrdemDeServico gestao = GestaoDeOrdemDeServico.carregarDoArquivo(estoque);
//
//        // 3. Criar peça e adicionar ao estoque
//        Peca p1 = new Peca("Filtro de óleo", 100.0); // preco = preço de venda
//        estoque.adicionarLote(p1, 5, 10, 50.0); // preço unitário de custo = 50 → preço de custo final = 60
//
//        // 4. Criar serviço
//        Servicos servico1 = Servicos.TROCA_DE_OLEO;
//
//        // 5. Criar ordem de serviço
//        OrdemDeServico os = new OrdemDeServico(
//            1, // idVeiculo
//            1, // idCliente
//            "Revisão geral",
//            1, // idElevador
//            LocalDateTime.now(),
//            1001, // idMecânico
//            StatusOS.EM_MANUTENCAO
//        );
//
//        // 6. Adicionar serviços e peças
//        os.adicionarPeca(p1.getIdPeca(), 2);
//        os.getServicosRealizados().add(servico1);
//
//        // 7. Adicionar OS à gestão
//        gestao.adicionarOS(os);
//
//        // 8. Gerar nota fiscal (vai imprimir)
//        gestao.gerarNotaFiscal(os.getIdOS());
//
//        // 9. Salvar os dados em JSON
//        estoque.salvarNoArquivo();
//        gestao.salvarNoArquivo();
//
//        System.out.println("\n✅ Teste concluído e arquivos JSON salvos.");
        

//-------------------------------------------------------------------------------------------------
//Teste 1 Funcionarios

//        // Apaga o arquivo antigo para garantir um teste limpo
//        new File("funcionarios.json").delete();
//        
//        System.out.println("### INICIANDO TESTE DO MÓDULO DE FUNCIONÁRIOS ###");
//        
//        // Carrega a gestão, que estará vazia na primeira vez
//        FuncionarioService gestao = FuncionarioService.carregarDoArquivo();
//        
//        System.out.println("\n--- ESTADO INICIAL ---");
//        gestao.imprimirFuncionarios(gestao);
//
//        System.out.println("\n--- 1. ADICIONANDO NOVOS FUNCIONÁRIOS (EM MEMÓRIA) ---");
//        Gerente gerente = new Gerente("Ana", "ana.g", "gerente456"); // ID esperado: 1
//        Mecanico mecanico = new Mecanico("Bruno", "bruno.m", "mecanico789", "Motor"); // ID esperado: 2
//        
//        gestao.adicionarFuncionario(gerente);
//        gestao.adicionarFuncionario(mecanico);
//        
//        System.out.println("\n--- ESTADO APÓS ADIÇÃO (ANTES DE SALVAR) ---");
//        gestao.imprimirFuncionarios(gestao);
//        
//        // Salva manualmente
//        System.out.println("\n--- 2. SALVANDO DADOS NO ARQUIVO... ---");
//        gestao.salvarFuncionarios();
//        
//        System.out.println("\n--- 3. EDITANDO E REMOVENDO (EM MEMÓRIA) ---");
//        gestao.editarNome(2, "Bruno Silva");
//        gestao.removerFuncionario(1);
//
//        System.out.println("\n--- ESTADO APÓS ALTERAÇÕES (ANTES DE SALVAR) ---");
//        gestao.imprimirFuncionarios(gestao);
//
//        // Salva as novas alterações
//        System.out.println("\n--- 4. SALVANDO ALTERAÇÕES NO ARQUIVO... ---");
//        gestao.salvarFuncionarios();
//
//        System.out.println("\n--- 5. TESTANDO PERSISTÊNCIA ---");
//        System.out.println("Carregando os dados do arquivo para uma NOVA instância de gestão...");
//        FuncionarioService novaGestao = FuncionarioService.carregarDoArquivo();
//        
//        System.out.println("\n--- DADOS CARREGADOS DO ARQUIVO ---");
//        novaGestao.imprimirFuncionarios(novaGestao);
//        
//        System.out.println("\n--- 6. VERIFICANDO CONTADOR DE ID ---");
//        System.out.println("Próximo ID a ser gerado: " + (Funcionario.getContadorId() + 1));
//        Funcionario novoMecanico = new Mecanico("Carlos", "carlos.m", "senha123", "Elétrica"); // ID esperado: 3
//        novaGestao.adicionarFuncionario(novoMecanico);
//        novaGestao.salvarFuncionarios();
//        
//        System.out.println("\n--- ESTADO FINAL APÓS ADICIONAR NOVO FUNCIONÁRIO ---");
//        novaGestao.imprimirFuncionarios(novaGestao);
        
        
        
 //-------------------------------------------------------------------------------------------------
//Teste 2 Cliente e veiculo       
        // Limpa os arquivos antigos para garantir um teste limpo do zero
//        new File("clientes.json").delete();
//        new File("veiculos.json").delete();
//        new File("contador_veiculos.json").delete();
//
//        System.out.println("### INICIANDO TESTE INTEGRADO DOS MÓDULOS CLIENTE E VEÍCULO ###");
//
//        // --- 1. Inicialização ---
//        GestaoClientes gestaoClientes = GestaoClientes.carregarDoArquivo();
//        GestaoDeVeiculos gestaoVeiculos = GestaoDeVeiculos.carregarDoArquivo();
//
//        // --- 2. Cadastrando Clientes ---
//        System.out.println("\n--- CADASTRANDO CLIENTES ---");
//        Cliente cliente1 = new Cliente("João Silva", "Rua A", "111", "joao@email.com", 111222333L);
//        Cliente cliente2 = new Cliente("Maria Souza", "Rua B", "222", "maria@email.com", 444555666L);
//        gestaoClientes.adicionaCliente(cliente1);
//        gestaoClientes.adicionaCliente(cliente2);
//        gestaoClientes.salvar(); // Salvamento manual
//
//        // --- 3. Cadastrando Veículos ---
//        System.out.println("\n--- CADASTRANDO VEÍCULOS ---");
//        Veiculo veiculo1 = new Veiculo("Fiat Uno", "ABC-1234", 2010);
//        Veiculo veiculo2 = new Veiculo("Chevrolet Onix", "DEF-5678", 2018);
//        Veiculo veiculo3 = new Veiculo("Ford Ka", "GHI-9012", 2020);
//        
//        gestaoVeiculos.adicionarVeiculo(cliente1.getIdCliente(), veiculo1);
//        gestaoVeiculos.adicionarVeiculo(cliente2.getIdCliente(), veiculo2);
//        gestaoVeiculos.adicionarVeiculo(cliente2.getIdCliente(), veiculo3);
//        gestaoVeiculos.salvar(); // Salvamento manual
//
//        // --- 4. Verificando Contadores (Questão 2) ---
//        System.out.println("\n--- VERIFICANDO CONTADORES ---");
//        System.out.println("Total de clientes cadastrados: " + Cliente.getContadorClientes());
//        System.out.println("Total de veículos (private): " + Cliente.getContadorDeVeiculos());
//        System.out.println("Total de veículos (protected): " + Cliente.getContadorDeVeiculosProtected());
//        
//        // --- 5. Testando a busca ---
//        System.out.println("\n--- BUSCANDO VEÍCULOS DA CLIENTE MARIA (ID: 2) ---");
//        ArrayList<Veiculo> veiculosDaMaria = gestaoVeiculos.buscarVeiculosDoProprietario(2);
//        veiculosDaMaria.forEach(System.out::println);
//        
//        // --- 6. Testando persistência ---
//        System.out.println("\n--- TESTANDO PERSISTÊNCIA ---");
//        System.out.println("Carregando dados em NOVAS instâncias de gestão...");
//        GestaoClientes novaGestaoClientes = GestaoClientes.carregarDoArquivo();
//        GestaoDeVeiculos novaGestaoVeiculos = GestaoDeVeiculos.carregarDoArquivo();
//
//        System.out.println("\nClientes carregados:");
//        novaGestaoClientes.getClientes().forEach(System.out::println);
//        
//        System.out.println("\nVeículos da Cliente Maria (ID: 2) carregados:");
//        novaGestaoVeiculos.buscarVeiculosDoProprietario(2).forEach(System.out::println);
//        
//        System.out.println("\nContador de veículos (private) após recarregar: " + Cliente.getContadorDeVeiculos());
//        System.out.println("Contador de veículos (protected) após recarregar: " + Cliente.getContadorDeVeiculosProtected());

//-------------------------------------------------------------------------------------------------
//Teste 3 Estoque 

//        new File("estoque.json").delete();
//        new File("financeiro.json").delete();
//        
//        System.out.println("### INICIANDO TESTE INTEGRADO DOS MÓDULOS DE ESTOQUE E FINANCEIRO ###");
//
//        // --- 1. Inicialização ---
//        GestaoFinanceira gestaoFinanceira = new GestaoFinanceira();
//        Estoque estoque = Estoque.carregarDoArquivo(gestaoFinanceira);
//        
//        System.out.println("\n--- ESTADO INICIAL ---");
//        gestaoFinanceira.gerarBalancoMes(Month.JUNE, 2025);
//
//        // --- 2. Adicionando Lote de Peças (o salvamento é automático) ---
//        System.out.println("\n--- ADICIONANDO UM LOTE DE PEÇAS ---");
//        Peca filtroOleo = new Peca("Filtro de Óleo Bosch", 55.00);
//        Fornecedor fornecedorA = new Fornecedor("Autopeças Milho Verde");
//
//        estoque.adicionarLote(filtroOleo, 10, fornecedorA.getIdFornecedor(), 30.00);
//        
//        System.out.println("\n--- VERIFICANDO O BALANÇO FINANCEIRO APÓS A COMPRA ---");
//        gestaoFinanceira.gerarBalancoMes(Month.JUNE, 2025);
//        
//        // --- 3. Testando a Persistência ---
//        System.out.println("\n--- TESTANDO PERSISTÊNCIA ---");
//        System.out.println("Carregando dados em NOVAS instâncias de gestão...");
//        
//        GestaoFinanceira novaGestaoFinanceira = GestaoFinanceira.carregarDoArquivo();
//        Estoque novoEstoque = Estoque.carregarDoArquivo(novaGestaoFinanceira);
//        
//        System.out.println("\n--- DADOS CARREGADOS DO ARQUIVO ---");
//        System.out.println("Quantidade de Filtro de Óleo carregada: " + novoEstoque.getQuantidadeTotal(filtroOleo.getIdPeca()));
//        
//        System.out.println("\n--- BALANÇO CARREGADO DO ARQUIVO ---");
//        novaGestaoFinanceira.gerarBalancoMes(Month.JUNE, 2025);
//        
//        System.out.println("\nTeste de integração concluído com sucesso.");
//    
    
//-------------------------------------------------------------------------------------------------
//Teste 4 Agenda
//        new File("agenda.json").delete();
//
//        System.out.println("### INICIANDO TESTE DO MÓDULO DE AGENDAMENTO ###");
//        Agenda agenda = Agenda.carregarDoArquivo();
//        
//        System.out.println("\n--- 1. REALIZANDO AGENDAMENTOS ---");
//        Agendamento ag1 = new Agendamento(101, 1, "Barulho no motor", new ArrayList<>(), 1, LocalDateTime.of(2025, 7, 10, 9, 0), 200.0);
//        Agendamento ag2 = new Agendamento(102, 2, "Troca de óleo", new ArrayList<>(), 2, LocalDateTime.of(2025, 7, 10, 9, 0), 150.0);
//        Agendamento ag3_conflito = new Agendamento(103, 3, "Pneu furado", new ArrayList<>(), 1, LocalDateTime.of(2025, 7, 10, 9, 0), 50.0);
//
//        System.out.println("Agendando serviço 1: " + agenda.agendar(ag1));
//        System.out.println("Agendando serviço 2: " + agenda.agendar(ag2));
//        System.out.println("Tentando agendar serviço conflitante: " + agenda.agendar(ag3_conflito));
//        
//        System.out.println("\n--- AGENDA APÓS AGENDAMENTOS ---");
//        agenda.imprimirAgenda();
//        agenda.salvar();
//
//        System.out.println("\n--- 2. CANCELANDO UM AGENDAMENTO ---");
//        agenda.cancelarAgendamento(2); // Cancelando o agendamento de ID 2
//        System.out.println("\n--- AGENDA APÓS CANCELAMENTO ---");
//        agenda.imprimirAgenda();
//        agenda.salvar();
//        
//        System.out.println("\n--- 3. INICIANDO UM SERVIÇO ---");
//        OrdemDeServico os = agenda.IniciarServico(1, 5); // Iniciando o agendamento de ID 1 com o mecânico ID 5
//        
//        if (os != null) {
//            System.out.println("Ordem de Serviço criada com sucesso: " + os);
//        }
//        
//        System.out.println("\n--- AGENDA APÓS INICIAR SERVIÇO ---");
//        agenda.imprimirAgenda();
//        agenda.salvar();
//        
//        System.out.println("\n--- 4. TESTANDO PERSISTÊNCIA ---");
//        Agenda novaAgenda = Agenda.carregarDoArquivo();
//        System.out.println("\n--- AGENDA CARREGADA DO ARQUIVO ---");
//        novaAgenda.imprimirAgenda();
//        
//-------------------------------------------------------------------------------------------------
//Teste 4 Agenda
        
//        // Limpando arquivos para um teste limpo
//        new File("ordens_de_servico.json").delete();
//        new File("estoque.json").delete();
//        new File("financeiro.json").delete();
//        new File("fornecedores.json").delete();
//        new File("clientes.json").delete();
//
//        System.out.println("### INICIANDO TESTE DO MÓDULO DE ORDEM DE SERVIÇO ###");
//
//        // 1. Inicializa todos os sistemas de gestão
//        GestaoClientes gestaoClientes = new GestaoClientes();
//        GestaoFinanceira gestaoFinanceira = new GestaoFinanceira();
//        Estoque estoque = new Estoque(gestaoFinanceira);
//        GestaoDeOrdemDeServico gestaoOS = new GestaoDeOrdemDeServico(estoque, gestaoFinanceira);
//        
//        // [CORREÇÃO] Cadastra clientes reais para o teste
//        System.out.println("\n--- Cadastrando clientes para o teste ---");
//        Cliente cliente1 = new Cliente("João Teste", "Rua X", "123", "joao@teste.com", 1L); // ID: 1
//        Cliente cliente2 = new Cliente("Maria Teste", "Rua Y", "456", "maria@teste.com", 2L); // ID: 2
//        gestaoClientes.adicionaCliente(cliente1);
//        gestaoClientes.adicionaCliente(cliente2);
//
//
//        // Prepara o estoque com algumas peças
//        Peca filtroOleo = new Peca("Filtro de Óleo", 50.0);
//        Peca vela = new Peca("Vela de Ignição", 25.0);
//        Fornecedor fornecedor = new Fornecedor("Autopeças Central");
//        
//        estoque.adicionarLote(filtroOleo, 10, fornecedor.getIdFornecedor(), 25.0);
//        estoque.adicionarLote(vela, 20, fornecedor.getIdFornecedor(), 12.0);
//        
//        // --- TESTE 1: FLUXO DE SERVIÇO NORMAL ---
//        System.out.println("\n--- 1. FLUXO DE SERVIÇO NORMAL ---");
//        OrdemDeServico osServico = gestaoOS.iniciarOSdeServico(cliente1.getIdCliente(), "ABC-1234", "Revisão geral e troca de óleo");
//        System.out.println("OS de Serviço Criada: " + osServico);
//
//        System.out.println("\nAdicionando itens à OS de Serviço...");
//        gestaoOS.adicionarServico(osServico.getIdOS(), Servicos.TROCA_DE_OLEO);
//        gestaoOS.adicionarPeca(osServico.getIdOS(), filtroOleo.getIdPeca(), 1); 
//        
//        System.out.println("\nFinalizando OS de Serviço...");
//        gestaoOS.finalizarEGerarNota(osServico.getIdOS());
//
//        // --- TESTE 2: FLUXO DE VENDA DIRETA ---
//        System.out.println("\n--- 2. FLUXO DE VENDA DIRETA ---");
//        Map<Integer, Integer> pecasParaVenda = new HashMap<>();
//        pecasParaVenda.put(vela.getIdPeca(), 4);
//        
//        gestaoOS.registrarVendaDireta(cliente2.getIdCliente(), pecasParaVenda);
//
//        // --- 3. VERIFICANDO O ESTADO FINAL ---
//        System.out.println("\n--- 3. ESTADO FINAL DO SISTEMA ---");
//        System.out.println("Verificando OSs do Cliente 1:");
//        gestaoOS.imprimirOSDoCliente(cliente1.getIdCliente());
//        
//        System.out.println("\nVerificando OSs do Cliente 2:");
//        gestaoOS.imprimirOSDoCliente(cliente2.getIdCliente());
//
//        System.out.println("\nVerificando Balanço Financeiro Final:");
//        gestaoFinanceira.gerarBalancoMes(Month.JUNE, 2025);

//-------------------------------------------------------------------------------------------------
//Teste 5 Financeiro
        
//        new File("financeiro.json").delete();
//
//        System.out.println("### INICIANDO TESTE DO MÓDULO FINANCEIRO ###");
//
//        GestaoFinanceira gestao = GestaoFinanceira.carregarDoArquivo();
//        
//        System.out.println("\n--- ESTADO INICIAL ---");
//        gestao.gerarBalancoMes(Month.JUNE, 2025);
//
//        // --- 1. Adiciona Lançamentos de Despesa e Receita ---
//        System.out.println("\n--- REGISTRANDO LANÇAMENTOS ---");
//        
//        // Simula uma receita de um serviço finalizado
//        NotaFiscal nota1 = new NotaFiscal(1, 101);
//        nota1.adicionarItem("Troca de Óleo", 1, 150.0);
//        gestao.adicionarLancamento(new Lancamento(
//            "Receita da OS #1", nota1.getTotal(), LocalDate.of(2025, 6, 10), TipoLancamento.Receita, null
//        ));
//        gestao.adicionarNotaFiscal(nota1); // Salva a nota fiscal
//        gestao.salvar();
//        
//        // Simula despesas manuais
//        gestao.adicionarLancamento(new Lancamento(
//            "Pagamento Salário", 3500.0, LocalDate.of(2025, 6, 5), TipoLancamento.Despesa, CategoriaDespesa.Salario
//        ));
//        gestao.adicionarLancamento(new Lancamento(
//            "Material de Limpeza", 80.50, LocalDate.of(2025, 6, 15), TipoLancamento.Despesa, CategoriaDespesa.Uso
//        ));
//        gestao.salvar();
//        
//        // --- 2. Gera o Balanço do Mês ---
//        System.out.println("\n--- GERANDO BALANÇO DE JUNHO/2025 ---");
//        gestao.gerarBalancoMes(Month.JUNE, 2025);
//        
//        // --- 3. Testa a Persistência ---
//        System.out.println("\n--- TESTANDO PERSISTÊNCIA ---");
//        System.out.println("Carregando dados em uma NOVA instância de gestão...");
//        GestaoFinanceira novaGestao = GestaoFinanceira.carregarDoArquivo();
//
//        System.out.println("\n--- BALANÇO CARREGADO DO ARQUIVO ---");
//        novaGestao.gerarBalancoMes(Month.JUNE, 2025);
//        
//        System.out.println("\n--- NOTAS FISCAIS CARREGADAS ---");
//        if (novaGestao.getNotasFiscais().isEmpty()) {
//            System.out.println("Nenhuma nota fiscal encontrada.");
//        } else {
//            for (NotaFiscal nota : novaGestao.getNotasFiscais()) {
//                System.out.println(nota);
//            }
//        }
//        
//        System.out.println("\nTeste do módulo financeiro concluído com sucesso.");

//-------------------------------------------------------------------------------------------------
//Teste 6 Elevador

//        System.out.println("### INICIANDO TESTE DO MÓDULO DE ELEVADORES ###");
//
//        // 1. Imprime o status inicial dos elevadores
//        System.out.println("\n--- ESTADO INICIAL ---");
//        SistemaOficina.imprimirStatusElevadores();
//
//        // 2. Ocupa um dos elevadores
//        System.out.println("\n--- OCUPANDO O ELEVADOR 2 ---");
//        Elevador elevador2 = SistemaOficina.buscarElevadorPorId(2);
//        if (elevador2 != null) {
//            elevador2.setOcupado(true);
//            System.out.println("Elevador 2 foi ocupado.");
//        }
//
//        // 3. Imprime o novo status
//        System.out.println("\n--- NOVO ESTADO ---");
//        SistemaOficina.imprimirStatusElevadores();
//
//        // 4. Libera o elevador
//        System.out.println("\n--- LIBERANDO O ELEVADOR 2 ---");
//        if (elevador2 != null) {
//            elevador2.setOcupado(false);
//            System.out.println("Elevador 2 foi liberado.");
//        }
//
//        // 5. Imprime o estado final
//        System.out.println("\n--- ESTADO FINAL ---");
//        SistemaOficina.imprimirStatusElevadores();
//        
//        System.out.println("\nTeste do módulo de Elevadores concluído com sucesso.");
        
//-------------------------------------------------------------------------------------------------
//Teste 6 Teste todos juntos     
        
//        System.out.println("### INICIANDO TESTE DE INTEGRAÇÃO DO SISTEMA COMPLETO ###");
//
//        // --- 1. INICIALIZAÇÃO DE TODOS OS SISTEMAS DE GESTÃO ---
//        System.out.println("\n--- 1. Inicializando sistemas de gestão ---");
//        GestaoClientes gestaoClientes = new GestaoClientes();
//        GestaoDeVeiculos gestaoVeiculos = new GestaoDeVeiculos();
//        FuncionarioService gestaoFuncionarios = new FuncionarioService();
//        GestaoFinanceira gestaoFinanceira = new GestaoFinanceira();
//        Estoque estoque = new Estoque(gestaoFinanceira);
//        Agenda agenda = new Agenda();
//        GestaoDeOrdemDeServico gestaoOS = new GestaoDeOrdemDeServico(estoque, gestaoFinanceira);
//
//        // --- 2. POPULANDO DADOS INICIAIS ---
//        System.out.println("\n--- 2. Populando dados iniciais (Funcionários, Fornecedores, Estoque) ---");
//        Gerente gerente = new Gerente("Sérgio (Gerente)", "admin", "123");
//        Mecanico mecanico1 = new Mecanico("Carlos", "carlos", "123", "Motor");
//        gestaoFuncionarios.adicionarFuncionario(gerente);
//        gestaoFuncionarios.adicionarFuncionario(mecanico1);
//        
//        Fornecedor fornecedor = new Fornecedor("Autopeças Central");
//        Peca filtroOleo = new Peca("Filtro de Óleo", 50.0);
//        estoque.adicionarLote(filtroOleo, 20, fornecedor.getIdFornecedor(), 25.0);
//
//        // --- 3. FLUXO DE ATENDIMENTO DO CLIENTE ---
//        System.out.println("\n--- 3. Simulando fluxo de atendimento completo ---");
//        
//        // a. Cliente chega e é cadastrado
//        Cliente cliente = new Cliente("Ana", "Rua das Amélias", "9999-8888", "ana@email.com", 12345L);
//        gestaoClientes.adicionaCliente(cliente);
//        Veiculo veiculo = new Veiculo("Toyota Corolla", "XYZ-7890", 2021);
//        gestaoVeiculos.adicionarVeiculo(cliente.getIdCliente(), veiculo);
//        System.out.println("Cliente e Veículo cadastrados.");
//
//        // b. Agendamento do serviço
//        SistemaOficina.imprimirStatusElevadores();
//        Elevador elevadorDisponivel = SistemaOficina.buscarElevadorDisponivel(TipoElevador.GERAL);
//        if (elevadorDisponivel == null) {
//            System.out.println("Nenhum elevador disponível para agendamento.");
//            return;
//        }
//        System.out.println("Elevador " + elevadorDisponivel.getId() + " está disponível. Agendando...");
//        Agendamento agendamento = new Agendamento(cliente.getIdCliente(), "Barulho estranho no motor.", elevadorDisponivel.getId(), LocalDateTime.now().plusHours(1));
//        agenda.agendar(agendamento);
//        
//        // c. Início do serviço e criação da OS
//        elevadorDisponivel.setOcupado(true);
//        OrdemDeServico os = gestaoOS.iniciarOSdeServico(cliente.getIdCliente(), veiculo.getPlaca(), agendamento.getDescricao());
//        os.setIdMecanico(mecanico1.getIdFuncionario()); // Associa o mecânico
//        agendamento.setStatus(StatusAgendamento.EmManutencao);
//        System.out.println("Serviço iniciado na OS #" + os.getIdOS());
//        SistemaOficina.imprimirStatusElevadores();
//
//        // d. Execução do serviço (adicionar peças e serviços)
//        gestaoOS.adicionarServico(os.getIdOS(), Servicos.TROCA_DE_OLEO);
//        gestaoOS.adicionarPeca(os.getIdOS(), filtroOleo.getIdPeca(), 1);
//        System.out.println("Serviços e peças adicionados à OS.");
//
//        // e. Finalização do serviço
//        NotaFiscal nota = gestaoOS.finalizarEGerarNota(os.getIdOS());
//        elevadorDisponivel.setOcupado(false); // Libera o elevador
//        System.out.println("Serviço finalizado e nota fiscal gerada.");
//        nota.imprimir();
//        
//        // --- 4. LANÇANDO DESPESA MANUAL E GERANDO BALANÇO ---
//        System.out.println("\n--- 4. Lançando despesa e gerando balanço final ---");
//        gestaoFinanceira.adicionarLancamento(new Lancamento("Café para a equipe", 50.0, LocalDate.now(), TipoLancamento.Despesa, CategoriaDespesa.Uso));
//        
//        gestaoFinanceira.gerarBalancoMes(Month.JUNE, 2025); // Assumindo data atual
//
//        System.out.println("\n### TESTE DE INTEGRAÇÃO CONCLUÍDO ###");


//        // Instanciar o sistema
//        SistemaOficina sistema = new SistemaOficina();
//
//        // Criar manualmente um gerente fictício
//        Funcionario gerente = new Funcionario("Carlos Gerente", Cargo.Gerente, "carlos", "123", 7000.0);
//        sistema.getGestaoFuncionarios().adicionarFuncionario(gerente);
//        sistema.login("carlos", "123"); // Essa parte só vai funcionar se "carlos" já estiver no json
//        sistema.baterPonto();
//
//        // OU: Simular login direto se você quiser forçar para teste
//        // sistema.setFuncionarioLogado(gerente); (se você criar esse método)
//
//        // Criar serviço financeiro
//        GestaoFinanceira financeiro = GestaoFinanceira.carregarDoArquivo();
//
//        
//
//        // Gerar balanço
//        financeiro.gerarBalancoMes(Month.JUNE, 2025, sistema.getFuncionarioLogado());
//
//        // Encerrar
//        sistema.encerrarExpediente();
//        sistema.getGestaoFuncionarios().listarPontos(sistema.getFuncionarioLogado().getIdFuncionario());
//        sistema.getGestaoFuncionarios().salvarFuncionarios();
//        sistema.logout();
//        
//        Mecanico mecanico1 = new Mecanico("Marcos", "marcos", "12345", "Motor");
//        sistema.getGestaoFuncionarios().adicionarFuncionario(mecanico1);
//        sistema.getGestaoFuncionarios().salvarFuncionarios();
//        sistema.login("marcos", "12345");
//        
//        financeiro.gerarBalancoMes(Month.JUNE, 2025, sistema.getFuncionarioLogado());


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
//        
//        System.out.println("\n2. Setando o status do elevador 1 para ocupado");
//        Elevador e = SistemaOficina.buscarElevadorPorId(1);
//        e.setOcupado(true);
//        SistemaOficina.imprimirStatusElevadores();
//        
//        System.out.println("\n3. Voltando Status para Livre");
//        e.setOcupado(false);
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
//        sO.getGestaoOS().adicionarServico(1, Servicos.ALINHAMENTO);
//        sO.getGestaoOS().adicionarServico(2, Servicos.ALINHAMENTO);
//        Map<Integer, Integer> pecas = new HashMap<>();
//        pecas.put(1, 2);
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
//        sO.getEstoque().adicionarLote(p1, 30, 1, 40);
//        sO.getEstoque().adicionarLote(p2, 50, 1, 30);
//        sO.getEstoque().adicionarLote(p3, 10, 2, 55);
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
        System.out.println("Questão 10");
        System.out.println("--------------------------------------------");
        
        System.out.println("TESTE DA QUESTÃO 10");
        
        System.out.println("\n1. Cadastrando Ordem de serviço");
        SistemaOficina sO = new SistemaOficina();
        
        
        Peca p1 = new Peca("Filtro de óleo", 50);
        Peca p2 = new Peca("Vela", 45);
        Peca p3 = new Peca("Liquido de arrefecimento", 70);
        
        Fornecedor f1 = new Fornecedor("Autopecas 1");
        Fornecedor f2 = new Fornecedor("Autopecas 2");
        
        sO.getEstoque().adicionarLote(p1, 30, 1, 40);
        sO.getEstoque().adicionarLote(p2, 50, 1, 30);
        sO.getEstoque().adicionarLote(p3, 10, 2, 55);
        System.out.println(sO.getEstoque().toString());
        
        Map<Integer, Integer> pecas = new HashMap<>();
        pecas.put(1, 2);
        Map<Integer, Integer> pecas2 = new HashMap<>();
        pecas2.put(2, 4);
        pecas2.put(3, 1);
        
        sO.getGestaoOS().registrarVendaDireta(1, pecas);
        sO.getGestaoOS().registrarVendaDireta(3, pecas2);
        
        System.out.println("\n2. Criando novas instâncias de GestaoClientes, Estoque e GestaoDeOrdemDeServico");
        GestaoClientes gC = GestaoClientes.carregarDoArquivo();
        System.out.println(gC.toString());
        
        Estoque e = Estoque.carregarDoArquivo(sO.getGestaoFinanceira());
        System.out.println(e.toString());
        
        GestaoDeOrdemDeServico gOS = GestaoDeOrdemDeServico.carregarDoArquivo(e, sO.getGestaoFinanceira());
        System.out.println(gOS.toString());


        // Questão 15
//        System.out.println("Questão 15");
//        System.out.println("--------------------------------------------");
//        SistemaOficina sistemaOficina = new SistemaOficina();
//        //FuncionarioService gestao = new FuncionarioService();
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

    }
}
