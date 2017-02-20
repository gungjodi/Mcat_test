Feature: Load Data Action

Background: flow untill user on Home Page
	Given User is at the Home Page
	When User "Administrator" enters UserName and Password
	Then Click on the LogIn button
	And Login success dialog is displayed

Scenario: Load Raw Data
	When User access Load Raw Data menu
	Then Load the Excel file
	And Successful Upload message should display
    When User check loaded raw data
    Then loaded raw data should be displayed
    When User click LogOut button
    Then User should be logged out


			
			