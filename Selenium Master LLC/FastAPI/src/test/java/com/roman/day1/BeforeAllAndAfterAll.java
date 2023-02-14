package com.cydeo.day1;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class BeforeAllAndAfterAll {
    @BeforeAll
    public static void init(){
        baseURI = "http://3.91.96.199:1000";
        basePath= "/ords/hr";
    }
    @AfterAll
    public static void destroy(){
        reset();
    }
    /*
   1. Send request to HR url and save the response
   2. Get/regions
   3. Store the response in Response Object that comes from get Request
   4. Print out followings
         - Headers
         - Content-Type
         - Status Code
         - Response
         - Date
         - Verify response body has "Europe"
         - Verify response body has Date
    */
    @Test
    public void simpleTest(){

        Response response = RestAssured.get("/regions");

        // prettyPeek() prints info screen response headers information and returns RESPONSE, it helps us to chain methods
        //System.out.println("response.prettyPeek() = " + response.prettyPeek());

        // prettyPrint() prints only response body into screen
        // System.out.println("response.prettyPrint() = " + response.prettyPrint());

        //  System.out.println("response.headers() = " + response.headers());
        // System.out.println("response.getHeaders() = " + response.getHeaders());

        //System.out.println("response.getContentType() = " + response.getContentType());
        //System.out.println("response.contentType() = " + response.contentType());

        //System.out.println("response.statusCode() = " + response.statusCode());
        // System.out.println("response.getStatusCode() = " + response.getStatusCode());

        // Date
        //System.out.println("response.header(\"Date\") = " + response.header("Date"));
        assertTrue(response.headers().hasHeaderWithName("Date"));

        assertTrue(response.asString().contains("Europe"));
    }
    @Test
    public void getOneEmployee(){
        /*
        1. Send request to HR url and save the respone
        2. Get/employees/100
        3. Store the response in Response Object that comes from get Request
        4. Print out followings
             - First Name
             - Last Name
             - Verify status code is 200
             - Verify First Name is "Steven"
             - Verify content-Type is application/json
                      */

        // Send request to HR url and save the respone
        Response response = RestAssured.get("/employees/100").prettyPeek();

        // System.out.println("response.prettyPrint() = " + response.prettyPrint());
        System.out.println("response.path(\"first_name\") = " + response.path("first_name"));

        System.out.println("response.path(\"last_name\") = " + response.path("last_name"));

        // Verify First Name is "Steven"
        assertEquals(response.path("first_name"),"Steven");

        assertEquals(response.path("last_name"),"King");

        //Verify status code is 200
        assertEquals(200, response.statusCode());
        assertEquals(HttpStatus.SC_OK,response.statusCode());

        // Verify content-Type is application/json
        assertEquals("application/json", response.contentType());
        assertEquals(ContentType.JSON.toString(),response.contentType());
    }

}
