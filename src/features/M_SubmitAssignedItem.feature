@submit_assigned_item
Feature: Submit Assigned Item

  Background: flow until User on Home Page
    Given User is at the Home Page
    When User "Administrator" enters UserName and Password
    Then Click on the LogIn button
    And Login success dialog is displayed

  Scenario: Submit Assigned Item From Edit Raw Data Item Page
    When User access Search Assigned Item Menu
    Then User search the assigned item
    And User submit the assigned item
    Then User search the submitted item
    And submitted item should be displayed