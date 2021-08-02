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
import modal.News;

/**
 *
 * @author User
 */
public class NewsDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    /**
     * get last news
     *
     * @return
     */
    public News getLastNews() {
        String query = "select top 1* from news1 order by timePost desc";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new News(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getString("writter"),
                        rs.getDate("timePost"),
                        rs.getString("summary"),
                        rs.getString("imageLink"));
            }
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * get top 5 last news
     *
     * @return
     */
    public ArrayList<News> getTop5() {
        ArrayList<News> list = new ArrayList<>();
        String query = "select top 5 * from news1 where id!= (select top 1 id from news1 order by timePost desc)order by timePost desc";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new News(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getString("writter"),
                        rs.getDate("timePost"),
                        rs.getString("summary"),
                        rs.getString("imageLink")));
            }
        } catch (Exception e) {

        }
        return list;
    }

    /**
     * get news by newsId
     *
     * @param id
     * @return
     */
    public News getNewsByID(int id) {
        String query = "select  * from news1 where id=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new News(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getString("writter"),
                        rs.getDate("timePost"),
                        rs.getString("summary"),
                        rs.getString("imageLink"));
            }
        } catch (Exception e) {

        }
        return null;
    }

    /**
     * search paging
     *
     * @param index
     * @param size
     * @param txt
     * @return
     */
    public ArrayList<News> searchByPaging(int index, int size, String txt) {
        ArrayList<News> list = new ArrayList<>();
        String query = "select * from news1 \n"
                + "where title like '%'+?+'%'\n"
                + "order by id \n"
                + "OFFSET ? ROWS FETCH NEXT ? ROWS ONLY";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, txt);
            ps.setInt(2, size * (index - 1));
            ps.setInt(3, size);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new News(rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getString("writter"),
                        rs.getDate("timePost"),
                        rs.getString("summary"),
                        rs.getString("imageLink")));
            }
        } catch (Exception e) {

        }
        return list;
    }

    /**
     * count result search
     *
     * @param txt
     * @return
     */
    public int countSearch(String txt) {

        String query = "select count(*) as amount from news1 where title like '%'+?+'%'";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, txt);
            rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt("amount");
            }
        } catch (Exception e) {

        }
        return 0;
    }

    public static void main(String[] args) {
        NewsDAO dao = new NewsDAO();
//        ArrayList<News> top5 = dao.getTop5();
        String txt = "a";
        ArrayList<News> listS = dao.searchByPaging(0, 3, txt);
        int countSearch = dao.countSearch("a");
        News n = dao.getLastNews();
        for (News o : listS) {
            String title = o.getTitle();
            System.out.println(title);

        }
        System.out.println(countSearch);

    }
}
