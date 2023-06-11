package com.cyram.step_definitions;

import com.cyram.pages.pojo.Spartan;
import com.cyram.utilities.ConfigurationReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.Map;

public class AllEnvironment_Steps {
String nameFromAPI;

    @When("User sends a request to spartan API using id {int}")
    public void userSendsARequestToSpartanAPIUsingId(int id) {

        Response response = RestAssured.given().accept(ContentType.JSON)
                .pathParam("id",id)
                .get(ConfigurationReader.get("spartan.apiUrl")+"/api/spartans/{id}");

        Map<String, Object> oneSpartan = response.body().as(Map.class);

        nameFromAPI = (String) oneSpartan.get("name");
        System.out.println("nameFromAPI = " + nameFromAPI);

       Spartan oneSpartanFromPOJO = response.body().as(Spartan.class);
        System.out.println("oneSpartanFromPOJO.getName() = " + oneSpartanFromPOJO.getName());
    }

    @Then("Info of spartan should be same at all environment")
    public void infoOfSpartanShouldBeSameAtAllEnvironment() {
        // verify API and UI
        Assert.assertEquals(nameFromAPI,SpartanUI_Steps.UIname);
        // verify API and DB
        Assert.assertEquals(nameFromAPI,SpartanDB_Steps.DBname);

    }
}
