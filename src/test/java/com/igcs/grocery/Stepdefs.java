package com.igcs.grocery;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertEquals;

public class Stepdefs {

    private GroceryStore store;

    @Given( "^I have started the checkout counter$" )
    public void i_have_started_the_checkout_counter() throws Exception {
        store = new GroceryStore();
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


}