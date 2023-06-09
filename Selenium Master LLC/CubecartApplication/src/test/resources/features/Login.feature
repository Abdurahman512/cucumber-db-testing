
Feature: Cubecart login function
    @wip
  Scenario: Admin user can login with valid credential
    Given user is on the cubecart login page
    When  user enters valid username and valid password
    Then  user should be able to successfully login