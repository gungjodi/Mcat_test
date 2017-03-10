@setup_inc_config
Feature: Setup INC Configuration

  Background: flow untill user on Home Page
    Given User is at the Home Page
    When User "Administrator" enters UserName and Password
    Then Click on the LogIn button
    And Login success dialog is displayed

  Scenario: Setup INC Configuration
    Given user is at Search Configuration Menu
    When user Search Criteria Configuration
    Then user click Configuration Name Link
    Then user add an Attribute Group
    Then user add attribute to Item Description Detail
    Then user Add attribute to Bussiness Unit Detail
    Then user Add attribute to Group Detail
    Then user click Save the Configuration
    And Configuration should be saved successfully