/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import model.entidades.Funcionarios;
import conexão.DB;
import conexão.DbException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author rafae
 */
public class InsertDAO {
    
    public void addFuncionario(Funcionarios f) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try{
            conn = DB.getConection();
            stmt = conn.prepareStatement("insert into funcionario " 
                    + "(nome, telefone, cpf, endereco, dataCadastro) " 
                    + "values(?,?,?,?,?)");
            
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getTelefone());
            stmt.setString(3, f.getCPF());
            stmt.setString(4, f.getEndereco());
            stmt.setDate(5, new Date(f.getDataCadastro().getTime()));
            stmt.executeUpdate();
        
            
        } catch (SQLException ex) {
            throw new DbException(ex.getMessage());
        }
        finally{
            DB.closeStatement(stmt);
            DB.closeConexao();
        }
    }
}
