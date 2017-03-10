@create_new_inc
Feature: Create new INC

  Background: flow untill user on Home Page
    Given User is at the Home Page
    When User "Administrator" enters UserName and Password
    Then Click on the LogIn button
    And Login success dialog is displayed

  Scenario: Create new INC
    When User access INC menu
    Then User click Create new INC menu
    And User fill INC detail
    When User click add button
    Then INC should be created
    When user click search inc menu
    Then user search the created INC
    And the created INC should be displayed
