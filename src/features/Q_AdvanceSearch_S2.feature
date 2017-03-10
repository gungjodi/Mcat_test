@advance_search
Feature: Advance Search

  Background: flow until User on Home Page
    Given User is at the Home Page
    When User "Administrator" enters UserName and Password
    Then Click on the LogIn button
    And Login success dialog is displayed

  Scenario: Edit to Assigned Item
    When User access Advance Search Menu
    Then User search item criteria
    And User edit to Assigned Item
    When User check edited item
    Then edited item is displayed
