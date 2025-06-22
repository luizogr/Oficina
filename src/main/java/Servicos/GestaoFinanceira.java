/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicos;

import Dominio.Lancamento;
import Dominio.TipoLancamento;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.time.Month;
import java.util.ArrayList;

/**
 *
 * @author luizp
 */
public class GestaoFinanceira {
    private ArrayList<Lancamento> lancamentos;
    private static final String CAMINHO_ARQUIVO = "financeiro.json";
    private static final ObjectMapper mapper = new ObjectMapper();

    public GestaoFinanceira() {
        this.lancamentos = new ArrayList<>();
    }
    
    public static GestaoFinanceira carregarDoArquivo() {
        try {
            File arquivo = new File(CAMINHO_ARQUIVO);
            if (arquivo.exists() && arquivo.length() > 0) {
                ObjectMapper localMapper = new ObjectMapper();
                return localMapper.readValue(arquivo, GestaoFinanceira.class);
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar dados financeiros: " + e.getMessage());
        }
        return new GestaoFinanceira();
    }

    public void salvarNoArquivo() {
        try {
            mapper.writeValue(new File(CAMINHO_ARQUIVO), this);
        } catch (IOException e) {
            System.err.println("Erro ao salvar dados financeiros: " + e.getMessage());
        }
    }
    
    public void adicionarLancamento(Lancamento lancamento){
        lancamentos.add(lancamento);
    }
    
    public void gerarBalancoMes(Month mes, int ano){
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

    public ArrayList<Lancamento> getLancamentos() {
        return lancamentos;
    }

    public void setLancamentos(ArrayList<Lancamento> lancamentos) {
        this.lancamentos = lancamentos;
    }
}
