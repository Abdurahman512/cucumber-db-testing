package com.Name.step_definitions;

import com.Name.pages.WebtableLoginPage;
import com.Name.utilities.ConfigurationReader;
import com.Name.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;

public class WebtableLogin_Stepdefs {

    WebtableLoginPage webtableLoginPage = new WebtableLoginPage();
    @Given("user is on the login page of web table app")
    public void userIsOnTheLoginPageOfWebTableApp() {
        Driver.getDriver().get(ConfigurationReader.getProperty("web.table.url"));
    }

    @When("user enters username Test")
    public void userEntersUsernameTest() {
        webtableLoginPage.username.sendKeys(ConfigurationReader.getProperty("web.table.username"));

    }

    @And("user entsers password Tester")
    public void userEntsersPasswordTester() {
        webtableLoginPage.password.sendKeys(ConfigurationReader.getProperty("web.table.pw"));
    }

    @And("user clicks to login button")
    public void userClicksToLoginButton() {
        webtableLoginPage.loginBtn.click();
    }

    @Then("user should see url contains order")
    public void userShouldSeeUrlContainsOrder() {
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains("order"));
    }

    @When("user enters username incorrect")
    public void userEntersUsernameIncorrect() {
        webtableLoginPage.username.sendKeys("incorrect");
    }

    @And("user entsers password incorrect")
    public void userEntsersPasswordIncorrect() {
        webtableLoginPage.password.sendKeys("incorrect");
    }

    @Then("user should see url contains login")
    public void userShouldSeeUrlContainsLogin() {
        String actualUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actualUrl.contains("login"));
    }

    @When("user enters username {string}")
    public void user_enters_username(String username) {
        webtableLoginPage.username.sendKeys(username);
    }
    @When("user entsers password {string}")
    public void user_entsers_password(String password) {
        webtableLoginPage.password.sendKeys(password);
    }

    @When("user enters username {string} password {string} and logins")
    public void user_enters_username_password_and_logins(String username, String password) {
        webtableLoginPage.login(username,password);
    }

    @When("user enters below credentials")
    public void user_enters_below_credentials(Map<String, String> credentials) {

        webtableLoginPage.username.sendKeys(credentials.get("username"));
        webtableLoginPage.password.sendKeys(credentials.get("password"));
        webtableLoginPage.loginBtn.click();

       // webtableLoginPage.login(credentials.get("username"),credentials.get("password"));
    }
}
