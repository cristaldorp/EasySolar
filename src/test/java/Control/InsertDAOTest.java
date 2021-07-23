/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import model.entidades.Funcionarios;
import conexão.DB;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.function.BooleanSupplier;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author rafae
 */
public class InsertDAOTest {
    
    public InsertDAOTest() {
    }
    
    @Test
    public void TestInsert() throws SQLException{
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        
        Funcionarios f = new Funcionarios();
        
        f.setNome("Rafael");
        f.setTelefone("679999999");
        f.setCPF("000000");
        f.setEndereco("RUA");
        f.setDataCadastro("31/05/2021");
        
        InsertDAO dao = new InsertDAO();
        dao.addFuncionario(f);
        
        assertTrue(dao.addFuncionario(f));
    }
   
    
}
