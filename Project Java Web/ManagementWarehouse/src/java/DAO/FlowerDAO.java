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

/**
 *
 * @author User
 */
public class FlowerDAO extends DBContext {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public ArrayList<Flower> getAllFlowers() {
        ArrayList<Flower> list = new ArrayList<>();
        String query = "select * from flower order by name";
        try {
            //mo ket noi voi sql server
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Flower(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5)));
            }
        } catch (Exception e) {
        }
        return list;

    }

    public Flower getFlowerById(int id) {

        String query = "select * from flower where id=?";
        try {
            //mo ket noi voi sql server
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Flower(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getInt(5));
            }
        } catch (Exception e) {
        }
        return null;

    }

    public void updateQuantity(int quantity, int fid) {
        String query = "UPDATE [Flower]\n"
                + "   SET \n"
                + "      [quantity] =?\n"
                + " WHERE id=?";
        try {
            //mo ket noi voi sql server
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, quantity);
            ps.setInt(2, fid);
            ps.executeUpdate();

        } catch (Exception e) {
        }
    }

    public static void main(String[] args) {
        FlowerDAO db = new FlowerDAO();
        ArrayList<Flower> f = db.getAllFlowers();
//        for (Flower flower : f) {
//            System.out.println(flower);
//        }
        Flower ff = db.getFlowerById(1);
        System.out.println(ff);
    }
}
