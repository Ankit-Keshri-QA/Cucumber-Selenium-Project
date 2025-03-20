Feature: Add Product To Cart
  As a logged in user on the Ecomm Website
  I would like to Add the product into the cart
  So that I can proceed to the Checkout page and buy the product

  Scenario: Add One quantity to the cart
    Given  I am on the Store Page
    When I add a "Blue Shoes" to the Cart
    Then I should see 1 "Blue Shoes" in the cart

