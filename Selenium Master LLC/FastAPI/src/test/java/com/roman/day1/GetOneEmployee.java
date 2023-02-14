package com.cydeo.day1;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GetOneEmployee {

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
        Response response = RestAssured.get("http://3.91.96.199:1000/ords/hr/employees/100").prettyPeek();

       // System.out.println("response.prettyPrint() = " + response.prettyPrint());
        System.out.println("response.path(\"first_name\") = " + response.path("first_name"));

        System.out.println("response.path(\"last_name\") = " + response.path("last_name"));

        // Verify First Name is "Steven"
        Assertions.assertEquals(response.path("first_name"),"Steven");

        Assertions.assertEquals(response.path("last_name"),"King");

        //Verify status code is 200
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals(HttpStatus.SC_OK,response.statusCode());

        // Verify content-Type is application/json
        Assertions.assertEquals("application/json", response.contentType());
        Assertions.assertEquals(ContentType.JSON.toString(),response.contentType());
    }
}
