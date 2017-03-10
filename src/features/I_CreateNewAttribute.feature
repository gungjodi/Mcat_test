@create_new_attribute
Feature: Create new Attribute

  Background: flow untill user on Home Page
    Given User is at the Home Page
    When User "Administrator" enters UserName and Password
    Then Click on the LogIn button
    And Login success dialog is displayed

  Scenario: Create new Attribute
    When User access create Attribute Menu
    Then User fill Attribute detail
    Then click add Attribute button
    And Attribute item should be created
    When User access Search Attribute menu
    Then search Attribute criteria
    And Attribute item should be displayed