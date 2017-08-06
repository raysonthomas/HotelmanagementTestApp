Feature: Creating new records for hotels
  As a user, I want to create new records to be shown on home page

  Background: 
    Given user navigates to the login page
    And user clicks on 'Login' link and enters username and password
    And user clicks on Login Button

  Scenario Outline: Create new record
    Given user navigates to the home page
    Given user enters the values in '<Hotel name>', '<Address>', '<Owner>', '<Phone number>', '<Email>'
    Then user clicks on Create Button

    Examples: 
      | Hotel name | Address        | Owner  | Phone number | Email       |
      #| Hotel1     | test address 1 | Owner1 |     00000001 | abc@abc.com |
      #| Hotel2     | test address 2 | Owner2 |     00000002 | bcd@bcd.com |
      #| Hotel3     | test address 3 | Owner3 |     00000003 | cde@cde.com |
      #| Hotel4     | test address 4 | Owner4 |     00000004 | def@def.com |

  Scenario: Delete a record
    Given user clicks on X button to delete Hotel1 record
    #And user sees that the record has been deleted
