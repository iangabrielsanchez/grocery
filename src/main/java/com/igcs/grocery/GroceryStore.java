package com.igcs.grocery;

import com.igcs.grocery.exception.ItemNotFoundException;
import com.igcs.grocery.model.Product;
import com.igcs.grocery.model.Unit;

import java.util.HashMap;
import java.util.Map;

public class GroceryStore {

    private Map<String, Product> products;

    private double totalPrice;

    public GroceryStore() {
        products = new HashMap<>();
        addItem( "chips", 35, Unit.PIECE );
        addItem( "juice", 20, Unit.PIECE );
        addItem( "ice cream", 100, Unit.PIECE );
        addItem( "rice", 40, Unit.KILOGRAM );
        addItem( "sugar",17, Unit.KILOGRAM );
        addItem( "meat", 405, Unit.KILOGRAM );
        totalPrice = 0d;
    }

    public void scanProduct( String productName, double quantity ) throws ItemNotFoundException {
        if ( products.containsKey( productName ) ) {
            Product product = products.get( productName );
            totalPrice += ( product.getPrice() * quantity );
        } else {
            throw new ItemNotFoundException();
        }
    }

    public void scanProduct( String productName ) throws ItemNotFoundException {
        scanProduct( productName, 1 );
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void addItem( String productName, double price, Unit unit ) {
        Product product = new Product( productName, price, unit );
        products.put( product.getProductName(), product );
    }
}
