/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import context.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modal.Contact;
import modal.Gallery;
import modal.Image;
import modal.Share;

/**
 *
 * @author User
 */
public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    /**
     * get information of social
     *
     * @return
     */
    public ArrayList<Share> getShare() {
        ArrayList<Share> list = new ArrayList<>();
        String query = "select * from share";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Share(rs.getString("icon"),
                        rs.getString("socialNetwork"),
                        rs.getString("url")));
            }
        } catch (Exception e) {
        }
        return list;
    }

    /**
     * get top 3 first Gallery
     *
     * @return
     */
    public ArrayList<Gallery> getTop3() {
        ArrayList<Gallery> list = new ArrayList<>();
        String query = "select top 3 * from gallery order by id asc";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Gallery(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("name")));
            }
        } catch (Exception e) {
        }
        return list;
    }

    /**
     * get information of contact
     *
     * @return
     */
    public Contact getContact() {
        String query = "select * from contact";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Contact(rs.getString("telephone"),
                        rs.getString("email"),
                        rs.getString("about"),
                        rs.getString("address"),
                        rs.getString("city"),
                        rs.getString("country"),
                        rs.getString("map_url"),
                        rs.getString("image_main"));
            }
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * paging gallery
     *
     * @param index
     * @param size
     * @return
     */
    public ArrayList<Gallery> pagingGallery(int index, int size) {
        ArrayList<Gallery> list = new ArrayList<>();
        String query = "select * from gallery\n"
                + "ORDER BY id OFFSET ? ROWS\n"
                + "FETCH NEXT ? ROWS ONLY";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, (index - 1) * size);
            ps.setInt(2, size);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Gallery(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("name")));
            }
        } catch (Exception e) {
        }
        return list;
    }

    /**
     * count number of gallery
     *
     * @return
     */
    public int countGallery() {
        String query = "select count(*) as amount from gallery";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt("amount");
            }
        } catch (Exception e) {
        }
        return 0;
    }

    /**
     * count number of image for gallery
     *
     * @param id
     * @return
     */
    public int countImage(int id) {
        String query = "select count(*) as amount from [image]\n"
                + " where gallery_id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt("amount");
            }
        } catch (Exception e) {
        }
        return 0;
    }

    /**
     * get top 1 image of gallery
     *
     * @param gid
     * @return
     */
    public Image top1ImageOfGallery(int gid) {
        String query = "select top 1 * from image\n"
                + "where gallery_id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, gid);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Image(rs.getInt("id"),
                        rs.getString("image_url"));
            }
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * get gallery by galleryID
     *
     * @param id
     * @return
     */
    public Gallery getGalleryByID(int id) {
        String query = "select * from gallery where id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Gallery(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("description"),
                        rs.getString("name"));
            }
        } catch (Exception e) {

        }
        return null;
    }

    /**
     *
     * @param id
     * @return
     */
    public Image getImageByID(int id) {
        String query = "select * from image where id = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Image(rs.getInt("id"), rs.getString("image_url"),rs.getInt("gallery_id"));
            }
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * paging image of gallery
     *
     * @param id
     * @param index
     * @param size
     * @return
     */
    public ArrayList<Image> getPaging(int id, int index, int size) {
        ArrayList<Image> list = new ArrayList<>();
        String query = "select * from [image]\n"
                + " where gallery_id = ?\n"
                + " ORDER BY id OFFSET ? ROWS\n"
                + " FETCH NEXT ? ROWS ONLY";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.setInt(2, (index - 1) * size);
            ps.setInt(3, size);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Image(rs.getInt("id"), rs.getString("image_url")));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public static void main(String[] args) {
        try {
            DAO dao = new DAO();
            ArrayList<Share> listS = dao.getShare();
            ArrayList<Gallery> listG = dao.getTop3();
            Contact contact = dao.getContact();
            Gallery g = dao.getGalleryByID(1);
            ArrayList<Image> listImage = dao.getPaging(2, 1, 8);
            System.out.println(contact);
        } catch (Exception ex) {

        }
    }
}
