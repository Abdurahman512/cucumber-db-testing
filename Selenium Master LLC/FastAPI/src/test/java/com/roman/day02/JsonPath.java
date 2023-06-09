package com.roman.day02;

import com.utilities.HrTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;


public class JsonPath extends HrTestBase {

    /*
    Given
          accept type is application/json
    When
          user sends get request to /locations
    Then
          response status code must be 200
          content type equals to application/json
          get the second city with JsonPath
          get the last city with JsonPath
          get all country ids
          get all city where their country id is UK
     */
    @Test
    public void getlocation(){
        Response response = given().accept(ContentType.JSON).
                and()
                .when().get("/locations");

        assertEquals(HttpStatus.SC_OK,response.statusCode());
        assertEquals(ContentType.JSON.toString(),response.contentType());

        io.restassured.path.json.JsonPath jsonPath = response.jsonPath();


    }
}
