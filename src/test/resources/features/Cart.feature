@MyCart
Feature: Saved cart for registered customer

  @Test-1
  Scenario: Check that cart item is retained after customer logs out and logs in again
    Given I am logged in as a customer
    When I navigate to dresses category
    And I add the most expensive dress to cart
    And I log out and log back in again
    Then I verify the item added to cart is still added