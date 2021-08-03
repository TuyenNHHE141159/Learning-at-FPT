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
import model.BillReportPaid;
import model.Department;

/**
 *
 * @author User
 */
public class BillReportDAO extends DBContext{
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
     public ArrayList<BillReportPaid> getBillNotPaid(int status) {
        ArrayList<BillReportPaid> list = new ArrayList<>();
        String query = "select * from bill b inner join Customer c on b.customerID=c.id where [status]=0 and c.isfarmer=?";
        try {
            //mo ket noi voi sql server
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, status);
            rs = ps.executeQuery();
            while (rs.next()) {
               list.add(new BillReportPaid(rs.getInt(1), rs.getDate(2),
                       rs.getInt(4), rs.getInt(5), rs.getString(9), rs.getString(10),
                       rs.getString(11), rs.getInt(12)));
            }
        } catch (Exception e) {
        }
        return list;

    }
    public static void main(String[] args) {
        BillReportDAO db= new BillReportDAO();
        ArrayList<BillReportPaid> br= db.getBillNotPaid(0);
        System.out.println(br);
    }
}
