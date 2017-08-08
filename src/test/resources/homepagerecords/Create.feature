@test
Feature: Creating new records for hotels
  As a user, I want to create new records to be shown on home page

  Background: 
    Given user navigates to the login page
    And user clicks on 'Login' link and enters username and password
    And user clicks on Login Button

  Scenario: Create a new record
    And user enters the values in 'MyHotel', 'MyAddr', 'MyOwn', '00000007', 'myemail@myemail.com'
    Then user clicks on Create Button

  Scenario Outline: Create multiple records
    And user enters the values in '<Hotel name>', '<Address>', '<Owner>', '<Phone number>', '<Email>'
    Then user clicks on Create Button

    Examples: 
      | Hotel name | Address        | Owner  | Phone number | Email       |
      | Hotel1     | test address 1 | Owner1 |     00000001 | abc@abc.com |
      | Hotel2     | test address 2 | Owner2 |     00000002 | bcd@bcd.com |
      | Hotel3     | test address 3 | Owner3 |     00000003 | cde@cde.com |
