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
import model.Department;
import model.Flower;

/**
 *
 * @author User
 */
public class DepartmentDAO extends DBContext{
      Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<Department> getAllFlowers() {
        ArrayList<Department> list = new ArrayList<>();
        String query = "select * from department";
        try {
            //mo ket noi voi sql server
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Department(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
        }
        return list;

    }
    public static void main(String[] args) {
        DepartmentDAO db= new DepartmentDAO();
        System.out.println(db.getAllFlowers());
    }
}
