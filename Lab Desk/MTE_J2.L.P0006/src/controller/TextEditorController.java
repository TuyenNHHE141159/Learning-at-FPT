/**
 *Title:             My text editor
 * Files:            TextEditorController.java
 * Semester:         LAB Desk Summer- Block 5 2021
 * Author:           TuyenNH
 * Email:            tuyennhhe141159@fpt.edu.vn
 * CS Login:         User
 * Lecturer's Name:  DuongTB
 * Lab Section:      4
 */
package controller;

import java.awt.GraphicsEnvironment;
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
public class TextEditorController {

    /**
     * Function: get all Font name
     *
     * @return a string array of font name
     */
    public String[] getFontFamily() {
        String[] fontFamily = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        return fontFamily;
    }

    /**
     * Read content from txt file
     *
     * @param url
     * @return
     */
    public String readFile(String url) {
        try {
            String content = "";
            File file = new File(url);
            FileReader reader = null;
            reader = new FileReader(file);
            BufferedReader buffer = new BufferedReader(reader);
            try {
                //read each line
                String line = buffer.readLine();
                while (line != null) {
                    content += line + "\n";
                    line = buffer.readLine();

                }
                return content;
            } catch (IOException ex) {
                Logger.getLogger(TextEditorController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(TextEditorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Write content to file
     *
     * @param url type:String
     * @param content type:String
     */
    public void writeFile(String url, String content) {
        try {
            try (FileWriter change = new FileWriter(url)) {
                change.write(content);
            }
        } catch (IOException ex) {
            Logger.getLogger(TextEditorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
