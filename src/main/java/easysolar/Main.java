/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easysolar;

import Control.InsertDAO;
import Model.Funcionarios;
import conexão.Conexao;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 *
 * @author rafae
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Conexao c = new Conexao();
        
        c.getConection();
        
    }
    
}
