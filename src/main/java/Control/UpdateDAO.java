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
import javax.swing.JOptionPane;

/**
 *
 * @author rafae
 */
public class UpdateDAO {
    Conexao c = new Conexao();
    
    public void alteraFunc(Funcionarios f){
        c.getConection();
        String sql = "update funcionarios set nome=?, telefone=?, cpf=?, endereco=?, dataCad=?, where idFunc=?";
        
        try{
        
            PreparedStatement stmt = c.conexao.prepareStatement(sql);
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getTelefone());
            stmt.setString(3, f.getCPF());
            stmt.setString(4, f.getEndereco());
            stmt.setDate(5, new Date(f.getDataCadastro().getTime()));
            stmt.setInt(5, f.getIdFuncionario());
            
            stmt.execute();
            stmt.close();
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao alterar: "+e);
        }
    }
}
