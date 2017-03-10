@create_attribute_group
Feature: Create new Attribute Group

  Background: flow untill user on Home Page
    Given User is at the Home Page
    When User "Administrator" enters UserName and Password
    Then Click on the LogIn button
    And Login success dialog is displayed

  Scenario: Create new Attribute Group
    When User access create Attribute Group Menu
    Then User fill Attribute Group detail
    Then click add Attribute Group button
    And Attribute Group item should be created
    When User access Search Attribute Group menu
    Then search Attribute Group criteria
    And Attribute Group item should be displayed