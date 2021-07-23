/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dao;

import java.util.List;
import model.entidades.Clientes;

/**
 *
 * @author Usuario
 */
public interface ClientesDAO {
    void insert(Clientes obj);
    void update(Clientes obj);
    void deleteByid(Clientes obj);
    Clientes findByid(Integer id);
    List<Clientes> findAll();
}
