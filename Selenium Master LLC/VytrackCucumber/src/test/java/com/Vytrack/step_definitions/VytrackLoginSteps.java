package com.Vytrack.step_definitions;

import com.Vytrack.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class VytrackLoginSteps {
    LoginPage loginPage = new LoginPage();
    @Given("User go to vytrack login page")
    public void userGoToVytrackLoginPage() {

        Driver.get().get("https://qa1.vytrack.com/user/login");
    }

    @When("user enters username and password, then click login button")
    public void user_enters_username_and_password_then_click_login_button() {
        loginPage.userNameInput.sendKeys("user1");
        loginPage.passwordInput.sendKeys("UserUser123");
        loginPage.submitBtn.click();
    }
    @Then("user is on the dashboard")
    public void user_is_on_the_dashboard() {
        String expectedTitle = "Dashboard";
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
    }
}
