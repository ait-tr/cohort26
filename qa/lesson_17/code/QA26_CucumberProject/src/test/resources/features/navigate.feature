Feature: HomePage UI

  @navigate
  Scenario: Verify HomePage title is displayed
    Given User launches Chrome Browser
    When User opens ilcarro HomePage
    Then User verifies HomePage title
