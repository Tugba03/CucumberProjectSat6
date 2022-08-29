Feature: Transfer Funds Func feature

  Background:
    Given  User login to their account and navigate to transfer funds

  Scenario Outline:
    When User fill up the following "<fromAccount>", "<toAccount>", "<amount>", "<description>" correctly
    Then User should get success message after click submit button

    Examples:
      | fromAccount                      | toAccount                           | amount | description |
      | Savings(Avail. balance = $ 1000) | Checking(Avail. balance = $ -500.2) | 200.00 | Rent        |


