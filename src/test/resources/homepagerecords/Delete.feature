@test
Feature: Delete records for hotels
  As a user, I want to be able to delete records displayed on home page

  Scenario: Delete a record
    Given user navigates to the login page
    And user clicks on 'Login' link and enters username and password
    And user clicks on Login Button
    And user clicks on X button to delete Hotel record
