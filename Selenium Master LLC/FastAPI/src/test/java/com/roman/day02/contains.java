package com.roman.day02;

import com.utilities.HrTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class contains extends HrTestBase {

    /*
    Given
          accept type is application/json
    When
          user sends get request to /regions/2
    Then
          response status code must be 200
          content type equals to application/json
          response body contains Americas
     */

    @Test
    public void getSingleRegions(){
        Response response = given().accept(ContentType.JSON)
                .and()
                .pathParam("id", 2)
                .when().get("/regions{id}").prettyPeek();

        assertEquals(HttpStatus.SC_OK,response.statusCode());
        assertEquals(200,response.statusCode());
        assertEquals(ContentType.JSON.toString(),response.contentType());
        assertEquals("application/json",response.contentType());

        assertTrue(response.asString().contains("Americas"));
    }
}
