Feature: Login Account
  @login
  Scenario: Login Functionality
    Given user navigates to the website "https://www.saucedemo.com/"
    When the user can input a username and password
    Then login must be successful.
    When the user choose a product and add them to the cart
    Then the cart icon has "1" item
    When the user can tap cart icon
    Then name product is displayed same name product added