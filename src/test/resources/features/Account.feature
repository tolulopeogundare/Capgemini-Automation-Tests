@MyAccount
Feature: Create a new account

  @Test-1
  Scenario: As a guest customer I want to be able to create a new account
    Given I am on homepage
    When I navigate to sign in page
    And I enter my email to register
    And I complete registration details
    And I click register
    Then I verify I am taken to My Account page