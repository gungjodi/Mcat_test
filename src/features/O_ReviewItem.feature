@review_item
Feature: Review Item

  Background: flow until User on Home Page
    Given User is at the Home Page
    When User "Administrator" enters UserName and Password
    Then Click on the LogIn button
    And Login success dialog is displayed

  Scenario: Approve Item From Edit Review Item Page
    When User access Search Review Item Menu
    Then User search the catalogued item
    And User approve the catalogued item
    Then User search the reviewed item
    And reviewed item should be displayed