/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import context.DBContext;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import model.Bill;
import model.BillLine;
import model.Customer;

/**
 *
 * @author User
 */
public class BillDAO  {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

     public ArrayList<Bill> getBillHousePaging(int status,  int index) {
        ArrayList<Bill> list = new ArrayList<>();
        String query = "select * from bill where [status]=?  order by [date] desc offset ? rows fetch next 3 rows only";
        try {
            //mo ket noi voi sql server
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, status);
          
             ps.setInt(2, (index - 1) * 3);
            rs = ps.executeQuery();
            while (rs.next()) {
                BillLineDAO db = new BillLineDAO();
                ArrayList<BillLine> bl = db.getBillLineByBill(rs.getInt(1));

                list.add(new Bill(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getInt(4), rs.getInt(5), bl));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
       public int countBillHouse( int status) {
        String query = "select count(*) from bill where [status]=? ";
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
     
    public ArrayList<Bill> getBillofCustomerById(int id) {
        ArrayList<Bill> list = new ArrayList<>();
        String query = "select * from bill where customerID=? order by date desc";
        try {
            //mo ket noi voi sql server
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                BillLineDAO db = new BillLineDAO();
                ArrayList<BillLine> bl = db.getBillLineByBill(rs.getInt(1));

                list.add(new Bill(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getInt(4), rs.getInt(5), bl));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
      public ArrayList<Bill> getBillByStatus(int status) {
        ArrayList<Bill> list = new ArrayList<>();
        String query = "select * from bill b inner join customer c on c.id=b.customerID where c.isfarmer=? order by b.[date] desc ";
        try {
            //mo ket noi voi sql server
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, status);
          
            rs = ps.executeQuery();
            while (rs.next()) {
                BillLineDAO db = new BillLineDAO();
                ArrayList<BillLine> bl = db.getBillLineByBill(rs.getInt(1));

                list.add(new Bill(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getInt(4), rs.getInt(5), bl,rs.getDouble(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }
    
  public ArrayList<Bill> getBillByStatusPaging(int status,int index) {
        ArrayList<Bill> list = new ArrayList<>();
        String query = "select * from bill b inner join customer c on c.id=b.customerID where c.isfarmer=? order by b.[date] desc offset ? rows fetch next 3 rows only";
        try {
            //mo ket noi voi sql server
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, status);
             ps.setInt(2, (index - 1) * 3);
            rs = ps.executeQuery();
            while (rs.next()) {
                BillLineDAO db = new BillLineDAO();
                ArrayList<BillLine> bl = db.getBillLineByBill(rs.getInt(1));

                list.add(new Bill(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getInt(4), rs.getInt(5), bl,rs.getDouble(6)));
            }
        } catch (Exception e) {
        }
        return list;
    }
   public int countBill(int id) {
        String query = "select count(*) from bill b inner join customer c on c.id=b.customerID where c.isfarmer=?";
        try {
            //mo ket noi voi sql server
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }
    public ArrayList<Bill> pagingBillofCustomer(int id, int index) {
        ArrayList<Bill> list = new ArrayList<>();
        String query = "select * from bill where customerID=? order by date desc\n"
                + "offset ? rows fetch next 3 rows only";
        try {
            //mo ket noi voi sql server
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.setInt(2, (index - 1) * 3);
            rs = ps.executeQuery();
            while (rs.next()) {
                BillLineDAO db = new BillLineDAO();
                ArrayList<BillLine> bl = db.getBillLineByBill(rs.getInt(1));

                list.add(new Bill(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getInt(4), rs.getInt(5), bl));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public int countBillOfCustomer(int id) {
        String query = "select count(*) from bill where customerID=?";
        try {
            //mo ket noi voi sql server
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return 0;
    }

    public Bill getBillofCustomerByBillId(int id) {

        String query = "select * from bill where id=?";
        try {
            //mo ket noi voi sql server
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                BillLineDAO db = new BillLineDAO();
                ArrayList<BillLine> bl = db.getBillLineByBill(rs.getInt(1));

                return new Bill(rs.getInt(1), rs.getDate(2), rs.getString(3), rs.getInt(4), rs.getInt(5), bl,rs.getDouble(6));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public int getCusId(int billId) {
        int id = 0;
        String query = "select customerid from bill where id=?";
        try {
            //mo ket noi voi sql server
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, billId);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (Exception e) {
        }
        return id;
    }

    public void addBill(Bill b) {

        String query = "INSERT INTO [Bill]\n"
                + "           ([date]\n"
                + "           ,[paymentmethod]\n"
                + "           ,[customerID]\n"
                + "           ,[status])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            //mo ket noi voi sql server
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setDate(1, b.getDate());
            ps.setString(2, b.getPaymentMethod());
            ps.setInt(3, b.getCustomerId());
            ps.setInt(4, b.isPaid());
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public void pay(int bid, int status,double money,String date) {
        String query = "UPDATE [Bill]\n"
                + "   SET\n"
                + " [status] = ? ,[paidMoney] = ?\n"
                + " ,[paidDate] = ?\n"
                + " WHERE id=?";
        try {
            //mo ket noi voi sql server
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, status);
            ps.setInt(4, bid);
            ps.setDouble(2, money);
            ps.setString(3, date);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        BillDAO db = new BillDAO();
        ArrayList<Bill> b = db.getBillofCustomerById(1);
//        for (Bill bill : b) {
//            System.out.println(bill.getId());
//        }
        Bill bb = new Bill();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//        Date date = new Date(System.currentTimeMillis());
//        String dc = formatter.format(date);
//        Date ddd = Date.valueOf(dc);
//        bb.setDate(ddd);
//        bb.setCustomerId(1);
//        bb.setPaid(false);
//        bb.setPaymentMethod("cash");
//
//        db.addBill(bb);
        bb = db.getBillofCustomerByBillId(4);
//        db.pay(4, 1);
    }
}
