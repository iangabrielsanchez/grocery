package com.igcs.grocery;

import com.igcs.grocery.exception.ItemNotFoundException;
import com.igcs.grocery.model.Product;
import com.igcs.grocery.model.Promo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GroceryStore {

    private Map<String, Product> products;

    private double totalPrice;

    private Set<Promo> promos;

    public GroceryStore() {
        products = new HashMap<>();
        totalPrice = 0d;
        promos = new HashSet<>();
    }

    public Set<Promo> getPromos() {
        return promos;
    }

    public void addPromos( Promo promo ) {
        this.promos.add( promo );
    }

    public void scanProduct( String productName, double quantity ) throws ItemNotFoundException {
        if ( products.containsKey( productName ) ) {
            Product product = products.get( productName );
            double salePrice = product.isOnSale()? product.getSalePrice() : product.getPrice();
            totalPrice += ( salePrice * quantity );
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

    public void addItem( Product product ) {
        products.put( product.getProductName(), product );
    }
}
