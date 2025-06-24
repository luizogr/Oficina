/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicos;

import Dominio.Elevador;
import Dominio.Funcionario;
import Dominio.TipoElevador;

/**
 *
 * @author luizp
 */
public class SistemaOficina {
    private FuncionarioService gestaoFuncionarios = FuncionarioService.carregarDoArquivo();
    
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
     * 
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
     * 
     */
    public void logout(){
        funcionarioLogado = null;
        System.out.println("Logout realizado");
    }
}
