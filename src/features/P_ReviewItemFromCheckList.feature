@review_item_from_checklist
Feature: Review Item From Checklist

  Background: flow until User on Home Page
    Given User is at the Home Page
    When User "Administrator" enters UserName and Password
    Then Click on the LogIn button
    And Login success dialog is displayed

  Scenario: Approve Last Item from Edit Review item page
    When User access Search Review Item Menu
    Then User search the catalogued items from checklist
    And User approve the checked items
    Then User search the approved items
    And approved items should be displayed