/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import view.ClientFrame;
import view.ServerFrame;

/**
 *
 * @author User
 */
public class Main {

    /**
     * Main function run programing
     *
     * @param args
     */
    public static void main(String[] args) {
        ClientFrame c = new ClientFrame();
        c.setVisible(true);
        ServerFrame s = new ServerFrame();
        s.setVisible(true);
    }
}
