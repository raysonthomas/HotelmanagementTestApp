@test
Feature: Delete records for hotels

  Scenario: Delete a record
    Given user navigates to the login page
    And user clicks on 'Login' link and enters username and password
    And user clicks on Login Button
    And user clicks on X button to delete Hotel1 record
    #And user sees that the record has been deleted
