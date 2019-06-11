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
public class Tabela1porData {
    int codigo;
    int quantidade;
    String descricao;
    double valorTotal;

    public Tabela1porData() {
    }

    public Tabela1porData(int codigo, int quantidade, String descricao, double valorTotal) {
        this.codigo = codigo;
        this.quantidade = quantidade;
        this.descricao = descricao;
        this.valorTotal = valorTotal;
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
    
}
