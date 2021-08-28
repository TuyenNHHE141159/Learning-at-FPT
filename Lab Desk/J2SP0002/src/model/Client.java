/**
 *Title:          Networking – sending files
 * Files:            Client.java
 * Semester:         LAB Desk Summer- Block 5 2021
 * Author:           TuyenNH
 * Email:            tuyennhhe141159@fpt.edu.vn
 * CS Login:         User
 * Lecturer's Name:  DuongTB
 * Lab Section:      4
 */
package model;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class Client extends Thread {

    private Socket client;
    private String data;

    public Client(Socket client, String data) {
        this.data = data;
        this.client = client;
    }

    @Override
    public void run() {
        try {
            //check file text or not
            if (!data.endsWith(".txt")) {
                System.out.println("Wrong path");
                JOptionPane.showMessageDialog(new view.ClientFrame(), "Wrong path");
            }

            //Create object OutputStream to send data to server
            OutputStream os = client.getOutputStream();

            // send data as bytes
            os.write(data.getBytes());
            System.out.println(client.getLocalPort());
            System.out.println("data send :" + data);
            client.close();
        } catch (IOException ex) {
            System.out.println("Wrong path");
        }
    }

}
