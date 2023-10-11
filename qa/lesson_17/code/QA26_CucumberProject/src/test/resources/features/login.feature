Feature: Login

  @login
  Scenario: Login with valid data
    Given User launches Chrome Browser
    When User opens ilcarro HomePage
    And User clicks on Log in link
    And User enters valid data
    And User clicks on Yalla button
    Then User verifies log in message
    And User quites browser

  @wrongPassword
  Scenario Outline: Login with valid email and wrong password
    Given User launches Chrome Browser
    When User opens ilcarro HomePage
    And User clicks on Log in link
    And User enters valid email and wrong password
      | email   | password   |
      | <email> | <password> |
    And User clicks on Yalla button
    Then User verifies error message
    And User quites browser
    Examples:
      | email         | password    |
      | manuel@gm.com | Manuel1234  |
      | manuel@gm.com | Manuelllll! |
      | manuel@gm.com | 1111111234! |
      | manuel@gm.com | !!!!!!!!!!! |
