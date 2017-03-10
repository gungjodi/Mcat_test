@advance_search
Feature: Advance Search

  Background: flow until User on Home Page
    Given User is at the Home Page
    When User "Administrator" enters UserName and Password
    Then Click on the LogIn button
    And Login success dialog is displayed

  Scenario: Edit to Review Item
    When User access Advance Search Menu
    Then User search QA item criteria
    And User edit to Review Item
    When User check Reviewed item
    Then Reviewed item is displayed
