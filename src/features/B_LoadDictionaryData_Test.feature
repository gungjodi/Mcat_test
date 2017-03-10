@load_dictionary_data
Feature: Load Dictionary Data Action

  Background: flow untill user on Home Page
    Given User is at the Home Page
    When User "Administrator" enters UserName and Password
    And Click on the LogIn button

  Scenario: Load Dictionary Data
    When User access Load Dictionary Data menu
    And Load the Dictionary Excel file
    Then Successful Upload Dictionary message should display

    When User access Search Attribute menu
    Then Attribute Data is displayed
    When User click the Attribute Code
    And Save the update attribute detail
    Then Attribute Detail has been successfully updated

    When User access Search NSC menu
    Then NSC Data is displayed
    When User click the NSC Code
    And Save the update NSC detail
    Then NSC Detail has been successfully updated

    When User acess Search INC menu
    Then INC Data is displayed
    When User click the INC Code
    And Save the update INC detail
    Then INC Detail has been successfully updated

    When User access Search Configuration Menu
    Then Configuration Data is Displayed
    When User click Configuration Item
    Then INC Code is Displayed on Item Description Detail
