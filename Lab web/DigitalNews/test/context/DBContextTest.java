/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package context;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class DBContextTest {
    DBContext db;
    public DBContextTest() {
        db= new DBContext();
    }

    @Test
    public void testGetConnection() throws Exception {
        db.getConnection();
    }

    @Test
    public void testMain() {
        
    }
    
}
