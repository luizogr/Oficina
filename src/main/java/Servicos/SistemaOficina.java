/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicos;

import Dominio.Elevador;
import Dominio.Estoque;
import Dominio.Funcionario;
import Dominio.TipoElevador;
import java.util.Scanner;

/**
 *
 * @author luizp
 */
public class SistemaOficina {
    private FuncionarioService gestaoFuncionarios = FuncionarioService.carregarDoArquivo();
    private GestaoClientes gestaoClientes = GestaoClientes.carregarDoArquivo();
    private Agenda agenda = Agenda.carregarDoArquivo();
    private GestaoDeVeiculos gestaoVeiculos = GestaoDeVeiculos.carregarDoArquivo();
    private GestaoFinanceira gestaoFinanceira = GestaoFinanceira.carregarDoArquivo();
    private Estoque estoque = Estoque.carregarDoArquivo(gestaoFinanceira);
    private GestaoDeOrdemDeServico gestaoOS = GestaoDeOrdemDeServico.carregarDoArquivo(estoque, gestaoFinanceira);
    
    private Funcionario funcionarioLogado;
    private static final Elevador[] elevadores = new Elevador[3];
    
    /**
     * Bloco de inicialização estático.
     * Este bloco é executado apenas uma vez, quando a classe Oficina é carregada
     */
    static {
        elevadores[0] = new Elevador(1, TipoElevador.ALINHAMENTO);
        elevadores[1] = new Elevador(2, TipoElevador.GERAL);
        elevadores[2] = new Elevador(3, TipoElevador.GERAL);
    }

    /**
     * Retorna a lista de todos os elevadores da oficina.
     * @return 
     */
    public static Elevador[] getElevadores() {
        return elevadores;
    }
    
    /**
     * Busca um elevador específico pelo seu ID
     * @param id
     * @return 
     */
    public static Elevador buscarElevadorPorId(int id){
        if (id > 0 && id <= elevadores.length){
            return elevadores[id - 1];
        }
        return null;
    }
    
    /**
     * Lista todos os elevadores e seus status atuais
     */
    public static void imprimirStatusElevadores() {
        System.out.println("--- Status dos Elevadores ---");
        for (Elevador elevador : elevadores) {
            System.out.println(elevador.toString());
        }
        System.out.println("---------------------------");
    }
    
    /**
     * Realiza o login de um funcionario
     * @param login
     * @param senha
     * @return 
     */
    public boolean login(String login, String senha){
        if(gestaoFuncionarios.validaDados(login, senha) == true){
            funcionarioLogado = gestaoFuncionarios.buscaFuncionarioLogin(login);
            System.out.println("Login realizado com sucesso " + funcionarioLogado.getNome());
            return true;
        }
        System.out.println("Falha no login, dados incorretos");
        return false;
    }
    
    /**
     * Função que chama o metodo de bater ponto da gestão de funcionarios
     */
    public void baterPonto(){
        if(funcionarioLogado != null){
            gestaoFuncionarios.baterPonto(funcionarioLogado.getIdFuncionario());
        }
    }
    
    /**
     * Função que chama o metodo de encerrar expediente da gestão de funcionarios
     */
    public void encerrarExpediente(){
        if(funcionarioLogado != null){
            gestaoFuncionarios.encerrarExpediente(funcionarioLogado.getIdFuncionario());
        }
    }
    
    /**
     * Encerra a seção de um funcionario
     */
    public void logout(){
        funcionarioLogado = null;
        System.out.println("Logout realizado");
    }
    /**
     * Menu principal do sistema
     */
    public void menuPrincipal() {
        Scanner scanner = new Scanner(System.in);

        // Loop de login
        while (funcionarioLogado == null) {
            System.out.print("Login: ");
            String login = scanner.nextLine();

            System.out.print("Senha: ");
            String senha = scanner.nextLine();

            login(login, senha); // se o login for bem-sucedido, o funcionário será setado
        }

        // Menu após login
        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n==== Menu Principal ====");
            System.out.println("Funcionário logado: " + funcionarioLogado.getNome());
            System.out.println("1. Bater ponto");
            System.out.println("2. Encerrar expediente");
            System.out.println("3. Listar pontos");
            System.out.println("4. Gestão de Funcionários");
            System.out.println("5. Gestão de Clientes");
            System.out.println("6. Gestão de Veículos");
            System.out.println("7. Gestão de Ordens de Serviço");
            System.out.println("8. Gestão Financeira");
            System.out.println("9. Agenda");
            System.out.println("0. Logout e sair");
            System.out.print("Escolha uma opção: ");
        
            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida.");
                continue;
            }

            switch (opcao) {
                case 1:
                    baterPonto();
                    break;
                case 2:
                    encerrarExpediente();
                    break;
                case 3:
                    gestaoFuncionarios.listarPontos(funcionarioLogado.getIdFuncionario());
//                case 4:
//                    gestaoFuncionarios.menu(); 
//                    break;
//                case 5:
//                    gestaoClientes.menu();
//                    break;
//                case 6:
//                    gestaoVeiculos.menu();
//                    break;
//                case 7:
//                    gestaoOS.menu(funcionarioLogado); 
//                    break;
//                case 8:
//                    gestaoFinanceira.menu(funcionarioLogado);
//                    break;
//                case 9:
//                    agenda.menu();
//                    break;
                case 0: 
                    logout();
                    System.out.println("Saindo do sistema...");
                    break;
                
                default: 
                    System.out.println("Opção inválida.");
            }
        }

        scanner.close();
    }

    /**
     * 
     * @return 
     */
    public Funcionario getFuncionarioLogado() {
        return funcionarioLogado;
    }

    /**
     * 
     * @return 
     */
    public FuncionarioService getGestaoFuncionarios() {
        return gestaoFuncionarios;
    }

    /**
     * 
     * @param gestaoFuncionarios 
     */
    public void setGestaoFuncionarios(FuncionarioService gestaoFuncionarios) {
        this.gestaoFuncionarios = gestaoFuncionarios;
    }

    /**
     * 
     * @return 
     */
    public GestaoClientes getGestaoClientes() {
        return gestaoClientes;
    }

    /**
     * 
     * @param gestaoClientes 
     */
    public void setGestaoClientes(GestaoClientes gestaoClientes) {
        this.gestaoClientes = gestaoClientes;
    }

    /**
     * 
     * @return 
     */
    public Agenda getAgenda() {
        return agenda;
    }

    /**
     * 
     * @param agenda 
     */
    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    /**
     * 
     * @return 
     */
    public GestaoDeVeiculos getGestaoVeiculos() {
        return gestaoVeiculos;
    }

    /**
     * 
     * @param gestaoVeiculos 
     */
    public void setGestaoVeiculos(GestaoDeVeiculos gestaoVeiculos) {
        this.gestaoVeiculos = gestaoVeiculos;
    }

    /**
     * 
     * @return 
     */
    public GestaoFinanceira getGestaoFinanceira() {
        return gestaoFinanceira;
    }

    /**
     * 
     * @param gestaoFinanceira 
     */
    public void setGestaoFinanceira(GestaoFinanceira gestaoFinanceira) {
        this.gestaoFinanceira = gestaoFinanceira;
    }

    /**
     * 
     * @return 
     */
    public Estoque getEstoque() {
        return estoque;
    }

    /**
     * 
     * @param estoque 
     */
    public void setEstoque(Estoque estoque) {
        this.estoque = estoque;
    }

    /**
     * 
     * @return 
     */
    public GestaoDeOrdemDeServico getGestaoOS() {
        return gestaoOS;
    }

    /**
     * 
     * @param gestaoOS 
     */
    public void setGestaoOS(GestaoDeOrdemDeServico gestaoOS) {
        this.gestaoOS = gestaoOS;
    }
    
    /**
     * Retoena uma representação textual do sistema
     * @return 
     */
    @Override
    public String toString() {
        return "SistemaOficina{" + "funcionarioLogado=" + funcionarioLogado + '}';
    }
    
}
