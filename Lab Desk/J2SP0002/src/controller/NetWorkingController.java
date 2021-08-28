/**
 *Title:          Networking – sending files
Files:            NetWorkingController.java
Semester:         LAB Desk Summer- Block 5 2021
Author:           TuyenNH
Email:            tuyennhhe141159@fpt.edu.vn
CS Login:         User
Lecturer's Name:  DuongTB
Lab Section:      4
 */
package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class NetWorkingController {

    /**
     * Read content from txt file
     *
     * @param url
     * @return
     */
    public String readFile(String url) {
        String content = "";
        try {
            FileReader reader = null;
            File f = new File(url);
            reader = new FileReader(f);
            BufferedReader buffer = new BufferedReader(reader);
            //read each line in content file
            try {
                String line = buffer.readLine();
                while (line != null) {
                    System.out.println(line);
                    content += line + "\n";
                    line = buffer.readLine();
                }
                return content;
            } catch (IOException ex) {
                
            }
        } catch (FileNotFoundException ex) {
           
        }
        return null;
    }

    /**
     * Update content file
     *
     * @param url type:String
     * @param contenChange type:String
     */
    public void updateFile(String url, String contenChange) {
        try {
            try (FileWriter change = new FileWriter(url)) {
                change.write(contenChange);
            }
        } catch (IOException ex) {
            Logger.getLogger(NetWorkingController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
