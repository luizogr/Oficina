/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicos;

import Dominio.Cargo;
import Dominio.Funcionario;
import Dominio.Mecanico;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author luizp
 */
public class FuncionarioService {
    private ArrayList<Funcionario> funcionarios;
    private Map<Integer, Map<LocalDateTime, LocalDateTime>> controleDePontos;
    private static final String CAMINHO_ARQUIVO = "funcionarios.json";
    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * Cria uma ArrayList dos funcionarios
     */
    public FuncionarioService() {
        this.funcionarios = new ArrayList<>();
        this.controleDePontos = new HashMap<>();
        mapper.registerModule(new JavaTimeModule());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.activateDefaultTyping(mapper.getPolymorphicTypeValidator(), ObjectMapper.DefaultTyping.NON_FINAL);
    }
    
    /**
     * 
     * @return 
     */
    public static FuncionarioService carregarDoArquivo() {
        try {
            File arquivo = new File(CAMINHO_ARQUIVO);
            if (arquivo.exists() && arquivo.length() > 0) {
                ObjectMapper localMapper = new ObjectMapper();
                localMapper.registerModule(new JavaTimeModule());
                localMapper.activateDefaultTyping(localMapper.getPolymorphicTypeValidator(), ObjectMapper.DefaultTyping.NON_FINAL);
                FuncionarioService gestao = localMapper.readValue(arquivo, FuncionarioService.class);
                
                int maxId = 0;
                if (gestao.getFuncionarios() != null) {
                    for(Funcionario f : gestao.getFuncionarios()){
                        if(f.getIdFuncionario() > maxId){
                            maxId = f.getIdFuncionario();
                        }
                    }
                }
                Funcionario.setContadorId(maxId);
                
                return gestao;
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar dados dos funcionários: " + e.getMessage());
        }
        return new FuncionarioService();
    }
    
    /**
     * 
     */
    private void salvarNoArquivo() {
        try {
            mapper.writeValue(new File(CAMINHO_ARQUIVO), this);
        } catch (IOException e) {
            System.err.println("Erro ao salvar dados dos funcionários: " + e.getMessage());
        }
    }
    
    public void salvarFuncionarios(){
        salvarNoArquivo();
    }
    
    /**
     * 
     * @param funcionario 
     */
    public void adicionarFuncionario(Funcionario funcionario){
        if(buscaFuncionario(funcionario.getIdFuncionario()) == null) {
            funcionarios.add(funcionario);
        } else {
            System.err.println("Erro: Já existe um funcionário com o ID " + funcionario.getIdFuncionario());
        }
    }
    
    /**
     * função para remover o funcionário pelo objeto
     * @param funcionario 
     */
    public void removerFuncionario(Funcionario funcionario){
        funcionarios.remove(funcionario);
    }
    
    /**
     * 
     * @param idFuncionario
     * @return 
     */
    public boolean baterPonto(int idFuncionario){
        Map<LocalDateTime, LocalDateTime> pontosFuncionario = controleDePontos.getOrDefault(idFuncionario, new HashMap<>());
        for(Map.Entry<LocalDateTime, LocalDateTime> entry : pontosFuncionario.entrySet()){
            if(entry.getValue() == null){
                System.out.println("Ponto registrado,mas ainda não encerrado");
                return false;
            }
        }
        pontosFuncionario.put(LocalDateTime.now(), null);
        controleDePontos.put(idFuncionario, pontosFuncionario);
        System.out.println("Ponto registrado");
        return true;
    }
    
    /**
     * 
     * @param idFuncionario
     * @return 
     */
    public boolean encerrarExpediente(int idFuncionario){
        Map<LocalDateTime, LocalDateTime> pontosFuncionario = controleDePontos.get(idFuncionario);
        if(pontosFuncionario == null || pontosFuncionario.isEmpty()){
            System.out.println("Nenhum entrada encontrada");
            return false;
        }
        for(Map.Entry<LocalDateTime, LocalDateTime> entry : pontosFuncionario.entrySet()){
            if(entry.getValue() == null){
                entry.setValue(LocalDateTime.now());
                System.out.println("Saida registrada");
                return true;
            }
        }
        System.out.println("Nenhum ponto para encerrar");
        return false;
    }
    
    /**
     * 
     * @param idFuncionario 
     */
    public void listarPontos(int idFuncionario) {
        Map<LocalDateTime, LocalDateTime> pontosFuncionario = controleDePontos.get(idFuncionario);
        if (pontosFuncionario == null || pontosFuncionario.isEmpty()) {
            System.out.println("Nenhum ponto registrado.");
            return;
        }
        
        System.out.println("Pontos registrados:");
        for (Map.Entry<LocalDateTime, LocalDateTime> entry : pontosFuncionario.entrySet()) {
            System.out.println("Entrada: " + entry.getKey() + " | Saída: " + (entry.getValue() != null ? entry.getValue() : "Em andamento"));
        }
    }
    
    /**
     * busca um funcionario por seu id
     * @param id
     * @return caso encontre retorna o funcionario, caso não retorna null
     */
    public Funcionario buscaFuncionario(int id){
        for(Funcionario i: funcionarios){
            if(i.getIdFuncionario() == id){
                return i;
            }
        }
        return null;
    }
    
    /**
     * busca um funcionario por seu login, usado para fazer o login no sistema
     * @param login
     * @return 
     */
    public Funcionario buscaFuncionarioLogin(String login){
        for(Funcionario i: funcionarios){
            if(i.getLogin().equals(login)){
                return i;
            }
        }
        return null;
    }
    
    /**
     * Metodo para validar os dados do funcionario
     * @param login
     * @param senha
     * @return Retorna true se senha e login forem iguais ao do funcionario
     */
    public boolean validaDados(String login, String senha){
        Funcionario f = buscaFuncionarioLogin(login);
        if (f.getLogin().equals(login) && f.getSenha().equals(senha)){
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Função para remover um funcionario pelo seu id
     * @param id
     * @return true se for excluido e false caso não seja excluido
     */
    public boolean removerFuncionario(int id){
        Funcionario funcionario = buscaFuncionario(id);
        if(funcionario != null){
            funcionarios.remove(funcionario);
            return true;
        }
        return false;
    }
    
    /**
     * função para editar nome
     * @param id
     * @param nome
     * @return true se bem sucedido e false se não
     */
    public boolean editarNome(int id, String nome){
        Funcionario f = buscaFuncionario(id);
        if(f != null){
            f.setNome(nome);
            return true;
        }
        return false;
    }
    
    /**
     * função para editar cargo
     * @param id
     * @param cargo
     * @return true se bem sucedido e false se não
     */
    public boolean editarCargo(int id, Cargo cargo){
        Funcionario f = buscaFuncionario(id);
        if(f != null){
            f.setCargo(cargo);
            return true;
        }
        return false;
    }
    
    public boolean editarEspecialidade(int id, String especialidade){
        Funcionario f = buscaFuncionario(id);
        if(f != null && f.getCargo() == Cargo.Mecanico){
            Mecanico m = (Mecanico) f;
            m.setEspecialidade(especialidade);
            return true;
        }
        return false;
    }
    
    /**
     * função para editar login
     * @param id
     * @param login
     * @return true se bem sucedido e false se não
     */
    public boolean editarLogin(int id, String login){
        Funcionario f = buscaFuncionario(id);
        if(f != null){
            f.setLogin(login);
            return true;
        }
        return false;
    }
    
    /**
     * função para editar senha
     * @param id
     * @param senha
     * @return true se bem sucedido e false se não
     */
    public boolean editarSenha(int id, String senha){
        Funcionario f = buscaFuncionario(id);
        if (f != null) {
            f.setSenha(senha);
            return true;
        }
        return false;
    }
    
    public boolean editarSalario(int id, double salario){
        Funcionario f = buscaFuncionario(id);
        if (f != null) {
            f.setSalario(salario);
            return true;
        }
        return false;
    }
    
    public static void imprimirFuncionarios(FuncionarioService service) {
        ArrayList<Funcionario> funcionarios = service.getFuncionarios();

        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
        } else {
            for (Funcionario f : funcionarios) {
                System.out.println(f);
            }
        }
    }

    /**
     * função get para retornar a lista de funcionários
     * @return 
     */
    public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }
    
    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- Relatório de Funcionários Cadastrados ---\n");
        for (Funcionario f : funcionarios) {
            sb.append(f.toString()).append("\n");
        }
        sb.append("-------------------------------------------");
        return sb.toString();
    }
}
