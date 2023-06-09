
  Feature: Testing Spartans Web Application
    @wip  @db
    Scenario: Connecting web data and getting all the names
      Given user is an the spartan home page
      When  user clicks on any random spartan
      Then  spartan info should be same with DB