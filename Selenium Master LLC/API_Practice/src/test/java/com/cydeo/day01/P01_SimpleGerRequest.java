package com.cydeo.day01;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class P01_SimpleGerRequest {


    @Test
    public void simpleTest(){

        Response response = RestAssured.get("http://50.19.174.10:1000/ords/hr/regions");

        System.out.println("response.getHeaders() = " + response.getHeaders());

        System.out.println("response.contentType() = " + response.contentType());
        System.out.println("response.statusCode() = " + response.statusCode());
        System.out.println("response.header(\"Date\") = " + response.header("Date"));

        Assertions.assertTrue(response.headers().hasHeaderWithName("Date"));

        Assertions.assertTrue(response.asString().contains("Europe"));
    }

    @DisplayName("GET/employees/100")
    @Test
    public void getOneEmployee(){

        Response response = RestAssured.get("http://50.19.174.10:1000/ords/hr/employees/100");

        String firstName = response.path("first_name");
        System.out.println("first_name = " + firstName);

        String lastName = response.path("last_name");
        System.out.println("lastName = " + lastName);

        Assertions.assertEquals(HttpStatus.SC_OK,response.statusCode());

        Assertions.assertEquals("Steven",firstName);

        Assertions.assertEquals(ContentType.JSON.toString(),response.contentType());



    }
}
