package com.roman;

import com.utilities.SpartanTestBase;
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

public class PO4_ParametersTest extends SpartanTestBase {
    /*
   1. Given accept type is Json
   2. Path Parameters value is id -> 5
   3. When users sends GET request to /spartans{id}
   4. Verify followings
         - Status Code Should be 200
         - Content-Type is application/json
         - ID is 5
         - Name is "Blythe"
         - Gender is "Female"
         -phone is 3677539542
    */

    @DisplayName("GET/ spartans/{id} with param example")
    @Test
    public void pathParam(){
        Response response = given().log().all().accept(ContentType.JSON)
                .pathParam("id",5)
                .when().get("/spartans{id}");

        response.prettyPrint();

        assertEquals(HttpStatus.SC_OK,response.statusCode());
        assertEquals(ContentType.JSON.toString(), response.contentType());

        int id = response.path("id");
        String name = response.path("name");
        String gender = response.path("gender");
        long phone = response.path("phone");

        assertEquals(5,id);
        assertEquals("Female", gender);
        assertEquals("3677539542l",phone);

    }
    @Test
    public void queryParam(){

        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("nameContains","e");
        queryMap.put("gender","Famale");

        Response response = given().accept(ContentType.JSON)
                .queryParams(queryMap)
                .when().get("/spartans/search").prettyPeek();

        System.out.println("response.path(\"totalElement\") = " + response.path("totalElement"));

        System.out.println("response.path(\"content.name[0]\") = " + response.path("content.name[0]"));
        System.out.println("response.path(\"content[1].id\") = " + response.path("content[1].id"));
        System.out.println("response.path(\"content[-1].name\") = " + response.path("content[-1].name"));
        List<String> allNames = response.path("content.name");
        System.out.println("allNames = " + allNames);

        assertEquals(200,response.statusCode() );

    }

    @DisplayName("Negative Test")
    @Test
    public void negativeTest(){

        Response response = given().accept(ContentType.JSON)
                .pathParam("id", 500)
                .when().get("/spartans/{id}").prettyPeek();

        assertEquals(404,response.statusCode());
        assertEquals(HttpStatus.SC_OK,response.statusCode());

        assertEquals("application/json",response.contentType());
        assertEquals(ContentType.JSON.toString(),response.contentType());

        assertTrue(response.toString().contains("Not Found"));

        assertEquals("Not Found", response.path("error"));

    }
}
