@flipkart
Feature: Flipkart Functionality

  Scenario: Verify that product placed
  When Verify that the homepage loads successfully.
    Given User search "Acer Aspire" and press Enter.
    When User Click on one of the search results to view the product details.
    And User Add the selected laptop to the shopping cart.
    And User Navigate to the shopping cart.
    And Verify that the correct item is in the cart.
    Then Click on the Proceed to Checkout button.



