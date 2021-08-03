/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author User
 */
public class BillReportPaid {

    private int billid;
    private Date date;
    private int customerid;
    private int status;
    private String customername;
    private String phone;
    private String address;
    private int isFarmer;

    public int getBillid() {
        return billid;
    }

    public void setBillid(int billid) {
        this.billid = billid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
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

    public int getIsFarmer() {
        return isFarmer;
    }

    public void setIsFarmer(int isFarmer) {
        this.isFarmer = isFarmer;
    }

    public BillReportPaid(int billid, Date date, int customerid, int status, String customername, String phone, String address, int isFarmer) {
        this.billid = billid;
        this.date = date;
        this.customerid = customerid;
        this.status = status;
        this.customername = customername;
        this.phone = phone;
        this.address = address;
        this.isFarmer = isFarmer;
    }

}
