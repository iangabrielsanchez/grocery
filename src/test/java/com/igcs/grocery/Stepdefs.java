package com.igcs.grocery;

import com.igcs.grocery.model.Product;
import com.igcs.grocery.model.Unit;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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


    @When( "^I scan \"([^\"]*)\" \"(\\d+)\" times$" )
    public void i_scan_times( String arg1, int arg2 ) throws Exception {
        for ( int i = 0; i < arg2; i++ ) {
            store.scanProduct( arg1 );
        }
    }


    @Then( "^the checkout items should be \"(\\d+)\"$" )
    public void the_checkout_items_should_be( int arg1 ) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        assertEquals( arg1, store.getCheckoutList().size() );
    }


    @Given( "^I have started the checkout counter with containing various products$" )
    public void i_have_started_the_checkout_counter_with_containing_various_products() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        store = new GroceryStore();
        addBulkItems( store );
        addItemsPerPiece( store, false );
        addPromo( store );

    }

    @When( "^I scan the following products with quantity:$" )
    public void i_scan_the_following_products_with_quantity( Map<String, Double> arg1 ) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        for ( Map.Entry<String, Double> entry : arg1.entrySet() ) {
            store.scanProduct( entry.getKey(), entry.getValue() );
        }
    }

    @Then( "^receipt is calculated$" )
    public void receipt_is_calculated() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        assertNotEquals( 0, store.getTotalPrice() );
    }

    @Then( "^a full receipt is printed for the customer$" )
    public void a_full_receipt_is_printed_for_the_customer() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        System.out.println( "Items:\tQty:\tPrice:" );
        List<Product> checkoutList = store.getCheckoutList();
        List<Double> checkoutListQuantity = store.getCheckoutListQuantity();
        List<Double> checkoutListPrice = store.getCheckoutListPrice();

        for ( int i = 0; i < checkoutList.size(); i++ ) {
            System.out.println(
                    checkoutList.get( i ).getProductName() + "\t" +
                            checkoutListQuantity.get( i ) + "\t" +
                            checkoutListPrice.get( i ) );
        }

        System.out.println( "Total:\t\t" + store.getTotalPrice() );
    }


    private void addBulkItems( GroceryStore store ) {
        Product rice = new Product( "rice", 40, Unit.KILOGRAM, false, 0 );
        Product sugar = new Product( "sugar", 17, Unit.KILOGRAM, false, 0 );
        Product meat = new Product( "meat", 405, Unit.KILOGRAM, false, 0 );
        store.addItem( rice );
        store.addItem( sugar );
        store.addItem( meat );
    }


        Promo buy1Take1Juice = new Promo();
        buy1Take1Juice.addRequirement( oneJuice );
        buy1Take1Juice.addGettable( oneJuice );

        ProductQuantityPair twoChips = new ProductQuantityPair(
                store.getProduct( "chips" ), 2 );

        ProductQuantityPair oneChips = new ProductQuantityPair(
                store.getProduct( "chips" ), 1 );

        Promo buy2Take1Chips = new Promo();
        buy2Take1Chips.addRequirement( twoChips );
        buy2Take1Chips.addGettable( oneChips );

        store.addPromo( buy1Take1Juice );
        store.addPromo( buy2Take1Chips );
    }

    private void addItemsPerPiece( GroceryStore store, boolean onSale ) {
        Product chips = new Product( "chips", 35, Unit.PIECE, onSale, 30 );
        Product juice = new Product( "juice", 20, Unit.PIECE, onSale, 16 );
        Product iceCream = new Product( "ice cream", 100, Unit.PIECE, onSale, 85 );

        store.addItem( chips );
        store.addItem( juice );
        store.addItem( iceCream );
    }


}