Feature: Calculate price of products sold by piece.
    Scan a product sold by piece so the total price is updated

    Scenario Outline:
        Given I have started the checkout counter
        When I add a "<product>"
        Then total price is updated to "<totalPrice>"

        Examples:
            | product   | totalPrice |
            | chips     | 35         |
            | juice     | 20         |
            | ice cream | 100        |