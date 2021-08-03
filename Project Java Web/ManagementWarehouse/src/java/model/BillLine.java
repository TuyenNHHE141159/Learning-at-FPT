/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author User
 */
public class BillLine {

    private int billid;
    private Flower flower;
    private int quantity;
    private float price;

    public BillLine(int billid, Flower flower, int quantity, float price) {
        this.billid = billid;
        this.flower = flower;
        this.quantity = quantity;
        this.price = price;
    }

    public int getBillid() {
        return billid;
    }

    public void setBillid(int billid) {
        this.billid = billid;
    }

    public BillLine() {
    }

    

    public float getTotal() {
        return quantity * price;
    }

    

    public Flower getFlower() {
        return flower;
    }

    public void setFlower(Flower flower) {
        this.flower = flower;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
