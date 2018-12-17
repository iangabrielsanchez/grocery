package com.igcs.grocery.model;

public class ProductBuilder {

    private String productName;

    private double price = 0d;

    private Unit unit = Unit.PIECE;

    private boolean onSale = false;

    private double salePrice = 0d;

    public ProductBuilder setProductName( String productName ) {
        this.productName = productName;
        return this;
    }

    public ProductBuilder setPrice( double price ) {
        this.price = price;
        return this;
    }

    public ProductBuilder setUnit( Unit unit ) {
        this.unit = unit;
        return this;
    }

    public ProductBuilder setOnSale( boolean onSale ) {
        this.onSale = onSale;
        return this;
    }

    public ProductBuilder setSalePrice( double salePrice ) {
        this.salePrice = salePrice;
        return this;
    }

    public Product createProduct() {
        return new Product( productName, price, unit, onSale, salePrice );
    }
}