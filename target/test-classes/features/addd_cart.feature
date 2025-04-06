Feature: Add Product To Cart
  As a logged in user on the Ecomm Website
  I would like to Add multiple products into the cart
  So that I can proceed to the Checkout page and buy the products

  Scenario Outline: Add Multiple products to the cart
    Given  I am on the Store Page
    When I add a "<product_name>" to the Cart
    Then I should see 1 "<product_name>" in the cart

    Examples:
      | product_name    |
      | Blue Shoes      |
      | Anchor Bracelet |
