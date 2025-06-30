/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicos;

import Dominio.Cargo;
import Dominio.CategoriaDespesa;
import Dominio.Funcionario;
import Dominio.Lancamento;
import Dominio.NotaFiscal;
import Dominio.TipoLancamento;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

/**
 * Gerencia todas as operações financeiras, como lançamentos de receitas e despesas, e o armazenamento de notas fiscais
 * @author luizp
 */
public class GestaoFinanceira {
    private ArrayList<Lancamento> lancamentos;
    private ArrayList<NotaFiscal> notasFiscais;
    private static final String CAMINHO_ARQUIVO = "financeiro.json";
    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * Construtor padrão
     */
    public GestaoFinanceira() {
        this.lancamentos = new ArrayList<>();
        this.notasFiscais = new ArrayList<>();
        mapper.registerModule(new JavaTimeModule());
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }
    
    /**
     * Carrega os dados financeiros a partir de um arquivo JSON
     * @return 
     */
    public static GestaoFinanceira carregarDoArquivo() {
        try {
            File arquivo = new File(CAMINHO_ARQUIVO);
            if (arquivo.exists() && arquivo.length() > 0) {
                ObjectMapper localMapper = new ObjectMapper();
                localMapper.registerModule(new JavaTimeModule());
                return localMapper.readValue(arquivo, GestaoFinanceira.class);
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar dados financeiros: " + e.getMessage());
        }
        return new GestaoFinanceira();
    }

    /**
     * Salva o estado atual do objeto GestaoFinanceira em um arquivo JSON
     */
    private void salvarNoArquivo() {
        try {
            mapper.writeValue(new File(CAMINHO_ARQUIVO), this);
        } catch (IOException e) {
            System.err.println("Erro ao salvar dados financeiros: " + e.getMessage());
        }
    }
    
    /**
     * Metodo publico para salvar alterações
     */
    public void salvar(){
        salvarNoArquivo();
    }
    
    /**
     * Adiciona um novo lançamento financeiro à lista e salva o estado atual
     * @param lancamento 
     */
    public void adicionarLancamento(Lancamento lancamento){
        lancamentos.add(lancamento);
        salvar();
    }
    
    /**
     * Adiciona uma nova nota fiscal à lista e salva o estado atual
     * @param nota 
     */
    public void adicionarNotaFiscal(NotaFiscal nota) {
        this.notasFiscais.add(nota);
        salvar();
    }
    
    /**
     * Método que permite a um gerente adicionar uma despesa
     * @param descricao
     * @param valor
     * @param categoria
     * @param funcionario 
     */
    public void adicionarDespesa(String descricao, double valor, CategoriaDespesa categoria, Funcionario funcionario){
        if(funcionario.getCargo() == Cargo.Gerente){
            Lancamento despesa = new Lancamento(descricao, valor, LocalDate.now(), TipoLancamento.Despesa, categoria);
            adicionarLancamento(despesa);
            System.out.println("Despesa registrada");
        } else {
            System.out.println("Usuario sem permissão");
        }
    }
    
    /**
     * Calcula e exibe no console um balanço financeiro para um determinado mês e ano
     * @param mes
     * @param ano 
     * @param funcionario 
     */
    public void gerarBalancoMes(Month mes, int ano, Funcionario funcionario){
        if(funcionario.getCargo() != Cargo.Gerente){
            System.out.println("Usuario sem permissão para gerar balanço");
        } else{
            ArrayList<Lancamento> lancamentoMes = new ArrayList<>();
            double totalReceitas = 0;
            double totalDespesas = 0;
            for (Lancamento l : lancamentos){
                if(l.getData().getMonth() == mes && l.getData().getYear() == ano){
                    lancamentoMes.add(l);
                    if (l.getTipo()==TipoLancamento.Despesa){
                        totalDespesas += l.getValor();
                    } else {
                        totalReceitas += l.getValor();
                    }
                }
            }
            double balanco = totalReceitas - totalDespesas;
        
            System.out.println("\n========= BALANÇO MENSAL - " + mes + "/" + ano + " =========");
            System.out.println("Lançamentos do Período:");
            lancamentoMes.forEach(System.out::println);
            System.out.println("-----------------------------------------------------");
            System.out.printf("Total de Receitas: R$ %.2f\n", totalReceitas);
            System.out.printf("Total de Despesas: R$ %.2f\n", totalDespesas);
            System.out.println("-----------------------------------------------------");
            System.out.printf("Balanço do Mês: R$ %.2f\n", balanco);
            System.out.println("=====================================================\n");
        }
    }
    
    /**
     * Busca todas as notas fiscais associadas a um ID de cliente
     * @param idCliente
     * @return 
     */
    public ArrayList<NotaFiscal> buscarNotasPorCliente(int idCliente){
        ArrayList<NotaFiscal> notasDoCliente = new ArrayList<>();
        for(NotaFiscal nota : notasFiscais){
            if(nota.getIdCliente() == idCliente){
                notasDoCliente.add(nota);
            }
        }
        if(notasDoCliente.isEmpty()){
            System.out.println("O cliente não possui notas fiscais");
        }
        return notasDoCliente;
    }
    
    /**
     * Imprime no console todas as notas fiscais de um cliente
     * @param idCliente 
     */
    public void imprimirNotasPorCliente(int idCliente) {
        ArrayList<NotaFiscal> notas = buscarNotasPorCliente(idCliente);
        if (notas.isEmpty()) {
            System.out.println("Nenhuma nota fiscal encontrada para este cliente.");
        } else {
            System.out.println("Notas fiscais do cliente ID " + idCliente + ":");
            for (NotaFiscal nota : notas) {
                System.out.println(nota);
            }
        }
    }

    /**
     * 
     * @return 
     */
    public ArrayList<Lancamento> getLancamentos() {
        return lancamentos;
    }

    /**
     * 
     * @param lancamentos 
     */
    public void setLancamentos(ArrayList<Lancamento> lancamentos) {
        this.lancamentos = lancamentos;
    }

    /**
     * 
     * @return 
     */
    public ArrayList<NotaFiscal> getNotasFiscais() {
        return notasFiscais;
    }

    /**
     * 
     * @param notasFiscais 
     */
    public void setNotasFiscais(ArrayList<NotaFiscal> notasFiscais) {
        this.notasFiscais = notasFiscais;
    }

    /**
     * Retorna uma representação textual da gestão financeira
     * @return 
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Relatório Financeiro Completo ===\n");
        sb.append("\n--- Lançamentos Financeiros ---\n");
        if (lancamentos.isEmpty()) {
            sb.append("Nenhum lançamento registrado.\n");
        } else {
            for (Lancamento l : lancamentos) {
                sb.append(l.toString()).append("\n");
            }
        }
        sb.append("\n--- Notas Fiscais Armazenadas ---\n");
        if (notasFiscais.isEmpty()) {
            sb.append("Nenhuma nota fiscal armazenada.\n");
        } else {
            for (NotaFiscal n : notasFiscais) {
                sb.append(n.toString()).append("\n");
            }
        }
        sb.append("===================================");
        return sb.toString();
    }
    
}
