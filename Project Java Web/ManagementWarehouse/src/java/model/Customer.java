/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Customer {

    private int id;
    private String name;
    private String phone;
    private String address;
    private int isFarmer;
    private ArrayList<Bill> bill;

    public Customer() {
    }

    public Customer(int id, String name, String phone, String address, int isFarmer, ArrayList<Bill> bill) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.isFarmer = isFarmer;
        this.bill = bill;
    }

    public String getStatus() {
        String s = "Khách bán";
        if (isFarmer == 1) {
            s = "Khách mua";
        }
        return s;
    }

    public int getInt() {
        return isFarmer;
    }

    public int isIsFarmer() {
        return isFarmer;
    }

    public void setIsFarmer(int isFarmer) {
        this.isFarmer = isFarmer;
    }

    public ArrayList<Bill> getBill() {
        return bill;
    }

    public void setBill(ArrayList<Bill> bill) {
        this.bill = bill;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
