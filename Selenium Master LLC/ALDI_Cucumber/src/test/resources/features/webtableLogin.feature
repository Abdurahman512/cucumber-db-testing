@smoke
  Feature: Web table app login
    User Story: User should be able to login web table application

    Background:
      Given user is on the login page of web table app

    @smoke @webtable
    Scenario: Login scenario with valid scenario
      When  user enters username Test
      And   user entsers password Tester
      And   user clicks to login button
      Then  user should see url contains order

    @wip
    Scenario: Login scenario with invalid scenario
     # Given user is on the login page of web table app
      When  user enters username incorrect
      And   user entsers password incorrect
      And   user clicks to login button
      Then  user should see url contains login


