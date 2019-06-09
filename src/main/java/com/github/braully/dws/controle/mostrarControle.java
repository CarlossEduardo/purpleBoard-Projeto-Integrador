/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.braully.dws.controle;

import static controlizinho.ConsultasDao.GerarTabela2;
import static controlizinho.ConsultasDao.QtdeVendasSemestre;
import static controlizinho.ConsultasDao.QuantidadeCliente;
import static controlizinho.ConsultasDao.QuantidadeLoja;
import static controlizinho.ConsultasDao.gerarListaConsulta3;
import java.util.ArrayList;
import java.util.List;
import modelinho.TabelaConsulta2;
import modelinho.TabelaConsulta3;

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
                System.out.println(ano);
        System.out.println(semestre);
        tabela2Loja = GerarTabela2(ano ,semestre);


    }
    
    //1- Fim ...
    
    
    
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
