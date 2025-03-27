Feature: Western Union Pay Bills Service
  As a user   I want to pay bills through Western Union
  So that I can complete my transactions conveniently
    
  @sequential
  Scenario: Goto to setting page
    Given the user opens the page "https://www.westernunion.com" in the browser
    And the user selects "I Agree" on the cookie message
    When the user clicks on the burger menu
    And the user selects the "Settings" option
    Then the user should be redirected to the settings page
   
   @sequential
   Scenario: Change country to USA
    Given the user should be redirected to the settings page
   	When the user selects "USA" from the country dropdown
   	And the user confirms the country change
    
   Scenario: Goto to bill payment page
    Given the user is on the USA home page
    When the user clicks on the burger menu
    And the user selects the "Pay Bill" option
   
   @sequential
   Scenario: Fill bill payment form
    Given the user is on the Pay Bill page
    And the user searches for "Western Union" and selects it from the list
    And the user enters "100" in the send amount field
    And the user enters "1111111111" in the account number field
    And the user clicks on "Continue"
    When the user chooses the "Pay in Store" option
    And the user selects delivery service
    And the user selects "Colorado" from the state dropdown
    And the user clicks on "Continue"