@submit_assigned_item_from_checklist
Feature: Submit Assigned Item From Checklist

  Background: flow until User on Home Page
    Given User is at the Home Page
    When User "Administrator" enters UserName and Password
    Then Click on the LogIn button
    And Login success dialog is displayed

  Scenario: Submit Last Assigned Item from Edit Raw data item page
    When User access Search Assigned Item Menu
    Then User search the assigned items from checklist
    And User submit the checked items
    Then User search the submitted items
    And submitted items should be displayed