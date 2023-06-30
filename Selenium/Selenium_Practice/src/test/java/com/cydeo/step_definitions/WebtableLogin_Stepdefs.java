package com.cydeo.step_definitions;

import com.cydeo.pages1.WebtableLoginPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.lang.module.Configuration;
import java.util.Map;

public class WebtableLogin_Stepdefs {

    WebtableLoginPage webtableLoginPage = new WebtableLoginPage();
    @Given("user is on the login page of webtable app")
    public void user_is_on_the_login_page_of_webtable_app() {
      Driver.get().get(ConfigurationReader.getProperty("env"));
    }
    @When("user enters username Test")
    public void user_enters_username_test() {
        webtableLoginPage.username.sendKeys(ConfigurationReader.getProperty("username"));
    }
    @When("user enters password Tester")
    public void user_enters_password_tester() {
        webtableLoginPage.password.sendKeys(ConfigurationReader.getProperty("password"));
    }
    @When("user clicks to login button")
    public void user_clicks_to_login_button() {
        webtableLoginPage.loginBtn.click();
    }
    @Then("user should see url contains orders")
    public void user_should_see_url_contains_orders() {
       Assert.assertTrue(Driver.get().getCurrentUrl().contains("orders"));
    }

    @When("user enters username incorrect")
    public void userEntersUsernameIncorrect() {
        webtableLoginPage.username.sendKeys("inccorrect");
    }

    @And("user enters password incorrect")
    public void userEntersPasswordIncorrect() {
        webtableLoginPage.password.sendKeys("inccorect");
    }

    @Then("user should see url contains login")
    public void userShouldSeeUrlContainsLogin() {
        Assert.assertTrue(Driver.get().getCurrentUrl().contains("login"));
    }

    @When("user enters username {string}")
    public void user_enters_username(String username) {
        webtableLoginPage.username.sendKeys(username);
    }
    @When("user enters password {string}")
    public void user_enters_password(String password) {
        webtableLoginPage.password.sendKeys(password);
    }

    @When("user enters username {string} password {string} and logins")
    public void user_enters_username_password_and_logins(String username, String password) {
        webtableLoginPage.login(username,password);
    }

    @When("user enters below credentials")
    public void user_enters_below_credentials(Map<String,String> credentials) {
        webtableLoginPage.login(credentials.get("username"),credentials.get("password"));
    }

}
