/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Flower;
import model.Warehouse;

/**
 *
 * @author User
 */
public class WarehouseDAO extends DBContext {
    
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public ArrayList<Warehouse> getAllWarehouse(int status, String name) {
        ArrayList<Warehouse> list = new ArrayList<>();
        String query = "select f.[name],sum(bl.quantity) as mua from BillLine bl\n"
                + "inner join Flower f on bl.flowerID=f.id \n"
                + "inner join Bill b on b.id=bl.billID\n"
                + "inner join Customer c on c.id=b.customerID\n"
                + "where  c.isfarmer=? and f.[name] like  N'%'+?+'%'\n"
                + "group by f.[name]";
        try {
            //mo ket noi voi sql server
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, status);
            ps.setString(2, name);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Warehouse(rs.getString(1), rs.getInt(2)));
            }
        } catch (Exception e) {
        }
        return list;
        
    }
    
    public static void main(String[] args) {
        WarehouseDAO db = new WarehouseDAO();
        System.out.println(db.getAllWarehouse(1,""));
    }
}
