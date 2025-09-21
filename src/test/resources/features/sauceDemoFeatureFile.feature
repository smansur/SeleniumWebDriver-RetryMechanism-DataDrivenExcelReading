@Regression
Feature: Sauce Demo Login

  Scenario: Login with valid credentials
    Given you access the webapp login page
    When you enter the username
    And you enter the password
    And you click on login button
    Then you see home page for successful login with logout option displayed

  Scenario: Login with invalid credentials
    Given you access the webapp login page
    When you enter the username
    And you enter the invalid password
    And you click on login button
    Then you see home page for successful login with logout option displayed
