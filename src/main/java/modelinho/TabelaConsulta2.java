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
public class TabelaConsulta2 {
    String nome;
    String cnpj;
    int ano;
    int semestre;
    int quantidade;
    double valortotal;

    public TabelaConsulta2() {
    }

    public TabelaConsulta2(String nome, String cnpj, int ano, int semestre, int quantidade, double valortotal) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.ano = ano;
        this.semestre = semestre;
        this.quantidade = quantidade;
        this.valortotal = valortotal;
    }
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
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
    
    
}
