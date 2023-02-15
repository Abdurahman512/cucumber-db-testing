

Feature: User Verification

  @wip
  Scenario: verify information about logged user
    Given I logged Bookit api using "dmacilwrick2@github.com " and "dennetmacilwrick"
    When I get the current user information from api
    Then status code should be 200


    #get name,role,team,batch,campus information from ui,database and api, compare them
    #you might get in one shot from ui and database, but might need multiple api requests to get those information