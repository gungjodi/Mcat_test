Feature: Load Dictionary Data Action

  Background: flow untill user on Home Page
    Given User is at the Home Page
    When User "Administrator" enters UserName and Password
    And Click on the LogIn button

  Scenario: Load Dictionary Data
    When User access Load Dictionary Data menu
    And Load the Dictionary Excel file
    Then Successful Upload Dictionary message should display
