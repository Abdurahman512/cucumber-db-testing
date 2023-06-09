package com.name.step_definitions;

import com.name.utilities.ConfigurationReader;
import com.name.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Google_Steps {

    @Given("browser is open")
    public void browser_is_open() {
        
    }
    @And("user is on google search page")
    public void user_is_on_google_search_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }
    @When("user enters a text in search box")
    public void user_enters_a_text_in_search_box() {
        System.out.println("Java");
    }
    @When("hits enter")
    public void hits_enter() {
        System.out.println("hit");
    }
    @Then("user is navigated to search results")
    public void user_is_navigated_to_search_results() {
        System.out.println("result");
    }
}
