
Feature: Webtable app login
  User Strory: User should be able to login webtable application with valid credentials
  @wip
  Scenario: Login webtable app with parameterization

    Given user is on the login page of webtable app
    When  user enters username "Test"
    And   user enters password "Tester"
    And   user clicks to login button
    Then  user should see url contains orders

    @webtable2param
    Scenario: Login with 2 params
      Given user is on the login page of webtable app
      When  user enters username "Test" password "Tester" and logins
      Then  user should see url contains orders