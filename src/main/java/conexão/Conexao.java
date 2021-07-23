/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexão;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author rafae
 */
public class Conexao {
    public Statement stmt;
    public ResultSet rs;
    
    public Connection conexao;
    
    public Connection getConection() {
  
        try {
            conexao = DriverManager.getConnection
                        ("jdbc:postgresql://localhost:5432/EasySolar","postgres", "rc12345");
            System.out.println("Conectado com Sucesso");
        } catch (SQLException ex) {
            
            throw new RuntimeException(ex);
        }
        return conexao;
    }
    
    public void closeCon(){
        try {
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexao: "+ ex);
        }
    }
    public void executaSQL(String sql){
    
        try {
            stmt = conexao.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            rs.next();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
