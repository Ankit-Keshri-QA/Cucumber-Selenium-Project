Feature: Place an order
  As a Guest User visiting the website for the first time
  I want to place an order
  So that I can validate the Order details

  Scenario: Guest Order Using Default Payment Option
    Given I am a Guest User
    And I have the below details
      | firstName | lastName | country | address_line1 | city | state  | zipCode | emailID         |
      | Marshal   | Mathers  | India   | Manjri Khurd  | Pune | Kansas | 75024   | andlf@gmail.com |
    And I have added a product from the cart
    And I am on the Checkout page
    When I provide the shipping details
    And I place the order
    Then the order should be placed successfully
