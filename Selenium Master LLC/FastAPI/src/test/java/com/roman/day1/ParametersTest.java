package com.roman.day1;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class ParametersTest extends SpartanTest {
    /*
   1. Given accept type is Json
   2. Path Parameters value is id -> 5
   3. When users sends GET request to /spartans{id}
   4. Verify followings
         - Status Code Should be 200
         - Content-Type is application/json
         - ID is 5
         - Name is "Blythe"
         - Gender is "Female"
         -phone is 3677539542
    */
    @DisplayName("Get /spaertans/{id} with path param example")
    @Test
    public void pathParamTest() {

        // Given accept type is Json
        Response response = given().log().uri().accept(ContentType.JSON)
                .pathParams("id", 5)
                .when().get("/spartans/{id}");

        // Status Code Should be 200
        assertEquals(HttpStatus.SC_OK, response.statusCode());

        // Content-Type is application/json
        assertEquals(ContentType.JSON.toString(), response.contentType());

        // ID is 5
        assertEquals("5", response.path("id").toString());

        // Name is "Blythe"
        assertEquals("Blythe", response.path("name"));

        // Gender is "Female"
        assertEquals("Female", response.path("gender"));

        // phone is 3677539542
        long phone = response.path("phone");
        assertEquals(3677539542l, phone);
    }
    @Test
    public void queryParam(){
      /*
   1. Given accept type is Json
   2. Query Parameters value are
          - gender -> Female
          - nameContains -> e
   3. When users sends GET request to /spartans/search
   4. Print followings
         - Total Element Number
         - Get me first spartan name
         - Get me second spartan id
         - Get me last spartan name
         - Get me all spartan name
   5. Verify followings
         - Status Code Should be 200
    */

        Map<String, String> queraMap = new HashMap<>();
        queraMap.put("nameContains","e");
        queraMap.put("gender","Female");

        Response response = given().log().uri().accept(ContentType.JSON)
                // .queryParam("nameContains", "e")
                // .queryParam("gender", "Female")
                .queryParams(queraMap)
                .when().get("/spartans/search");

        // Total Element Number
        System.out.println("response.path(\"totalElement\") = " + response.path("totalElement"));

        // Get me first spartan name
        System.out.println("response.path(\"content[0].name\") = " + response.path("content[0].name"));

        // Get me second spartan id
        System.out.println("response.path(\"content[1].id\") = " + response.path("content[1].id"));

        // Get me last spartan name
        System.out.println("response.path(\"content[-1].name\") = " + response.path("content[-1].name"));

        // Get me all spartan name
        System.out.println("response.path(\"content.name\") = " + response.path("content.name"));

        assertEquals(HttpStatus.SC_OK,response.statusCode(),"NOT 200");
    }

    /*
    Given accept type is Json
    And Id parameter value is 500
    When user sends GET request to /api/spartans/{id}
    Then response status code should be 404
    And response content-type: application/json
    And "Not Found" message should be in response payload
     */
    @Test
    public void negativeTest(){
        Response response = given().accept(ContentType.JSON)
                .pathParam("id", 500)
                .when().get("/spartans{id}");

        System.out.println("response.statusCode() = " + response.statusCode());
        System.out.println("response.contentType() = " + response.contentType());
        System.out.println("response.path(\"error\") = " + response.path("error"));
    }


}