package com.igcs.grocery.model;

import java.util.HashSet;
import java.util.Set;

public class ProductBundle {

    private Set<ProductQuantityPair> productQuantityPairs;

    private double price;

    public ProductBundle() {
        productQuantityPairs = new HashSet<>();
    }

    public void addProduct( Product product, double quantity ) {
        productQuantityPairs.add(
                new ProductQuantityPair( product, quantity )
        );
    }

    public ProductQuantityPair[] getProductsList() {
        return productQuantityPairs.toArray(
                new ProductQuantityPair[productQuantityPairs.size()]
        );
    }


}
