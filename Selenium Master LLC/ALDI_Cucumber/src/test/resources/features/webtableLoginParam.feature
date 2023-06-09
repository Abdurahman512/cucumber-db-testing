
  Feature: Web table application login
    User Store: User should be able to login web table application
    @webtableParam
    Scenario: login web table app with parameterization
      Given user is on the login page of web table app
      When  user enters username "Test"
      And   user entsers password "Tester"
      And   user clicks to login button
      Then  user should see url contains order

      @webtable2Param
      Scenario: Login with 2 params
        Given user is on the login page of web table app
        When  user enters username "Test" password "Tester" and logins
        Then  user should see url contains order

