package com.igcs.grocery;

import com.igcs.grocery.model.Product;
import com.igcs.grocery.model.Unit;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class Stepdefs {

    private GroceryStore store;

    @Given( "^I have started the checkout counter$" )
    public void i_have_started_the_checkout_counter() throws Exception {
        store = new GroceryStore();
        addItemsPerPiece( store, false );
        addBulkItems( store );
    }

    @When( "^I scan \"([^\"]*)\"$" )
    public void i_scan( String arg1 ) throws Exception {
        store.scanProduct( arg1 );
    }

    @Then( "^total price is updated to (\\d+.*\\d+)$" )
    public void total_price_is_updated_to( double value ) throws Exception {
        assertEquals( value, store.getTotalPrice(), 0.001 );
    }

    @When( "^I scan (\\d+.*\\d+) kg of \"([^\"]*)\"$" )
    public void i_scan_kg_of( double qty, String product ) throws Exception {
        store.scanProduct( product, qty );
    }

    @When( "^I scan (\\d+) kg of \"([^\"]*)\"$" )
    public void i_scan_kg_of( int qty, String product ) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        store.scanProduct( product, qty );
    }

    @Given( "^I have started the checkout counter with a list of promotions$" )
    public void i_have_started_the_checkout_counter_with_a_list_of_promotions() throws Exception {
        store = new GroceryStore();
        addItemsPerPiece( store, true );
    }

    @When( "^I scan \"([^\"]*)\" with a regular price of (\\d+.*\\d+) and a sale price of (\\d+.*\\d+)$" )
    public void i_scan_with_a_regular_price_of_and_a_sale_price_of( String product, Double regularPrice,
            Double salePrice ) throws Exception {
        store.scanProduct(product, 1);
    }


    private void addItemsPerPiece( GroceryStore store, boolean onSale ) {
        Product chips = new Product( "chips", 35, Unit.PIECE, onSale, 30 );
        Product juice = new Product( "juice", 20, Unit.PIECE, onSale, 16 );
        Product iceCream = new Product( "ice cream", 100, Unit.PIECE, onSale, 85 );

        store.addItem( chips );
        store.addItem( juice );
        store.addItem( iceCream );
    }

    private void addBulkItems( GroceryStore store ) {
        Product rice = new Product( "rice", 40, Unit.KILOGRAM, false, 0 );
        Product sugar = new Product( "sugar", 17, Unit.KILOGRAM, false, 0 );
        Product meat = new Product( "meat", 405, Unit.KILOGRAM, false, 0 );
        store.addItem( rice );
        store.addItem( sugar );
        store.addItem( meat );
    }


}