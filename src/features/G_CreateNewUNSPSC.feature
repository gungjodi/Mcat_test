@create_new_unspsc
Feature: Create new UNSPSC

  Background: flow untill user on Home Page
    Given User is at the Home Page
    When User "Administrator" enters UserName and Password
    Then Click on the LogIn button
    And Login success dialog is displayed

  Scenario: Create new UNSPSC
    When User access create UNSPSC Menu
    Then User fill UNSPSC detail
    Then click add UNSPSC button
    And UNSPSC should be created
    When User access Search UNSPSC menu
    Then search UNSPSC criteria
    And UNSPSC item should be displayed