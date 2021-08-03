/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import context.DBContext1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Feature;
import model.Group;

/**
 *
 * @author User
 */
public class AccountDAO extends DBContext1{

    

    public Account login(String accountid, String password) {

        String sql = "SELECT a.accid,a.pass,g.id,g.name,f.url,f.fid FROM Account a\n"
                + "                    LEFT JOIN GroupAccount ag ON a.accid = ag.[accid]\n"
                + "                     LEFT JOIN [Group] g ON g.id = ag.gid\n"
                + "                   LEFT JOIN [FeatureGroup] fg ON fg.gid = g.id\n"
                + "                    LEFT JOIN Feature f ON f.fid = fg.fid\n"
                + "                   WHERE \n"
                + "                   a.username = ? AND a.pass = ?";
            PreparedStatement statment;
        try {
             statment = connection.prepareStatement(sql);
           
            statment.setString(1, accountid);
            statment.setString(2, password);

            Account account = null;
            Group current = new Group();
            current.setId(-1);
            ResultSet rs = statment.executeQuery();
            while (rs.next()) {
                if (account == null) {
                    account = new Account();
                    account.setUsername(accountid);
                    account.setPassword(password);
                }

                int gid = rs.getInt("id");
                if (current.getId() != gid) {
                    current = new Group();
                    current.setId(gid);
                    current.setName(rs.getString("name"));
                    account.getGroups().add(current);
                }

                Feature f = new Feature();
                f.setId(rs.getInt("fid"));
                f.setUrl(rs.getString("url"));
                current.getFeatures().add(f);
                return account;
            }
        } catch (Exception ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    public static void main(String[] args) {
        AccountDAO db = new AccountDAO();
        System.out.println(db.login("tuyen", "123"));
    }
}
