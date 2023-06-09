package com.name.tests.day03_json_body_verification;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static io.restassured.RestAssured.*;


public class TypiCodeTask {

    String url = "https://jsonplaceholder.typicode.com/users/1";

    @Test
    public void userDataTest(){
        Response response = given().accept("application/json").when().get(url);
        assertEquals(200,response.statusCode());
        System.out.println("statusCode = " + response.statusCode());

        System.out.println("name = " + response.path("name"));
        System.out.println("username = " + response.path("username"));
        System.out.println("email = " + response.path("email"));

        assertEquals("Leanne Graham",response.path("name"));
        System.out.println("city ="+response.path("address.city"));

        String lat = response.path("address.geo.lat");
        System.out.println("lat ="+lat);
        String expLat ="-37.3159";
        assertEquals(expLat,lat);
        System.out.println("companyName ="+response.path("company.name"));
    }

    @Test
    public void userDataJsonPathTest(){
        Response response = get(url);
        JsonPath json = response.jsonPath();
        System.out.println("name = " + json.getString("name"));
        assertEquals(1,json.getInt("id"));
    }
    @Test
    public void userListTest(){
        Response response = get("https://jsonplaceholder.typicode.com/users");

        // assign response to json object
        JsonPath json = response.jsonPath();
        // we use index [0] when working with json arrays/lists
        // prints whole json for index 0
        System.out.println("json.getString(\"[0]\") = " + json.getString("[0]"));

        // print first users name
        System.out.println("name ="+json.getString("[0].name"));
        // print second users city
        System.out.println("city ="+json.getString("[1].address.city"));
        // store all emails in to List<String>
        List<String> emails = json.getList("email");
        System.out.println("emails.size() = " + emails.size());

        for (String email : emails) {
            System.out.println("email = " + email);
        }
        // assert that each 10 users has an email, count should be 10
        assertEquals(10,emails.size());

        // assert that Sherwood@rosamond.me is among emails
        assertTrue(emails.contains("Sherwood@rosamond.me"));

        // add all cities into List then print out in same line
        List<String> cities = json.getList("address.city");
        System.out.println("cities = " + cities);
    }


}
