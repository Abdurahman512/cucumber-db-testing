package com.roman.day1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class P01_SimpleGetRequest {

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

        Response response = RestAssured.get("http://3.91.96.199:1000/ords/hr/regions");

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
        Assertions.assertTrue(response.headers().hasHeaderWithName("Date"));

        Assertions.assertTrue(response.asString().contains("Europe"));
    }

}
