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
import model.Bill;
import model.Customer;

/**
 *
 * @author User
 */
public class CustomerDAO extends DBContext {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<Customer> getAllCustomer() {
        ArrayList<Customer> list = new ArrayList<>();
        String query = "select * from customer";
        try {
            //mo ket noi voi sql server
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                BillDAO dbb = new BillDAO();
                ArrayList<Bill> d = dbb.getBillofCustomerById(rs.getInt(1));
                list.add(new Customer(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getInt(5), d));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public ArrayList<Customer> getCusByStatus(int status) {
        ArrayList<Customer> list = new ArrayList<>();
        String query = "select * from customer where isfarmer=?";
        try {
            //mo ket noi voi sql server
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, status);
            rs = ps.executeQuery();
            while (rs.next()) {
                BillDAO dbb = new BillDAO();
                ArrayList<Bill> d = dbb.getBillofCustomerById(rs.getInt(1));
                list.add(new Customer(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getInt(5), d));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public int countCustomer(int status) {
        String query = "select count(*) from Customer where isfarmer=?";
        try {
            //mo ket noi voi sql server
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, status);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public ArrayList<Customer> pagingCusByStatus(int status) {
        ArrayList<Customer> list = new ArrayList<>();
        String query = "select * from Customer where isfarmer=? order by id\n"
                + "offset ? rows fetch next 3 rows only ";
        try {
            //mo ket noi voi sql server
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, status);
            ps.setInt(2, countCustomer(status));
            rs = ps.executeQuery();
            while (rs.next()) {
                BillDAO dbb = new BillDAO();
                ArrayList<Bill> d = dbb.getBillofCustomerById(rs.getInt(1));
                list.add(new Customer(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getInt(5), d));
            }
        } catch (Exception e) {
        }
        return list;
    }
  public ArrayList<Customer> paging(int index, String txt) {
        ArrayList<Customer> list = new ArrayList<>();
        String query = "select * from Customer where [name] like '%'+?+'%' order by id\n"
                + "offset ? rows fetch next 3 rows only ";
        try {
            //mo ket noi voi sql server
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, txt);
            ps.setInt(2, (index-1)*3);
            rs = ps.executeQuery();
            while (rs.next()) {
                BillDAO dbb = new BillDAO();
                ArrayList<Bill> d = dbb.getBillofCustomerById(rs.getInt(1));
                list.add(new Customer(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getInt(5), d));
            }
        } catch (Exception e) {
        }
        return list;
    }
   public int count(String txt) {
        int count=0;
        String query = "select count(*) from Customer where [name] like '%'+?+'%'";
        try {
            //mo ket noi voi sql server
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, txt);
            rs = ps.executeQuery();
            while (rs.next()) {
                count= rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return count;
    }
    public Customer getCusById(int id) {

        String query = "select * from customer where id=?";
        try {
            //mo ket noi voi sql server
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                BillDAO dbb = new BillDAO();
                ArrayList<Bill> d = dbb.getBillofCustomerById(rs.getInt(1));
                return new Customer(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getInt(5), d);
            }
        } catch (Exception e) {
        }
        return null;
    }

    public String getNameOfCus(int id) {
        String query = "select name from customer where id=?";
        String name = "";
        try {
            //mo ket noi voi sql server
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                name = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return name;
    }

    public ArrayList<Customer> getCusByName(String name) {
        ArrayList<Customer> list = new ArrayList<>();
        String query = "select * from Customer where [name] like N'%'+?+'%'";
        try {
            //mo ket noi voi sql server
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {
                BillDAO dbb = new BillDAO();
                ArrayList<Bill> d = dbb.getBillofCustomerById(rs.getInt(1));
                list.add(new Customer(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getInt(5), d));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void addCustomer(Customer c) {

        String query = "INSERT INTO [Customer]\n"
                + "           ([name]\n"
                + "           ,[phone]\n"
                + "           ,[address]\n"
                + "           ,[isfarmer])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            //mo ket noi voi sql server
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, c.getName());
            ps.setString(2, c.getPhone());
            ps.setString(3, c.getAddress());
            ps.setInt(4, c.isIsFarmer());
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        CustomerDAO db = new CustomerDAO();
        ArrayList<Customer> c = db.getCusByStatus(0);
//        System.out.println(c);
//        ArrayList<Customer> cc = db.getCusByName("an");
//        System.out.println(cc);
//        System.out.println(db.getNameOfCus(1));
        System.out.println(db.countCustomer(0));
    }
}
