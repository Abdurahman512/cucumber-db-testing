package com.name.tests.day01_get_request;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.junit.Assert.*;
import org.junit.Test;

public class PetStoreOrderTest {
    String baseUrl = "https://petstore.swagger.io/v2/store";

    @Test
    public void inventoryTest(){
       Response response = RestAssured.get(baseUrl+"/inventory");
        System.out.println("response = " + response.statusCode());
        System.out.println("response = " + response.asPrettyString());
    }
    @Test
    public void orderIdTEstWithUrlParam(){
        Response response = RestAssured.get(baseUrl+"/order/7");
        System.out.println("response = " + response.statusCode());
        response.prettyPrint();
        assertEquals(200,response.statusCode());

    }
}
