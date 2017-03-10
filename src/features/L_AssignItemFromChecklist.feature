@assign_item_from_checklist
Feature: Assign Item From Check List

  Background: flow until User on Home Page
    Given User is at the Home Page
    When User "Administrator" enters UserName and Password
    Then Click on the LogIn button
    And Login success dialog is displayed

  Scenario:Assign Item from Search Raw data item page
    Given User is at Search Raw Data Menu
    When User search Named Item
    Then User assign ticked Items
    And Assigned items are displayed on table

