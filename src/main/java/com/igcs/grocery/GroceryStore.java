package com.igcs.grocery;

import com.igcs.grocery.exception.ItemNotFoundException;
import com.igcs.grocery.model.Product;

import java.util.HashMap;
import java.util.Map;

public class GroceryStore {

    private Map<String, Product> products;

    private double totalPrice;

    public GroceryStore() {
        products = new HashMap<>();

        Product chips = new Product( "chips", 35 );
        Product juice = new Product( "juice", 20 );
        Product iceCream = new Product( "ice cream", 100 );

        products.put( chips.getProductName(), chips );
        products.put( juice.getProductName(), juice );
        products.put( iceCream.getProductName(), iceCream );
        totalPrice = 0d;
    }

    public void scanProduct( String productName ) throws ItemNotFoundException {
        if ( products.containsKey( productName ) ) {
            Product product = products.get( productName );
            totalPrice += product.getPrice();
        } else {
            throw new ItemNotFoundException();
        }
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
