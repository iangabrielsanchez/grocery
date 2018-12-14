package com.igcs.grocery.model;

public class Product {

    private String productName;

    private double price;

    private Unit unit;

    public Product( String productName, double price, Unit unit ) {
        this.productName = productName;
        this.price = price;
        this.unit = unit;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName( String productName ) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice( double price ) {
        this.price = price;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit( Unit unit ) {
        this.unit = unit;
    }
}
