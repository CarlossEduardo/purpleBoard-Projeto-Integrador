/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.braully.dws.controle;

import static controlizinho.ConsultasDao.GerarTabela1Bimestre;
import static controlizinho.ConsultasDao.GerarTabela1Datas;
import static controlizinho.ConsultasDao.GerarTabela2;
import static controlizinho.ConsultasDao.GerarTabela4;
import static controlizinho.ConsultasDao.QtdeVendasSemestre;
import static controlizinho.ConsultasDao.QuantidadeCliente;
import static controlizinho.ConsultasDao.QuantidadeLoja;
import static controlizinho.ConsultasDao.gerarListaConsulta3;
import java.util.ArrayList;
import java.util.List;
import modelinho.Tabela1porData;
import modelinho.TabelaConsulta1Bimestre;
import modelinho.TabelaConsulta2;
import modelinho.TabelaConsulta3;
import modelinho.TabelaConsulta4;

import org.springframework.stereotype.Component;

/**
 *
 * @author Carlos Eduardo
 */
@Component("mostrarControle")
public class mostrarControle {
    
    //1-Inicio...campos para selecionar semestre e input ano da tela de Loja
    String semestre;
    String ano;
    ArrayList<TabelaConsulta2> tabela2Loja = new ArrayList<>();

    public ArrayList<TabelaConsulta2> getTabela2Loja() {
        return tabela2Loja;
    }

    public void setTabela2Loja(ArrayList<TabelaConsulta2> tabela2Loja) {
        this.tabela2Loja = tabela2Loja;
    }

 
    
    

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }
    
    public void acaoConsultarBancoeRetornarTable() throws Exception{

        tabela2Loja = GerarTabela2(ano ,semestre);


    }
    
    //1- Fim ...
    
    //2- Campos para a quarta consulta de "quantidade total de vendas por produto e por região
    
    String loja;
    ArrayList<TabelaConsulta4> tabela4venda = new ArrayList<>();

    public String getLoja() {
        return loja;
    }

    public void setLoja(String loja) {
        this.loja = loja;
    }

    public ArrayList<TabelaConsulta4> getTabela4venda() {
        return tabela4venda;
    }

    public void setTabela4venda(ArrayList<TabelaConsulta4> tabela4venda) {
        this.tabela4venda = tabela4venda;
    }
    
    public void acaoConsultaBancoTabela4() throws Exception{
        tabela4venda = GerarTabela4(loja);
          
    }
    
    //2 - FIM
    
    
    // 3 - Campos para a primeira consulta Tabela1Bimestre
    ArrayList<TabelaConsulta1Bimestre> tabela1bimestre = new ArrayList<>();
    int anoproduto;
    String periodo;

    public ArrayList<TabelaConsulta1Bimestre> getTabela1bimestre() {
        return tabela1bimestre;
    }

    public void setTabela1bimestre(ArrayList<TabelaConsulta1Bimestre> tabela1bimestre) {
        this.tabela1bimestre = tabela1bimestre;
    }

    public int getAnoproduto() {
        return anoproduto;
    }

    public void setAnoproduto(int anoproduto) {
        this.anoproduto = anoproduto;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    public void acaoConsultarTabela1porPeriodo() throws Exception{
        tabela1bimestre = GerarTabela1Bimestre(anoproduto, periodo);
        
        
    }
    
    // 3- Fim
    
    
    // 4- Mostra tabelA 1 POR DATA 
    int opcaodata;
    String campodata;
    ArrayList<Tabela1porData> tabela1data = new ArrayList<>();

    public int getOpcaodata() {
        return opcaodata;
    }

    public void setOpcaodata(int opcaodata) {
        this.opcaodata = opcaodata;
    }

    public String getCampodata() {
        return campodata;
    }

    public void setCampodata(String campodata) {
        this.campodata = campodata;
    }

    public ArrayList<Tabela1porData> getTabela1data() {
        return tabela1data;
    }

    public void setTabela1data(ArrayList<Tabela1porData> tabela1data) {
        this.tabela1data = tabela1data;
    }
    
    public void acaoConsultaTabela1PorData() throws Exception{
        
        tabela1data = GerarTabela1Datas(opcaodata , campodata);
        
    }
    
    // 4- FIm
    
    
    // Teste Grafico 
    int testeGrafico[] = new int[10];

    public int[] getTesteGrafico() {
        return testeGrafico;
    }

    public void setTesteGrafico(int[] testeGrafico) {
        this.testeGrafico = testeGrafico;
    }
    

    public mostrarControle() {
        testeGrafico[0] = 10;
        testeGrafico[1] = 20;
        testeGrafico[2] = 30;
        testeGrafico[3] = 40;
        testeGrafico[4] = 50;
        testeGrafico[5] = 60;
        testeGrafico[6] = 70;
        testeGrafico[7] = 80;
        testeGrafico[8] = 90;
    }
    
    
    
    
    // Teste Grafico

    
   public String getQuantidadeVendaSemestre() throws Exception{
    
    return QtdeVendasSemestre(1);
}
   public String getValorvendaSemestre() throws Exception{
       
       return QtdeVendasSemestre(2);
   }
   
   public int getQtdeLojas() throws Exception{
       
       return QuantidadeLoja();
   }
   
      public int getQtdeCliente() throws Exception{ // setar a quantidade de cliente no dashboard
       
       return QuantidadeCliente();
   }
      
      public List<TabelaConsulta3> getTabelaConsultaTres() throws Exception{
          ArrayList<TabelaConsulta3> tabela = gerarListaConsulta3();

          return tabela;
      }
      

}
