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
public class TabelaConsulta3 {
    String nome;
    String cpf;
    int quantidade;
    double valortotal;
    int ano;

    public TabelaConsulta3() {
    }

    public TabelaConsulta3(String nome, String cpf, int quantidade, double valortotal) {
        this.nome = nome;
        this.cpf = cpf;
        this.quantidade = quantidade;
        this.valortotal = valortotal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValortotal() {
        return valortotal;
    }

    public void setValortotal(double valortotal) {
        this.valortotal = valortotal;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }




     
}
