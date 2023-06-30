
Feature: Webtable app login
  User Strory: User should be able to login webtable application with valid credentials

  Background:
    Given user is on the login page of webtable app


  Scenario: login scenario
    When  user enters username Test
    And   user enters password Tester
    And   user clicks to login button
    Then  user should see url contains orders


  Scenario: login scenario with invalid credentials
    When  user enters username incorrect
    And   user enters password incorrect
    And   user clicks to login button
    Then  user should see url contains orders

