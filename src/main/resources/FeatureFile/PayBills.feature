Feature: Pay Bill Functionality

  Background:
    Given User navigate to zero bank
    And   User login to the account
    And   User go click online banking on the homepage
    When  User click on pay bills and click on add new payee

  Scenario Outline: Add new payee as positive
    Then User should be able to fill out "<name>", "<address>", "<account>", "<details>"and add new payee
    And user should see success message


    Examples:
      | name  | address         | account | details |
      | David | 5 smithfield rd | 1234567 | money   |


  Scenario Outline: Add new payee as negative
    Then User should be able to fill out "<name>", "<address>", "<account>", "<details>"and add new payee
    And User should see error message: Please fill out this field.

    Examples:
      | name    | address         | account | details |
      |         | 5 smithfield rd | 1234567 | money   |
      | Melissa |                 | 1234567 | money   |
      | Melissa | 5 smithfield rd |         | money   |


