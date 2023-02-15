package com.Vytrack.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Test {
    @Given("user go to login page")
    public void user_go_to_login_page() {
        System.out.println(1);
    }
    @When("user enters credentials and click login button")
    public void user_enters_credentials_and_click_login_button() {
        System.out.println(2);
    }
    @Then("user should be on dashboard")
    public void user_should_be_on_dashboard() {
        System.out.println(3);
    }




}
