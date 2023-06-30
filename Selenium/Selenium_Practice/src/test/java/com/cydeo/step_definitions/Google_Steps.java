package com.cydeo.step_definitions;

import com.cydeo.pages1.GooglePage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class Google_Steps {

    GooglePage googlePage = new GooglePage();
    @Given("user is on goole home page")
    public void user_is_on_goole_home_page() {
        Driver.get().get("https://google.com");
    }
    @When("user searchs for {string} capital")
    public void user_searchs_for_capital(String country) {
        googlePage.searchBox.sendKeys("Capital city of "+country+ Keys.ENTER);
    }
    @Then("user should see {string} result")
    public void user_should_see_result(String capital) {
        Assert.assertEquals(capital,googlePage.capitalResult.getText());
    }
}
