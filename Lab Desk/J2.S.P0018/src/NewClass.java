/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class NewClass {
    public static void main(String[] args) {
        ServerRMI s= new ServerRMI();
        s.setVisible(true);
        Client c= new Client();
        c.setVisible(true);
    }
}
