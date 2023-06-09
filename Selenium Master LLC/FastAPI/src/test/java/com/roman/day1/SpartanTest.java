package com.roman.day1;

import com.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;


public class SpartanTest extends SpartanTestBase {
    /*
   1. Send request to Spartan url and save the response
   2. Accept application/json
   3.GET/spartans
   4. Store the response in Response Object that comes from get Request
   5. Print out followings
         - response
         - Content-Type
         - Status Code
         - Get me first spartan gender
         - Get me first spartan name
         - Get me first all spartan name
    */
    @Test
    public void getAllSpartan(){

        Response response = given().log().uri().accept(ContentType.JSON)
                .when().get("/spartans");
        //response.prettyPrint();

        // Content-Type
        System.out.println("response.contentType() = " + response.contentType());
        assertEquals(ContentType.JSON.toString(),response.contentType());
        assertEquals("application/json",response.contentType());

        // Status Code
        System.out.println("response.statusCode() = " + response.statusCode());
        assertEquals(HttpStatus.SC_OK,response.statusCode());
        assertEquals(200,response.statusCode());

        // Get me first spartan gender
        System.out.println("response.path(\"[0].gender\") = " + response.path("[0].gender"));

        // Get me first spartan name
        List<String> allName = response.path("name");
        System.out.println("allName = " + allName);

        //System.out.println("response.path(\"[0].name\") = " + response.path("[0].name"));
        //System.out.println("response.path(\"name[0]\") = " + response.path("name[0]"));

        // Get me first all spartan name
        System.out.println("response.path(\"name\") = " + response.path("name"));
    }
}
