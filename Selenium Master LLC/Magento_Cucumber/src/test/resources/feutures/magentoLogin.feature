
  Feature: Magento Application Login Function

    @wip
    Scenario: login with valid credentials
      Given user is on the magento login page
      When  user enters username "marketingmanager" password "automation123!" and logins
      Then  user should see Logout button
