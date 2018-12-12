package com.igcs;

import com.igcs.grocery.GroceryStore;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import static org.junit.Assert.*;

public class Stepdefs {
    private GroceryStore store;
    private double previousValue;

    @Given("^I have started the checkout counter$")
    public void i_have_started_the_checkout_counter() throws Exception {
        store = new GroceryStore();
        previousValue = store.getTotalPrice();
    }

    @When("^I add a \"([^\"]*)\"$")
    public void i_add_a(String arg1) throws Exception {
        store.scanProduct( arg1 );
    }

    @Then("^total price is updated to \"([^\"]*)\"$")
    public void total_price_is_updated_to(String value) throws Exception {
        assertEquals( Double.parseDouble( value ), store.getTotalPrice(), 0.001);
    }

}