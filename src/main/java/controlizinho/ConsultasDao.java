/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlizinho;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos Eduardo
 */
public class ConsultasDao {

    public static Object[] QtdeVendasSemestre() throws erros {  // realiza a consulta no banco de dados e retorna o valor da quantidade de vendas no semestre 1 
        Object[] quantidadeValor= new Object[2];
        int quantidadeVendasSemestreAtual = 0;
        double valorVendaSemestralAtual =0.0;
        

        try (Connection con = Conexao.getConnection();) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select count (valor_vendas) as quantidade , sum(valor_vendas) from vendas inner join tempo on vendas.id_tempo=tempo.id where semestre =1 and ano=2019");
            while (rs.next()) {                
                
            quantidadeVendasSemestreAtual = (int)rs.getInt("quantidade");
            quantidadeValor[0]= quantidadeVendasSemestreAtual;
            valorVendaSemestralAtual = (double)rs.getDouble("sum");  
            quantidadeValor[1]= (double)valorVendaSemestralAtual;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConsultasDao.class.getName()).log(Level.SEVERE, null, ex);
            throw new erros("Erro ao incluir:\n" + ex.getMessage());
        }
        return quantidadeValor;
    }

    
    
    
    public static  ArrayList<TabelaVendaLojaSemestre> ValorVendasLojaSemestre() throws Exception {  // realiza a consulta no banco de dados e retorna o valor total de vendas pos semestre e loja
 
        ArrayList<TabelaVendaLojaSemestre> table = new ArrayList<>();

        try (Connection con = Conexao.getConnection();) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select ano, semestre ,nome , Sum(valor_vendas) from vendas inner join tempo ON vendas.id_tempo=tempo.id  inner join loja on vendas.id_loja=loja.id group by ano,semestre,nome");
            TabelaVendaLojaSemestre t = new TabelaVendaLojaSemestre();
            while(rs.next()){
            t.setAno(rs.getInt("ano"));
            t.setSemestre(rs.getByte("semestre"));
            t.setNomeLoja(rs.getString("nome"));
            t.setValorTotal(rs.getDouble("Sum"));
            table.add(t);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasDao.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Erro ao incluir:\n");
        }
        return table;
    }
    
    
    public static int QuantidadeLoja() throws Exception{ //Quantidade de loja
        
        int quantidadeLoja = 0;

        try (Connection con = Conexao.getConnection();) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select count (nome) from loja");

            while(rs.next()){
                quantidadeLoja = rs.getInt("count");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ConsultasDao.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Erro ao incluir:\n");
        }
        return quantidadeLoja;
    }
    
    
    
    
    
    
    

}
