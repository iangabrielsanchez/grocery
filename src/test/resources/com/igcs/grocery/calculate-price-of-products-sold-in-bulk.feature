Feature: Calculate price of products sold in bulk
    Scan a product sold in bulk so the total price is updated

    Scenario Outline:
        Given I have started the checkout counter
        When I scan <qty> kg of "<product>"
        Then total price is updated to <totalPrice>

        Examples:
            | product | qty | totalPrice |
            | rice    | 1.0 | 40         |
            | sugar   | 0.5 | 8.5        |
            | meat    | 1.0 | 405        |