Feature: Create new NSC

  Background: flow untill user on Home Page
    Given User is at the Home Page
    When User "Administrator" enters UserName and Password
    Then Click on the LogIn button
    And Login success dialog is displayed

  Scenario: Create new NSC item
    When User access create NSC menu
    Then User click search INC code
    Then User choose INC code
    Then User fill NSC detail
    Then User click add NSC button
    And NSC should be added
    When User access search NSC menu
    Then User search NSC code
    And NSC code should be displayed