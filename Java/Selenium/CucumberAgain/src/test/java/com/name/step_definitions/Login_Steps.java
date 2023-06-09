package com.name.step_definitions;

import com.name.utilities.ConfigurationReader;
import com.name.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_Steps {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }
    @When("the user enters <username> and <password>")
    public void the_user_enters_username_and_password() {

    }
    @When("the user clicks on login button")
    public void the_user_clicks_on_login_button() {

    }
    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {
        System.out.println("page");
    }
}
