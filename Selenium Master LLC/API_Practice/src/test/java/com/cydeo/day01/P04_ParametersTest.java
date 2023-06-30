package com.cydeo.day01;

import com.cydeo.utilitiy.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class P04_ParametersTest extends SpartanTestBase {

    @DisplayName("GET/spartan/{id} with path param")
    @Test
    public void pathParam(){
        Response response = given().accept(ContentType.JSON)
                .pathParam("id", 5)
                .when()
                .get("/spartans/{id}");



        assertEquals(HttpStatus.SC_OK,response.statusCode());
        assertEquals(ContentType.JSON.toString(),response.contentType());
        System.out.println("name = " + response.path("name"));
        System.out.println("response.path(\"gender\") = " + response.path("gender"));
        assertEquals("Female",response.path("gender"));
        System.out.println("response.path(\"phone\") = " + response.path("phone"));
    }

    @Test
    public void queryParam(){

        Map<String,String> queryMap = new HashMap<>();
        queryMap.put("nameContains", "e");
        queryMap.put("gender", "Female");

        Response response = given().accept(ContentType.JSON)

                .queryParams(queryMap)
              //  .queryParam("nameContains", "e")
                //.queryParam("gender", "Female")
                .when()
                .get("/spartans/search");

        int totalElement = response.path("totalElement");
        System.out.println("totalElement = " + totalElement);

        String firstName = response.path("content.name[0]");
        System.out.println("firstName = " + firstName);

        int id = response.path("content.id[1]");
        System.out.println("id = " + id);

        String lastName = response.path("content[-1].name");
        System.out.println("lastName = " + lastName);

        List<String> names = response.path("content.name");
        for(String name : names){
            System.out.println("name = " + name);
            assertEquals(HttpStatus.SC_OK,response.statusCode());
            assertEquals(ContentType.JSON.toString(),response.contentType());
        }
    }
    @Test
    public void negativeTest(){

        Response response = given().accept(ContentType.JSON)
                .pathParam("id", 500)
                .when()
                .get("/spartans/{id}");

        int statusCode = response.statusCode();
        System.out.println("statusCode = " + statusCode);

        assertEquals(HttpStatus.SC_NOT_FOUND,response.statusCode());
        assertEquals(ContentType.JSON.toString(),response.contentType());
        assertTrue(response.asString().contains("Not Found"));

    }
}
