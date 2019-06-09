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
import modelinho.TabelaConsulta2;
import modelinho.TabelaConsulta3;

/**
 *
 * @author Carlos Eduardo
 */
public class ConsultasDao {

    public static String QtdeVendasSemestre(int opcao) throws Exception {  // realiza a consulta no banco de dados e retorna o valor da quantidade de vendas no semestre 1 

        int quantidadeVendasSemestreAtual = 0;
        double valorVendaSemestralAtual = 0.0;
        String valor = "";

        try (Connection con = Conexao.getConnection();) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select count (valor_vendas) as quantidade , sum(valor_vendas) from vendas inner join tempo on vendas.id_tempo=tempo.id where semestre =1 and ano=2019");
            while (rs.next()) {

                quantidadeVendasSemestreAtual = (int) rs.getInt("quantidade");

                valorVendaSemestralAtual = (double) rs.getDouble("sum");

            }

        } catch (SQLException ex) {
            Logger.getLogger(ConsultasDao.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Erro ao incluir:\n");
        }
        if (opcao == 1) {
            valor = "" + quantidadeVendasSemestreAtual;
        }
        if (opcao == 2) {
            valor = "" + valorVendaSemestralAtual;
        }
        return valor;
    }

    public static ArrayList<TabelaVendaLojaSemestre> ValorVendasLojaSemestre() throws Exception {  // realiza a consulta no banco de dados e retorna o valor total de vendas pos semestre e loja

        ArrayList<TabelaVendaLojaSemestre> table = new ArrayList<>();

        try (Connection con = Conexao.getConnection();) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select ano, semestre ,nome , Sum(valor_vendas) from vendas inner join tempo ON vendas.id_tempo=tempo.id  inner join loja on vendas.id_loja=loja.id group by ano,semestre,nome");
            TabelaVendaLojaSemestre t = new TabelaVendaLojaSemestre();
            while (rs.next()) {
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

    public static int QuantidadeLoja() throws Exception { //Quantidade de loja

        int quantidadeLoja = 0;

        try (Connection con = Conexao.getConnection();) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select count (nome) from loja");

            while (rs.next()) {
                quantidadeLoja = rs.getInt("count");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConsultasDao.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Erro ao incluir:\n");
        }
        return quantidadeLoja;
    }

    public static int QuantidadeCliente() throws Exception { //Quantidade de loja

        int quantidadeCliente = 0;

        try (Connection con = Conexao.getConnection();) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select count(nome)from cliente");

            while (rs.next()) {
                quantidadeCliente = rs.getInt("count");
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConsultasDao.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Erro ao incluir:\n");
        }
        return quantidadeCliente;
    }

    public static ArrayList<TabelaConsulta3> gerarListaConsulta3() throws Exception {
        ArrayList<TabelaConsulta3> listaConsulta3 = new ArrayList<>();

        try (Connection con = Conexao.getConnection();) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select nome, cpf, ano , sum(valor_vendas), count(valor_vendas) from vendas inner join cliente on vendas.id_cliente=cliente.id inner join tempo on vendas.id_tempo=tempo.id group by nome, ano, cpf");

            while (rs.next()) {
                TabelaConsulta3 t = new TabelaConsulta3();
                t.setAno(rs.getInt("ano"));
                t.setNome(rs.getString("nome"));
                t.setCpf(rs.getString("cpf"));
                t.setQuantidade(rs.getInt("count"));
                t.setValortotal(rs.getDouble("sum"));
                listaConsulta3.add(t);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ConsultasDao.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Erro ao incluir:\n");
        }

        return listaConsulta3;
    }

    //Consulta tabela 2 Total valor vendas por loja por semestre
    public static ArrayList<TabelaConsulta2> GerarTabela2(String ano, String semestre) throws Exception {
        int anoint = Integer.parseInt(ano);
        int semestreint = Integer.parseInt(semestre);
        
        ArrayList<TabelaConsulta2> lista = new ArrayList<>();
        try (Connection con = Conexao.getConnection();) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select ano, semestre ,nome ,cnpj, Sum(valor_vendas), count(valor_vendas) from vendas inner join tempo ON vendas.id_tempo=tempo.id inner join loja on vendas.id_loja=loja.id where semestre="+ semestreint +" and ano=" + anoint + " group by ano,semestre,nome,cnpj");

            while (rs.next()) {
                TabelaConsulta2 t = new TabelaConsulta2();
                
                t.setAno(rs.getInt("ano"));
                t.setNome(rs.getString("nome"));
                t.setSemestre(rs.getInt("semestre"));
                t.setQuantidade(rs.getInt("count"));
                t.setValortotal(rs.getDouble("Sum"));
                t.setCnpj(rs.getString("cnpj"));

                lista.add(t);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConsultasDao.class.getName()).log(Level.SEVERE, null, ex);
            throw new erros("Erro ao incluir:\n" + ex.getMessage());
        }

        return lista;

    }

}
