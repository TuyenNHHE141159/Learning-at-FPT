/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import controller.TextEditorController;

/**
 *
 * @author User
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.home"));
        TextEditorController controller= new TextEditorController();
        System.out.println(controller.readFile("C:\\Users\\User\\OneDrive\\Desktop\\Note Coding\\aa.txt"));
    }
}
