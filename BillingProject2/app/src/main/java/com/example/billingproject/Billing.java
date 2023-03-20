package com.example.billingproject;

import java.text.DecimalFormat;

public class Billing {
    private int client_id;
    private String client_name;
    private String product_name;
    private double prd_price;
    private int prd_qty;
    private static double Fed_Tax=0.075;
    private static double Prv_Tax=0.06;

    Billing(){      //default constructor
        int client_id = 0;
        String client_name="";
        String product_name="";
        double prd_price=0;
        int prd_qty=0;
    }

    public Billing(int client_id, String client_name, String product_name, double prd_price, int prd_qty) {
        this.client_id = client_id;
        this.client_name = client_name;
        this.product_name = product_name;
        this.prd_price = prd_price;
        this.prd_qty = prd_qty;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getClient_name() {
        return client_name;
    }

    public void setClient_name(String client_name) {
        this.client_name = client_name;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public double getPrd_price() {
        return prd_price;
    }

    public void setPrd_price(double prd_price) {
        this.prd_price = prd_price;
    }

    public int getPrd_qty() {
        return prd_qty;
    }

    public void setPrd_qty(int prd_qty) {
        this.prd_qty = prd_qty;
    }

    public String CalculateBilling(){



        double T_Billing = (prd_price* prd_qty) + (prd_price*prd_qty)* Fed_Tax + (prd_price*prd_qty)* Prv_Tax;
        DecimalFormat df = new DecimalFormat("0.00");

        return  getClient_id()+", "+getClient_name()+", Product: "+getProduct_name()+" is "+getPrd_price()+"$";
    }






}
