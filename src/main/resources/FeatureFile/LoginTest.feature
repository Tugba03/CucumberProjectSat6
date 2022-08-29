Feature: Login functionality


  Background: Navigate to website
    Given User navigate to website

  Scenario Outline:
    When User enter valid "<Username>" and "<Password>"
    Then User should login successfully

    Examples:
    | Username  | Password |
    | username  | password |

  Scenario Outline:
    When User enter valid "<Username1>" and invalid "<Password1>"
    Then Login should fail

    Examples:
    | Username1  | Password1 |
    | username  | mmvnh      |



  Scenario Outline:
    When User enter invalid "<Username2>" and valid "<Password2>"
    Then Login should fail

    Examples:
     | Username2  | Password2 |
     | apple      | password  |


  Scenario Outline:
    When User enter invalid "<Username3>" and invalid "<Password3>"
    Then Login should fail

    Examples:
     | Username3  | Password3  |
     | apple      | mtchd      |
