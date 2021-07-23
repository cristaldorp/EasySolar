/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dao.impl;

import java.util.List;
import model.entidades.Funcionarios;
import Model.dao.FuncionarioDao;
import conexão.DB;
import conexão.DbException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class FuncionarioDaoJDBC implements FuncionarioDao{
    
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;
    
    public FuncionarioDaoJDBC(Connection conn){
        this.conn = conn;
    }

    public FuncionarioDaoJDBC() {
    }


    @Override
    public void insert(Funcionarios f) {
        
        try{
            stmt = conn.prepareStatement("insert into funcionario " 
                    + "(nome, telefone, cpf, endereco, dataCadastro) " 
                    + "values(?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getTelefone());
            stmt.setString(3, f.getCPF());
            stmt.setString(4, f.getEndereco());
            stmt.setDate(5, new Date(f.getDataCadastro().getTime()));
            
            //TESTE SE LINHA ALTERADA FOR MAIOR QUE 0
            int rowsAffected = stmt.executeUpdate();
            if(rowsAffected > 0){
                rs = stmt.getGeneratedKeys();
                if(rs.next()){
                    int id = rs.getInt(1);
                    f.setIdFuncionario(id);
                }
                DB.closeResult(rs);
            }
            else {
                throw new DbException("Nenhuma linha foi alterada");
            }
        
            
        } catch (SQLException ex) {
            throw new DbException(ex.getMessage());
        }
        finally{
            DB.closeStatement(stmt);
        }
    }

    @Override
    public void update(Funcionarios f) {
        try{
        stmt = conn.prepareStatement("update funcionarios set "
                + "nome=?, telefone=?, cpf=?, endereco=?, dataCad=? "
                + "where idFunc=?");
        
            stmt.setString(1, f.getNome());
            stmt.setString(2, f.getTelefone());
            stmt.setString(3, f.getCPF());
            stmt.setString(4, f.getEndereco());
            stmt.setDate(5, new Date(f.getDataCadastro().getTime()));
            stmt.setInt(6, f.getIdFuncionario());
            
            stmt.executeUpdate();
            
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            DB.closeStatement(stmt);
        }
    }
  
    public void deleteByid(Funcionarios f) {
        try{
        stmt = conn.prepareStatement("delete from funcionario where idFunc = ?");
        
            stmt.setInt(1, f.getIdFuncionario());
            stmt.executeUpdate();
            
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            DB.closeStatement(stmt);
        }
    }

    @Override
    public Funcionarios findByid(Integer id) {
        
        try{
            stmt = conn.prepareStatement(
                    "select * from funcionario "
                    + "where funcionario.id = ?");
            
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if(rs.next()){
                Funcionarios fun = new Funcionarios();
                fun.setIdFuncionario(id);
            }
            
        } catch (SQLException ex) {
            throw new DbException(ex.getMessage());
        }
        finally{
            DB.closeResult(rs);
            DB.closeStatement(stmt);
            DB.closeConexao();
        }
        return null;
        
    }

    @Override
    public List<Funcionarios> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
