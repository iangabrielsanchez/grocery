package com.igcs.grocery.model;

public class ProductQuantityPair {

    private Product product;

    private double quantity;

    public ProductQuantityPair( Product product, double quantity ) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct(){
        return this.product;
    }

    public double getQuantity(){
        return this.quantity;
    }
}
