Feature: Name the Item

  Background: flow untill user on Home Page
    Given User is at the Home Page
    When User "Administrator" enters UserName and Password
    Then Click on the LogIn button
    And Login success dialog is displayed

  Scenario: Find a row data to be named
    When User access Search Raw Data Item menu
    Then raw data should be displayed
    And User click StockCode with New

