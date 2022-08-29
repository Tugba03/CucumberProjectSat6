Feature: Purchase Foreign Functionality

  Scenario Outline: Purchase Foreign Currency
    Given User navigate to zero bank application
    And   User login to their account
    And   User needs to click online Banking
    When  User click on pay bills and click Purchase Foreign Currency
    Then  User should select Currency "<currency>", "<amount>"
    And   User should see success message after clicking on the purchase button

    Examples:
      | currency        | amount |
      | Canada (dollar) | 20.00  |

