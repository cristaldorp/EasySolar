/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.Funcionarios;
import conexão.Conexao;
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
    Conexao c = new Conexao();
    
    public void addFuncionario(Funcionarios f) throws SQLException{
        c.getConection();
        
        String sql = "insert into funcionario" + "(nome, telefone, cpf, endereco, dataCadastro)" 
                + "values(?,?,?,?,?)";
        
        try {
            try (PreparedStatement stmt = c.conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                stmt.setString(1, f.getNome());
                stmt.setString(2, f.getTelefone());
                stmt.setString(3, f.getCPF());
                stmt.setString(4, f.getEndereco());
                stmt.setDate(5, new Date(f.getDataCadastro().getTime()));
                stmt.executeUpdate();
            }
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir: "+ex);
        }
    }
}
