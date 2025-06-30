/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package Dominio;

/**
 * Representa um conjunto de serviços que podem ser realizados
 * @author luizp
 */
public enum Servicos {
    TROCA_DE_OLEO("Troca de óleo", 150.0),
    ALINHAMENTO("Alinhamento do veiculo", 100.0),
    BALANCEAMENTO("Balanceamento das Rodas", 80.0),
    ARREFECIMENTO("Revisão Sistema de Arrefecimento", 120.0),
    FREIOS("Revisão dos Freios", 200.0),
    SUSPENSÃO("Revisão da suspensão", 250.0);
    
    private String descricao;
    private double preco;
    
    /**
     * Construtor privado para inicializar cada constante do enum com sua descrição e preço
     * @param descricao
     * @param preco 
     */
    Servicos(String descricao, double preco){
        this.descricao = descricao;
        this.preco = preco;
    }

    /**
     * 
     * @return 
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * 
     * @return 
     */
    public double getPreco() {
        return preco;
    }
}
