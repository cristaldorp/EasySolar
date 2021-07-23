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
import javax.swing.JOptionPane;

/**
 *
 * @author rafae
 */
public class UpdateDAO {
    
    
    public void alteraFunc(Funcionarios f){
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try{
        stmt = conn.prepareStatement("update funcionarios set nome=?, telefone=?, cpf=?, endereco=?, dataCad=?, where idFunc=?");
        
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getTelefone());
            stmt.setString(3, f.getCPF());
            stmt.setString(4, f.getEndereco());
            stmt.setDate(5, new Date(f.getDataCadastro().getTime()));
            stmt.setInt(6, f.getIdFuncionario());
            
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            DB.closeStatement(stmt);
            DB.closeConexao();
        }
    }
}
