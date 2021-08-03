/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package context;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBContext1 {

    public Connection connection;

    public  DBContext1() {
        try {
            //Change the username password and url to connect your own database
            String username = "sa";
            String password = "123";
            String url = "jdbc:sqlserver://DESKTOP-GDRTE52:1433;databaseName=FlowerTayTuu";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, username, password);
//            DatabaseMetaData db= connection.getMetaData();
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBContext1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        String sql="Select Table_name from FlowerTayTuu";
        PreparedStatement statment;
        DBContext1 db= new DBContext1();
        //            System.out.println(dt.get);
        
        try {
//                System.out.println(new DBContext1().connection);
        } catch (Exception e) {
        }
    }

}
