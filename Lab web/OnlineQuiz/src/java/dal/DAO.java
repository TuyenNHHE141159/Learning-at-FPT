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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import modal.Quiz;
import modal.User;
import security.Security;

/**
 *
 * @author User
 */
public class DAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    /**
     *
     * @param user
     * @param pass
     * @return
     */
    public User login(String user, String pass) {

        String query = "select * from [user] where [user_name] = ? and [password]= ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5), rs.getString(6));
            }
        } catch (Exception e) {

        }
        return null;
    }

    /**
     *
     * @param user
     * @return
     */
    public boolean checkExist(String user) {

        String query = "select * from [user] where [user_name] = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {

        }
        return false;
    }

    public void register(String user, String pass, int role, String createdDate, String email) {

        String query = "insert into [user]\n"
                + "values(N'" + user + "',N'" + pass + "'," + role + ",'" + createdDate + "',N'" + email + "')";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    /**
     *
     * @param question
     * @param option1
     * @param option2
     * @param option3
     * @param option4
     * @param answer
     * @param date
     * @param userId
     */
    public void makeQuiz(String question, String option1, String option2, String option3,
            String option4, String answer, String date, int userId) {

        String query = "insert into question \n"
                + "values(N'" + question + "',N'" + option1 + "',N'" + option2 + "',N'" + option3 + "',N'" + option4 + "','" + answer + "','" + date + "'," + userId + ")";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    /**
     *
     * @param number
     * @return
     */
    public ArrayList<Quiz> getListQuiz(int number) {

        String query = "Select top " + number + " * from question order by newid()";
        ArrayList<Quiz> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Quiz(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9)));
            }
        } catch (Exception e) {

        }
        return list;
    }

    /**
     *
     * @param userId
     * @return
     */
    public ArrayList<Quiz> getListByUser(int userId) {

        String query = "select * from question where user_id=?";
        ArrayList<Quiz> list = new ArrayList<>();
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(query);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            while (rs.next()) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
                list.add(new Quiz(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        sdf.format(rs.getDate(8)),
                        rs.getInt(9)));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public static void main(String[] args) {
        DAO dao = new DAO();
        Security s = new Security();
        User u = dao.login("duongtb", "");
    }
}
