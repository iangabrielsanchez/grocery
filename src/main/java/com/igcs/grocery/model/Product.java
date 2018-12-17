package com.igcs.grocery.model;

public class Product {

    private String productName;

    private double price;

    private double salePrice;

    private Unit unit;

    private boolean onSale;

    public Product( String productName, double price, Unit unit, boolean onSale, double salePrice ) {
        this.productName = productName;
        this.price = price;
        this.unit = unit;
        this.onSale = onSale;
        this.salePrice = salePrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice( double salePrice ) {
        this.salePrice = salePrice;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale( boolean onSale ) {
        this.onSale = onSale;
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
