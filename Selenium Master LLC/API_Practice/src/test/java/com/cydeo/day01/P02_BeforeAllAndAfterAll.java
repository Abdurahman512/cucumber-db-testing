package com.cydeo.day01;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class P02_BeforeAllAndAfterAll {

    @BeforeAll
    public static void init(){
        baseURI="http://50.19.174.10:1000";
        basePath= "/ords/hr";
    }
    @AfterAll
    public static void destroy(){
        RestAssured.reset();
    }

    @Test
    public void simpleTest(){

        Response response = get("/regions");

        System.out.println("response.getHeaders() = " + response.getHeaders());

        System.out.println("response.contentType() = " + response.contentType());
        System.out.println("response.statusCode() = " + response.statusCode());
        System.out.println("response.header(\"Date\") = " + response.header("Date"));

        assertTrue(response.headers().hasHeaderWithName("Date"));

        assertTrue(response.asString().contains("Europe"));
    }

    @DisplayName("GET/employees/100")
    @Test
    public void getOneEmployee(){

        Response response = get("/employees/100");

        String firstName = response.path("first_name");
        System.out.println("first_name = " + firstName);

        String lastName = response.path("last_name");
        System.out.println("lastName = " + lastName);

        assertEquals(HttpStatus.SC_OK,response.statusCode());

        assertEquals("Steven",firstName);

        assertEquals(ContentType.JSON.toString(),response.contentType());



    }
}
