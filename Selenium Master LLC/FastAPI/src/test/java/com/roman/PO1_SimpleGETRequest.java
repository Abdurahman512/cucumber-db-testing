package com.roman;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.common.assertion.Assertion;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PO1_SimpleGETRequest {

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

    @DisplayName("GET/employees/100")
    @Test
    public void getOneEmployee() {

        Response response = RestAssured.get("http://3.91.96.199:1000/ords/hr/employees/100").prettyPeek();
        String first_name = response.path("first_name");
        System.out.println(first_name);
        String last_name = response.path("last_name");

        Assertions.assertEquals(200,response.statusCode());
        Assertions.assertEquals(HttpStatus.SC_OK,response.statusCode());

        Assertions.assertEquals("Steven",first_name);

        Assertions.assertEquals("application/json",response.contentType());
        Assertions.assertEquals(ContentType.JSON.toString(), response.contentType());




    }
}
