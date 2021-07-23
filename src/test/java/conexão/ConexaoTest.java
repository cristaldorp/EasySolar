/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexão;

import java.sql.Connection;
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
public class ConexaoTest {
    
    public ConexaoTest() {
    }
    
    @Test
    public void testConexao(){
        Conexao c = new Conexao();
        assertNotEquals(c.getConection(), new RuntimeException());
    }
    
    
}
