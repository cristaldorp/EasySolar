/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.dao;

import Model.dao.impl.FuncionarioDaoJDBC;

/**
 *
 * @author Usuario
 */
public class DaoFactory {
    
    public static FuncionarioDao createFunDAO(){
        return new FuncionarioDaoJDBC();
    }
}
