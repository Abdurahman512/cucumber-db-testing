package com.roman.day02;

import com.utilities.HrTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class ResponsePath extends HrTestBase {
    /*
    Given
          accept type is application/json
    When
          user sends get request to /regions/2
    Then
          response status code must be 200
          content type equals to application/json
          response body contains Americas
          region_id is 2
          print all link
     */

    @Test
    public void singleRegion(){
        Response response = given().accept(ContentType.JSON)
                .and()
                .pathParam("id", 2)
                .when().get("/regions/{id}")
                .prettyPeek();

        assertEquals(HttpStatus.SC_OK,response.statusCode());
        assertEquals(ContentType.JSON.toString(),response.contentType());
        assertEquals("Americas",response.path("region_name"));
        assertEquals(2, (Integer) response.path("region_id"));

        // print all the link
        List<Map<String, String>> links = response.path("links");
        for (Map<String, String> eachLink : links) {
            System.out.println(eachLink.get("rel"));
            System.out.println(eachLink.get("href"));

            // get me all href
            List<String> allHref = response.path("links.href");
            System.out.println(allHref);

        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/regions.csv",numLinesToSkip = 1)
    public void parameterizedTest(int id, String regionName){

        System.out.println(id+" ----> "+regionName);

        Response response = given().accept(ContentType.JSON)
                .pathParam("id", 2)
                .when().get("/regions/{id}");

        assertEquals(200,response.statusCode());
        assertEquals(regionName,response.path("region_name"));
        assertEquals(id, (Integer) response.path("region_id"));

    }
}
