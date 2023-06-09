package com.name.tests.day4_post_request;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

public class ZipCodeApiTest {

    @BeforeClass
    public static void setUp(){
        baseURI = "http://api.zippopotam.us/us/";
    }
    @Test
    public void verifyCityByZipCodeTest(){
        Response response = given().accept("application/json").when()
                .get("22102");
        response.prettyPrint();

        assertEquals(200,response.statusCode());
        assertEquals("application/json",response.contentType());

        assertEquals("Mc Lean",response.path("places[0].'place name'"));
        assertEquals("Virginia",response.path("places[0].state"));

        JsonPath json = response.jsonPath();
        System.out.println(json.getString("country"));
        System.out.println(json.getString("places[0].'place name'"));

        //verify city and state using de-serialization with Java collections
        Map<String, String> jsonMap = response.as(Map.class);
        System.out.println("country ="+jsonMap.get("country"));

        Map<String,Object> placeInfo = json.getMap("places[0]");
        System.out.println("City ="+placeInfo.get("place name"));
    }

    //
}
