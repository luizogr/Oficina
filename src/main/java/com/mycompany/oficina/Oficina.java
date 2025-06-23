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
import Dominio.Fornecedor;
import Dominio.Servicos;
import Servicos.GestaoDeOrdemDeServico;
import java.io.File;
import java.time.LocalDateTime;
import java.util.HashMap;
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
        new File("clientes.json").delete();
        new File("veiculos.json").delete();
        new File("contador_veiculos.json").delete();

        System.out.println("### INICIANDO TESTE INTEGRADO DOS MÓDULOS CLIENTE E VEÍCULO ###");

        // --- 1. Inicialização ---
        GestaoClientes gestaoClientes = GestaoClientes.carregarDoArquivo();
        GestaoDeVeiculos gestaoVeiculos = GestaoDeVeiculos.carregarDoArquivo();

        // --- 2. Cadastrando Clientes ---
        System.out.println("\n--- CADASTRANDO CLIENTES ---");
        Cliente cliente1 = new Cliente("João Silva", "Rua A", "111", "joao@email.com", 111222333L);
        Cliente cliente2 = new Cliente("Maria Souza", "Rua B", "222", "maria@email.com", 444555666L);
        gestaoClientes.adicionaCliente(cliente1);
        gestaoClientes.adicionaCliente(cliente2);
        gestaoClientes.salvar(); // Salvamento manual

        // --- 3. Cadastrando Veículos ---
        System.out.println("\n--- CADASTRANDO VEÍCULOS ---");
        Veiculo veiculo1 = new Veiculo("Fiat Uno", "ABC-1234", 2010);
        Veiculo veiculo2 = new Veiculo("Chevrolet Onix", "DEF-5678", 2018);
        Veiculo veiculo3 = new Veiculo("Ford Ka", "GHI-9012", 2020);
        
        gestaoVeiculos.adicionarVeiculo(cliente1.getIdCliente(), veiculo1);
        gestaoVeiculos.adicionarVeiculo(cliente2.getIdCliente(), veiculo2);
        gestaoVeiculos.adicionarVeiculo(cliente2.getIdCliente(), veiculo3);
        gestaoVeiculos.salvar(); // Salvamento manual

        // --- 4. Verificando Contadores (Questão 2) ---
        System.out.println("\n--- VERIFICANDO CONTADORES ---");
        System.out.println("Total de clientes cadastrados: " + Cliente.getContadorClientes());
        System.out.println("Total de veículos (private): " + Cliente.getContadorDeVeiculos());
        System.out.println("Total de veículos (protected): " + Cliente.getContadorDeVeiculosProtected());
        
        // --- 5. Testando a busca ---
        System.out.println("\n--- BUSCANDO VEÍCULOS DA CLIENTE MARIA (ID: 2) ---");
        ArrayList<Veiculo> veiculosDaMaria = gestaoVeiculos.buscarVeiculosDoProprietario(2);
        veiculosDaMaria.forEach(System.out::println);
        
        // --- 6. Testando persistência ---
        System.out.println("\n--- TESTANDO PERSISTÊNCIA ---");
        System.out.println("Carregando dados em NOVAS instâncias de gestão...");
        GestaoClientes novaGestaoClientes = GestaoClientes.carregarDoArquivo();
        GestaoDeVeiculos novaGestaoVeiculos = GestaoDeVeiculos.carregarDoArquivo();

        System.out.println("\nClientes carregados:");
        novaGestaoClientes.getClientes().forEach(System.out::println);
        
        System.out.println("\nVeículos da Cliente Maria (ID: 2) carregados:");
        novaGestaoVeiculos.buscarVeiculosDoProprietario(2).forEach(System.out::println);
        
        System.out.println("\nContador de veículos (private) após recarregar: " + Cliente.getContadorDeVeiculos());
        System.out.println("Contador de veículos (protected) após recarregar: " + Cliente.getContadorDeVeiculosProtected());
    }
}
