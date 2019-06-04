/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlizinho;

/**
 *
 * @author Carlos Eduardo
 */
public class TabelaVendaLojaSemestre { //Classe com objetivo de receber os valores do banco de dados referentes a consulta de valor vendas semestre loja
    int ano;
    int Semestre;
    String nomeLoja;
    double valorTotal;

    public TabelaVendaLojaSemestre() {
    }

    public TabelaVendaLojaSemestre(int ano, int Semestre, String nomeLoja, double valorTotal) {
        this.ano = ano;
        this.Semestre = Semestre;
        this.nomeLoja = nomeLoja;
        this.valorTotal = valorTotal;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getSemestre() {
        return Semestre;
    }

    public void setSemestre(int Semestre) {
        this.Semestre = Semestre;
    }

    public String getNomeLoja() {
        return nomeLoja;
    }

    public void setNomeLoja(String nomeLoja) {
        this.nomeLoja = nomeLoja;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

   
    
}
