Feature: Name the Item from checklist

  Background: flow untill user on Home Page
    Given User is at the Home Page
    When User "Administrator" enters UserName and Password
    Then Click on the LogIn button
    And Login success dialog is displayed

  Scenario: Find some row data to be named
    When User access Search Raw Data Item menu
    Then raw data should be displayed
    When User tick one or more checkboxes
    Then user search INC code
    And User Click name button