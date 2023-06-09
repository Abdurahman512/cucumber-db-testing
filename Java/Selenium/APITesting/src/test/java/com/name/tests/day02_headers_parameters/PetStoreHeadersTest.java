package com.name.tests.day02_headers_parameters;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;
import static io.restassured.RestAssured.*;   // static restassured
import static org.junit.Assert.*;
public class PetStoreHeadersTest {
    String baseUrl = "https://petstore.swagger.io/v2/store";
    @Test
    public void inventoryHeadersTest(){

        given().accept("pplication/json").
                when().get(baseUrl+"/inventory").
                then().statusCode(200).
                and().contentType("application/json");

        // same test with using Response object
        Response response = given().accept("application/json").when().get(baseUrl+"/inventory");
        assertEquals(200,response.statusCode());
        assertEquals("application/json",response.contentType());
    }
    @Test
    public void navigateOrderTest(){
        given().header("accept-type","application/json").
                when().get(baseUrl+"/order/3000").
                then().statusCode(404).
                and().contentType("application/json");
    }
}
