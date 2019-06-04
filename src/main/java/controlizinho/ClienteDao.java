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
import modelinho.Cliente1;
/**
 *
 * @author Carlos Eduardo
 */
public class ClienteDao {
    public static ArrayList<Cliente1> listarCliente() throws Exception{           
            
            ArrayList<Cliente1> resultado = new ArrayList<>();  
            
        try (Connection con = Conexao.getConnection();){
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from cliente");
            while(rs.next()){
                Cliente1 p = new Cliente1();
                
                p.setIdCliente(rs.getInt("id"));
                p.setCpfCliente(rs.getString("cpf"));
                p.setNomeCliente(rs.getString("nome"));
                p.setCodCliente(rs.getInt("cod"));
                resultado.add(p);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDao.class.getName()).log(Level.SEVERE, null, ex);
            throw new Exception("Erro ao incluir:\n");
        }
        return resultado;
    } 
}
