Feature: Print receipt

    Scenario:
        Given I have started the checkout counter with containing various products
        When I scan the following products with quantity:
            | juice   | 1 |
            | rice    | 3.5 |
            | sugar   | 3 |
            | chips   | 1 |
        Then receipt is calculated
        And a full receipt is printed for the customer