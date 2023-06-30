Feature: Webtable app login
  User Strory: User should be able to login webtable application with valid credentials
@webtableLoginDatatable
  Scenario: login webtable app with using datatable
    Given user is on the login page of webtable app
    When  user enters below credentials
      | username  | Test      |
      | password  | Tester    |
    Then  user should see url contains orders