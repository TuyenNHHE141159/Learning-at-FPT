/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Bill {

    private int id;

    private Date date;

    private String paymentMethod;
    private int customerId;
    private int paid;
    private ArrayList<BillLine> lines;
    private double paidMoney;

    public double getPaidMoney() {
        return paidMoney;
    }

    public Bill(int id, Date date, String paymentMethod, int customerId, int paid, ArrayList<BillLine> lines, double paidMoney) {
        this.id = id;
        this.date = date;
        this.paymentMethod = paymentMethod;
        this.customerId = customerId;
        this.paid = paid;
        this.lines = lines;
        this.paidMoney = paidMoney;
    }

    public void setPaidMoney(double paidMoney) {
        this.paidMoney = paidMoney;
    }

    public float getMoney() {
        float sum = 0;
        for (BillLine line : lines) {
            sum += line.getTotal();
        }
        return sum;
    }

    @Override
    public String toString() {
        return "Bill{" + "id=" + id + ", date=" + date + ", paymentMethod=" + paymentMethod + ", customerId=" + customerId + ", paid=" + paid + ", lines=" + lines + '}';
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Bill() {
    }

    public Bill(int id, Date date, String paymentMethod, int customerId, int paid, ArrayList<BillLine> lines) {
        this.id = id;
        this.date = date;
        this.paymentMethod = paymentMethod;
        this.customerId = customerId;
        this.paid = paid;
        this.lines = lines;
    }

    public int getPaid() {
        return paid;
    }

    public int isPaid() {
        return paid;
    }

    public void setPaid(int paid) {
        this.paid = paid;
    }

    public float getTotal() {
        float sum = 0;
        for (BillLine line : lines) {
            sum += line.getTotal();
        }
        return sum;
    }

    public BigDecimal getTotal1() {
        float sum = 0;
        for (BillLine line : lines) {
            sum += line.getTotal();
        }
        BigDecimal sum1 = new BigDecimal(sum);
        return sum1;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public ArrayList<BillLine> getLines() {
        return lines;
    }

    public void setLines(ArrayList<BillLine> lines) {
        this.lines = lines;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public String getDate1() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        return df.format(date);
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
