package com.Name.step_definitions;

import com.Name.pages.GoogleSearchPage;
import com.Name.utilities.BrowserUtils;
import com.Name.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearch_Stepdefs {
    GoogleSearchPage googleSearchPage = new GoogleSearchPage();
    @Given("user is on the google home page")
    public void userIsOnTheGoogleHomePage() {
        Driver.getDriver().get("https://www.google.com/");
    }

    @When("user searchs for {string} capital")
    public void userSearchsForCapital(String country) {
        BrowserUtils.waitFor(1);
        googleSearchPage.searchBox.sendKeys("Capital city of "+ country + Keys.ENTER);
    }

    @Then("user should see {string} result")
    public void userShouldSeeResult(String capital) {
        Assert.assertEquals(capital,googleSearchPage.capitalResult.getText());
    }


}
