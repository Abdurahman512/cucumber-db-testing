package com.magento.stepdifinitions;

import com.magento.pages.MarketingDashboardPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Marketing_Steps {
    MarketingDashboardPage marketingDashboardPage = new MarketingDashboardPage();
    @When("clicks on Catalog Price Rule link to fill out {string} {string} {string} and other information")
    public void clicksOnCatalogPriceRuleLinkToFillOutAndOtherInformation(String ruleName, String description, String priority) {

        marketingDashboardPage.addNewCatalogPriceRule(ruleName,description,priority);
    }

    @Then("a new catalog price rule should be added successfully")
    public void aNewCatalogPriceRuleShouldBeAddedSuccessfully() {

        Assert.assertTrue(marketingDashboardPage.verifyAddNewCatalogPriceRuleSuccessfully());
    }

    @When("select the {string} and change the {string}")
    public void select_the_and_change_the(String ruleName, String updatedRuleName) {

        marketingDashboardPage.updatedCatalogPriceRule(ruleName,updatedRuleName);
    }
    @Then("cart price rule should be updated successfully")
    public void cart_price_rule_should_be_updated_successfully() {

        marketingDashboardPage.verifyupdateNewCatalogPriceRuleSuccessfully();
    }
}
