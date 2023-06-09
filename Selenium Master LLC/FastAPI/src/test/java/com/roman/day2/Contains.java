package com.roman.day2;

import com.utilities.HrTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class Contains extends HrTestBase {
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
    public void getSingleRegion(){
        Response response = given().accept(ContentType.JSON)
                                   .pathParam("id", 2)
                            .when().get("regions/{id}");

        assertEquals(200,response.statusCode());
        System.out.println(response.statusCode());

        assertEquals("application/json",response.contentType());
        System.out.println(response.contentType());

       assertTrue(response.asString().contains("Americas"));

        List<Map<String,String>> links = response.path("links");

        for (Map<String, String> eachLink : links) {
            System.out.println(eachLink.get("rel"));
            System.out.println(eachLink.get("href"));
        }

        // get me all href  info
        List<String> allHref = response.path("links.href");
        System.out.println(allHref);

    }
    @ParameterizedTest
    @CsvFileSource(resources = "/regions.csv",numLinesToSkip = 1)
    public void parameterizedTest(int id, String region_name){

        System.out.println(id+" ---- "+region_name);

        Response response = given().accept(ContentType.JSON)
                .pathParams("id", id)
                .when().get("/regions/{id}");

        assertEquals(region_name,response.path("region_name"));
        assertEquals(id, (Integer) response.path("region_id"));
    }
}
