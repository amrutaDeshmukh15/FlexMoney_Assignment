Feature: Flexmoney transaction authorization flow

@tagPayment
	Scenario: Verify user is redirected to page to enter correct Mobile Number
		Given I am on simulation page
		When I click on continue button
		Then I verify that user is on payment enter mobile page
		
@tagPayment
	Scenario: Verify user is redirected to EMI selection page
#		Given I am on payment enter mobile number page
		When I enter correct mobile number 
		When I click on Submit button
		Then I verify user is on EMI selection page
	
@tagPayment
	Scenario: Verify user is redirected Transaction Confirmation page after selecting the EMI
#		Given I am on EMI selection page
		When I select EMI option of three months 
		When I click on Confirm Button
		Then I am redirected Transaction Confirmation Page
		