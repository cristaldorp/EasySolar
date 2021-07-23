/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dao;

import java.util.List;
import model.entidades.Funcionarios;

/**
 *
 * @author Usuario
 */
public interface FuncionarioDao {
    void insert(Funcionarios obj);
    void update(Funcionarios obj);
    void deleteByid(Funcionarios obj);
    Funcionarios findByid(Integer id);
    List<Funcionarios> findAll();
}
