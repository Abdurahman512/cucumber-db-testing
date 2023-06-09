
  Feature: Login Function Test

    Scenario: check login successful with valid credentials
      Given the user is on the login page
      When  the user enters <username> and <password>
      And   the user clicks on login button
      Then  the user should be able to login