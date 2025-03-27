Feature: Western Union Location Search Service
  As a user 
  I want to search for open agent locations near my Zip code 08247 
  So that I can get address details of the first location

  @location
  Scenario: Navigate to Find Locations page
    Given the user opens location page "https://www.westernunion.com"
    When the user clicks on location burger menu
    And the user choose the "Find Locations" option
   
  @location
  Scenario: Search locations by zip code
    Given the user is on Find Locations page
    When the user clears the location search field
    And the user enters "08247" in the location search field
    And the user clicks on the search button
    And the user choose on the open button
    Then the address of the first location should be printed in console