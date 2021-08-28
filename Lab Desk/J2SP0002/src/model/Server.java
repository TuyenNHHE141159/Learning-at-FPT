/**
 *Title:          Networking – sending files
 * Files:            Server.java
 * Semester:         LAB Desk Summer- Block 5 2021
 * Author:           TuyenNH
 * Email:            tuyennhhe141159@fpt.edu.vn
 * CS Login:         User
 * Lecturer's Name:  DuongTB
 * Lab Section:      4
 */
package model;

import controller.NetWorkingController;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import view.ServerFrame;

/**
 *
 * @author User
 */
public class Server extends Thread {

    private final ServerSocket server;
    JTextField txtUrl;
    JTextArea txtMessage;
    NetWorkingController controller = new NetWorkingController();
    ServerFrame frame = new ServerFrame();

    public Server(ServerSocket server, JTextField txtUrl, JTextArea txtMessage) {
        this.txtUrl = txtUrl;
        this.server = server;
        this.txtMessage = txtMessage;
    }

    @Override
    public void run() {

        while (true) {
            try {
                Socket socket = server.accept();
                System.out.println("Socket info {" + socket.getInetAddress()
                        + ":" + socket.getPort() + "}");
                InputStream is = socket.getInputStream();
                byte[] data = new byte[1024];            
                    if (data != null) {
                        is.read(data);
                        String message = new String(data);
                        System.out.println("{" + Arrays.toString(socket.getInetAddress().getAddress())
                                + ":" + socket.getPort() + "}:" + message);
                        
                        this.txtUrl.setText(message.trim());
                        try {
                              this.txtMessage.setText(controller.readFile(message.trim()));
                        } catch (Exception e) {
                          JOptionPane.showMessageDialog(new ServerFrame(), "Error path");
                        }                    
                    }
              
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
