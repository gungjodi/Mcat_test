@advance_search
Feature: Advance Search

  Background: flow until User on Home Page
    Given User is at the Home Page
    When User "Administrator" enters UserName and Password
    Then Click on the LogIn button
    And Login success dialog is displayed

  Scenario: Advance Search
    When User access Advance Search Menu
    Then User search item based on INC
    And INC item is displayed
    When User search Attribute
    Then Attribute is Displayed