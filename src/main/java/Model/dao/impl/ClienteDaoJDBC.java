/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dao.impl;

import Model.dao.ClientesDao;
import conexão.DB;
import conexão.DbException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.entidades.Clientes;
import model.entidades.Funcionarios;

/**
 *
 * @author Usuario
 */
public class ClienteDaoJDBC implements ClientesDao{
    
    private Connection conn;
    private PreparedStatement stmt;
    private ResultSet rs;

    public ClienteDaoJDBC() {
    }
    
    
    
    @Override
    public void insert(Clientes obj) {
        
        try{
            stmt = conn.prepareStatement("insert into clientes " 
                    + "(nome, telefone, cnpj, endereco, dataCadastro) " 
                    + "values(?,?,?,?,?)");
                    
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getTelefone());
            stmt.setString(3, obj.getCNPJ());
            stmt.setString(4, obj.getEndereco());
            stmt.setDate(5, new Date(obj.getDataCadastro().getTime()));
            
            //TESTE SE LINHA ALTERADA FOR MAIOR QUE 0
            int rowsAffected = stmt.executeUpdate();
            if(rowsAffected > 0){
                rs = stmt.getGeneratedKeys();
                if(rs.next()){
                    int id = rs.getInt(1);
                    obj.setIdClientes(id);
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
    public void update(Clientes obj) {
        try{
        stmt = conn.prepareStatement("update clientes set "
                + "nome=?, telefone=?, cnpj=?, endereco=?, dataCad=? "
                + "where idCliente=?");
        
            stmt.setString(1, obj.getNome());
            stmt.setString(2,obj.getTelefone());
            stmt.setString(3, obj.getCNPJ());
            stmt.setString(4, obj.getEndereco());
            stmt.setDate(5, new Date(obj.getDataCadastro().getTime()));
            stmt.setInt(6, obj.getIdClientes());
            
            stmt.executeUpdate();
            
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            DB.closeStatement(stmt);
        }
    }

    @Override
    public void deleteByid(Clientes obj) {
        try{
        stmt = conn.prepareStatement("delete from clientes where idFunc = ?");
        
            stmt.setInt(1, obj.getIdClientes());
            stmt.executeUpdate();
            
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally{
            DB.closeStatement(stmt);
        }
    }

    @Override
    public Clientes findByid(Integer id) {
        try{
            stmt = conn.prepareStatement(
                    "select nome from clientes "
                    + "where clientes.id = ?");
            
            stmt.setInt(1, id);
            rs = stmt.executeQuery();
            if(rs.next()){
                Clientes cl = new Clientes();
                cl.setIdClientes(id);
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
    public List<Clientes> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
