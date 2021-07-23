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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author rafae
 */
public class Conexao {
    public static Connection conexao = null;
    
    public static Connection getConection() {
        try {
            conexao = DriverManager.getConnection
                        ("jdbc:postgresql://localhost:5432/EasySolar","postgres", "rc12345");
            System.out.println("Conectado com Sucesso");
        } catch (SQLException ex) {
            throw new DbException(ex.getMessage());
        }
        return conexao;
    }
    
    public static void closeConexao(){
        if(conexao != null){
            try {
                conexao.close();
            } catch (SQLException ex) {
                throw new DbException(ex.getMessage());
            }
        }
    }
    
    public static void closeStatement(Statement stmt){
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException ex) {
              throw new DbException(ex.getMessage());
            }
        }
    }
    
   public static void closeResult(ResultSet rs){
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException ex) {
              throw new DbException(ex.getMessage());
            }
        }
    }
}
