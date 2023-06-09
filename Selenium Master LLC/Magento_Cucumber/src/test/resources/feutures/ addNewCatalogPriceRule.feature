Feature:Marketing Manager can manage market

  Background:
    Given user is on the magento login page
    When  user enters username "marketingmanager" password "automation123!" and logins

  @MarketingManagerCanAddNewCatalogPriceRule
  Scenario Outline: Marketing Manager can add new Catalog Price Rule

    When  clicks on Catalog Price Rule link to fill out "<ruleName>" "<description>" "<priority>" and other information
    Then  a new catalog price rule should be added successfully

    Examples:
      | ruleName | description                       | priority |
      | My-Rule  | 50% off discount for each product | high     |

  @MarketingManagerCanUpdateExistingCatalogPriceRule
  Scenario Outline: MarketingManagerUpdateExistingCatalogPriceRule

    When select the "<ruleName>" and change the "<updatedRuleName>"
    Then cart price rule should be updated successfully
    Examples:
      | ruleName                           | updatedRuleName                   |
      | My-Rule | only members get 55% off discount |

