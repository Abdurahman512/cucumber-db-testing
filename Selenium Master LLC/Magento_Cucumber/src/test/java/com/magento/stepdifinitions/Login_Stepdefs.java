package com.magento.stepdifinitions;

import com.magento.pages.LoginPage;
import com.magento.utilities.ConfigurationReader;
import com.magento.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_Stepdefs {
    LoginPage loginPage = new LoginPage();
    @Given("user is on the magento login page")
    public void userIsOnTheMagentoLoginPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("backendurl"));
    }

    @When("user enters username {string} password {string} and logins")
    public void userEntersUsernamePasswordAndLogins(String username, String password) {
        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);
        loginPage.loginBtn.click();
    }

    @Then("user should see Logout button")
    public void userShouldSeeLogoutButton() {


        Assert.assertEquals(loginPage.logoutBtn.getText(),"Log Out");
    }
}
