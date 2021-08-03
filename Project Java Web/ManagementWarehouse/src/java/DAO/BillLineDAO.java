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
import model.BillLine;
import model.Flower;

/**
 *
 * @author User
 */
public class BillLineDAO extends DBContext {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<BillLine> getBillLineByBill(int id) {
        ArrayList<BillLine> list = new ArrayList<>();
        String query = "select * from billline where billid=?";
        try {
            //mo ket noi voi sql server
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {

                FlowerDAO dbf = new FlowerDAO();
                Flower f = dbf.getFlowerById(rs.getInt(2));
                list.add(new BillLine(rs.getInt(1), f, rs.getInt(3), rs.getFloat(4)));

            }
        } catch (Exception e) {
        }
        return list;

    }

    public void deleteBillLine(int bid, int fid) {
        String query = "DELETE FROM [BillLine]\n"
                + "      WHERE billID=? and flowerID=? ";
        try {
            //mo ket noi voi sql server
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, bid);
            ps.setInt(2, fid);

            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public void addBillLine(BillLine b) {
        String query = "INSERT INTO [BillLine]\n"
                + "           ([billID]\n"
                + "           ,[flowerID]\n"
                + "           ,[quantity]\n"
                + "           ,[price])\n"
                + "     VALUES\n"
                + "           (?\n"
                + "           ,?\n"
                + "           ,?\n"
                + "           ,?)";
        try {
            //mo ket noi voi sql server
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, b.getBillid());
            ps.setInt(2, b.getFlower().getId());
            ps.setInt(3, b.getQuantity());
            ps.setFloat(4, b.getPrice());
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        BillLineDAO db = new BillLineDAO();
        ArrayList<BillLine> dlbl = db.getBillLineByBill(1);
        System.out.println(dlbl);
        FlowerDAO dbf = new FlowerDAO();
        Flower f = dbf.getFlowerById(2);
        BillLine bl = new BillLine(3, f, 500, 100);

        db.addBillLine(bl);
    }
}
