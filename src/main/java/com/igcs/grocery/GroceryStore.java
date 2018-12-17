package com.igcs.grocery;

import com.igcs.grocery.exception.ItemNotFoundException;
import com.igcs.grocery.model.Product;
import com.igcs.grocery.model.ProductQuantityPair;
import com.igcs.grocery.model.Promo;

import java.util.*;

public class GroceryStore {

    private Map<String, Product> products;

    private double totalPrice;

    private Set<Promo> promos;

    private List<Product> checkoutList;

    public GroceryStore() {
        products = new HashMap<>();
        totalPrice = 0d;
        promos = new HashSet<>();
        checkoutList = new ArrayList<>();
    }

    public List<Product> getCheckoutList() {
        return checkoutList;
    }

    public Set<Promo> getPromos() {
        return promos;
    }

    public void addPromo( Promo promo ) {
        this.promos.add( promo );
    }

    public void scanProduct( String productName, double quantity ) throws ItemNotFoundException {
        Product product = getProduct( productName );
        double salePrice = product.isOnSale() ? product.getSalePrice() : product.getPrice();
        checkoutList.add( product );
        addGettablesToCartIfPromoExists( product );

        totalPrice += ( salePrice * quantity );
    }

    public void scanProduct( String productName ) throws ItemNotFoundException {
        scanProduct( productName, 1 );
    }

    public Product getProduct( String productName ) throws ItemNotFoundException {
        if ( products.containsKey( productName ) ) {
            return products.get( productName );
        } else {
            throw new ItemNotFoundException();
        }
    }

    public void addGettablesToCartIfPromoExists( Product product ) {

        for ( Promo promo : promos ) {
            List<ProductQuantityPair> requirements = promo.getRequirements();
            int requirementsToSatisfy = requirements.size();
            for ( ProductQuantityPair requirement : requirements ) {
                if ( requirement.getProduct().equals( product ) ) {
                    if ( checkoutList.contains( product ) ) {
                        long count = checkoutList.stream().filter( p -> {
                            return p.getProductName().equals( product.getProductName() );
                        } ).count();
                        if ( count == requirement.getQuantity() ) {
                            requirementsToSatisfy--;
                        }
                    }
                }
            }
            if ( requirementsToSatisfy == 0 ) {
                for ( ProductQuantityPair gettable : promo.getGettables() ) {
                    for ( int i = 0; i < gettable.getQuantity(); i++ ) {
                        checkoutList.add( gettable.getProduct() );
                    }
                }
            }
        }
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void addItem( Product product ) {
        products.put( product.getProductName(), product );
    }
}
