package com.cubecart.step_definitions;

import com.cubecart.pages.LoginPage;
import com.cubecart.utilities.ConfigurationReader;
import com.cubecart.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login_Steps {

    LoginPage loginPage = new LoginPage();

    @Given("user is on the cubecart login page")
    public void user_is_on_the_cubecart_login_page() {
        Driver.get().get(ConfigurationReader.get("qaUrl"));
    }
    @When("user enters valid username and valid password")
    public void user_enters_valid_username_and_valid_password() {
        System.out.println(1);
    }
    @Then("user should be able to successfully login")
    public void user_should_be_able_to_successfully_login() {
        System.out.println(2);
    }


}
