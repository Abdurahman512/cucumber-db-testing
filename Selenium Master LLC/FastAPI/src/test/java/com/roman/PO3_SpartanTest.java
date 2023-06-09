package com.roman;

import com.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;


public class PO3_SpartanTest extends SpartanTestBase {


        /*
   1. Send request to Spartan url and save the response
   2. Accept application/json
   3.GET/spartans
   4. Store the response in Response Object that comes from get Request
   5. Print out followings
         - response
         - Content-Type
         - Status Code
         - Get me first spartan gender
         - Get me first spartan name
         - Get me first all spartan name
    */
        @Test
        public void getAllSpartans(){
            Response response = given().log().all().accept(ContentType.JSON)
                    .when().get("/spartans");

            System.out.println(response.prettyPrint());
            assertEquals(ContentType.JSON,response.contentType());
            assertEquals(HttpStatus.SC_OK,response.statusCode());

            String gender = response.path("[0].gender");
            String gender1 = response.path("gender[0]");

            System.out.println("response.path(\"name[0]\") = " + response.path("name[0]"));

            List<String> names = response.path("name");
        }

        @Test
    public void searchSpartans(){
            given()
                    .log().all()
                    .queryParam("gender","Female")
                    .queryParam("nameContains","f")
            .when()
                    .get("/spartans/search").prettyPeek()
            .then()
                    .log().ifValidationFails()
                    .statusCode(200)
                    .contentType(ContentType.JSON.toString())
                    .body("totalElemet",is(4))
                    .body("content",hasSize(4))
                    .body("content.name",hasItem("Alfy"))
                    .body("content.gender",everyItem(is("Female")));

        }
}
