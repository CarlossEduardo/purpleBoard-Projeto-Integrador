/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelinho;

/**
 *
 * @author Carlos Eduardo
 */
public class TabelaConsulta1Bimestre {
    int codigo;
    int quantidade;
    String descricao;
    double valorTotal;
    String periodo;
    int ano;

    public TabelaConsulta1Bimestre() {
    }

    public TabelaConsulta1Bimestre(int codigo, int quantidade, String descricao, double valorTotal, String periodo, int ano) {
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.valorTotal = valorTotal;
        this.periodo = periodo;
        this.ano = ano;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

   
    
}
