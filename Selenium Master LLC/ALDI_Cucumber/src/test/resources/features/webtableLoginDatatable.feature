Feature: Web table application login with data table
  User Store: User should be able to login web table application

  @webtableDatatable
  Scenario: login web table app with using datatable
    Given user is on the login page of web table app
    When  user enters below credentials

    # option + commend + l
      | username | Test   |
      | password | Tester |

    Then  user should see url contains order
