/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlizinho;

import modelinho.TabelaVendaLojaSemestre;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelinho.Tabela1porData;
import modelinho.TabelaConsulta1Bimestre;
import modelinho.TabelaConsulta2;
import modelinho.TabelaConsulta3;
import modelinho.TabelaConsulta4;

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
                valorVendaSemestralAtual = rs.getDouble("sum");
                
                DecimalFormat df = new DecimalFormat("0.00");
                String valorFormatado = df.format(valorVendaSemestralAtual); 
                valorFormatado = valorFormatado.replaceAll(",", ".");
                valorVendaSemestralAtual = Double.parseDouble(valorFormatado);
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
            ResultSet rs = stmt.executeQuery("select nome, cpf, ano , sum(valor_vendas), count(valor_vendas) from vendas inner join cliente on vendas.id_cliente=cliente.id inner join tempo on vendas.id_tempo=tempo.id group by nome, ano, cpf order by nome, ano");

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
    
    
    //Consulta de numero 4
        public static ArrayList<TabelaConsulta4> GerarTabela4(String loja) throws Exception {
        
        ArrayList<TabelaConsulta4> lista = new ArrayList<>();
        try (Connection con = Conexao.getConnection();) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select  codigo , descricao, count(valor_vendas) as quantidade , sum(valor_vendas) from vendas inner join loja on vendas.id_loja=loja.id inner join produto on vendas.id_produto=produto.id where nome='"+ loja +"' group by codigo, descricao,nome order by descricao");

            while (rs.next()) {
                TabelaConsulta4 t = new TabelaConsulta4();
                
                t.setCodigoProduto(rs.getInt("codigo"));
                t.setDescricaoProduto(rs.getString("descricao"));
                t.setQuantidadeVendas(rs.getInt("quantidade"));
                t.setValorVendas(rs.getDouble("sum"));
                lista.add(t);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConsultasDao.class.getName()).log(Level.SEVERE, null, ex);
            throw new erros("Erro ao incluir:\n" + ex.getMessage());
        }
        
        return lista;
    
    }
        
        //Consulta numero 1 -opção Bimestre
        public static ArrayList<TabelaConsulta1Bimestre> GerarTabela1Bimestre(int ano, String periodo) throws Exception{
            ArrayList<TabelaConsulta1Bimestre> lista = new ArrayList<>();
            
            
            try (Connection con = Conexao.getConnection();) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select codigo , descricao, "+ periodo +", ano, sum(qtde_produto) as quantidade, sum(valor_vendas)as total from vendas inner join produto on  vendas.id_produto=produto.id inner join tempo on vendas.id_tempo=tempo.id where ano ="+ ano +" group by codigo,descricao, "+ periodo +",ano order by codigo, "+ periodo);

            while (rs.next()) {
                TabelaConsulta1Bimestre t = new TabelaConsulta1Bimestre();
                
                String periodoo = rs.getString(periodo)+"º " + periodo;
                t.setCodigo(rs.getInt("codigo"));
                t.setDescricao(rs.getString("descricao"));
                t.setQuantidade(rs.getInt("quantidade"));
                t.setValorTotal(rs.getDouble("total"));
                t.setPeriodo(periodoo);
                t.setAno(rs.getInt("ano"));
                lista.add(t);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConsultasDao.class.getName()).log(Level.SEVERE, null, ex);
            throw new erros("Erro ao incluir:\n" + ex.getMessage());
        }
        
        return lista;
        }
        
                //Consulta numero 1 -opção Bimestre
        public static ArrayList<Tabela1porData> GerarTabela1Datas(int opcaodata, String campoData) throws Exception{
            ArrayList<Tabela1porData> lista = new ArrayList<>();
            String[] vetdata = campoData.split("/");
            String campos = "";
            String wheree = "";
            
            if (opcaodata == 1) {
                campos = "dia ,mes ,ano";
                wheree = "where dia = " + vetdata[0] +" and mes ="+ vetdata[1] + "and ano="+ vetdata[2]; 
            } 
            if (opcaodata == 2) {
                campos = "mes ,ano";
                wheree = "where mes = " + vetdata[0] +" and ano ="+ vetdata[1]; 
            }
            if (opcaodata == 3) {
                campos = "ano";
                wheree = "where ano = " + vetdata[0]; 
            }


            
            try (Connection con = Conexao.getConnection();) {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select codigo , descricao, "+ campos+", sum(qtde_produto) as quantidade, sum(valor_vendas)as total from vendas inner join produto on  vendas.id_produto=produto.id inner join tempo on vendas.id_tempo=tempo.id "+ wheree +" group by codigo,descricao, "+ campos +" order by codigo, "+ campos);

            while (rs.next()) {
                Tabela1porData t = new Tabela1porData();
                
                t.setCodigo(rs.getInt("codigo"));
                t.setDescricao(rs.getString("descricao"));
                t.setQuantidade(rs.getInt("quantidade"));
                t.setValorTotal(rs.getDouble("total"));

                lista.add(t);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConsultasDao.class.getName()).log(Level.SEVERE, null, ex);
            throw new erros("Erro ao incluir:\n" + ex.getMessage());
        }
        
        return lista;
        }
        
        
        
}
