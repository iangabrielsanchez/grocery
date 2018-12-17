Feature: Calculate price of products on sale
    Scan a product on sale so the total price is updated

    Scenario Outline:
        Given I have started the checkout counter with a list of promotions
        When I scan "<product>" with a regular price of <regularPrice> and a sale price of <salePrice>
        Then total price is updated to <totalPrice>

        Examples:
            | product   | regularPrice | salePrice | totalPrice |
            | chips     | 35           | 30        | 30         |
            | juice     | 20           | 16        | 16         |
            | ice cream | 100          | 85        | 85         |


    Scenario Outline:
        Given I have started the checkout with product promos
        When I scan "<product>" "<times>" times
        Then the checkout items should be "<itemCount>"

        Examples:
            | product | itemCount | times |
            | chips   | 3         | 2     |
            | juice   | 2         | 1     |


