Feature: google search

  @google
  Scenario Outline: Google search for capital city of countries
    Given user is on goole home page
    When  user searchs for "<country>" capital
    Then  user should see "<capital>" result

    Examples:
      | country | capital          |
      | USA     | Washington, D.C. |
      | Germany | Berlin           |
      | Turkey  | Ankara           |