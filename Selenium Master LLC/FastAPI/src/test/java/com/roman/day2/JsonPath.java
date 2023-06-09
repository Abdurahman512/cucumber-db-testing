package com.roman.day2;

import com.utilities.HrTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import java.util.List;

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
    public void getLocations(){
        Response response = given().accept(ContentType.JSON)
                .when().get("/locations");

        // response status code must be 200
        assertEquals(HttpStatus.SC_OK,response.statusCode());
        System.out.println(response.statusCode());
        // content type equals to application/json
        assertEquals(ContentType.JSON.toString(),response.contentType());
        System.out.println(response.contentType());

        io.restassured.path.json.JsonPath jsonPath = response.jsonPath();
        // get the second city with JsonPath
        System.out.println(jsonPath.getString("items[1].city"));

        // get the last city with JsonPath
        System.out.println(jsonPath.getString("items[-1].city"));

        // get all country ids
        List<String> ids = jsonPath.getList("items.country_id");
        System.out.println(ids);

        // get all city where their country id is UK
        List<String> allCityUK = jsonPath.getList("items.findAll {it.country_id=='UK'}.city");
        System.out.println(allCityUK);
    }
    @Test
    public void grtSalary(){
        Response response = given().accept(ContentType.JSON)
                .when().get("/employees");

        System.out.println(response.statusCode());
        io.restassured.path.json.JsonPath jsonPath = response.jsonPath();
        List<String> firstNames = jsonPath.getList("items.findAll {it.salary>15000}.first_name");
        System.out.println(firstNames);
    }
}
