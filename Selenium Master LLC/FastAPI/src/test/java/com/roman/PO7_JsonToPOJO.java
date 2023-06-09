package com.roman;

import com.roman.pojo.Spartan;
import com.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class PO7_JsonToPOJO extends SpartanTestBase {

    @Test
    public void getSingleSpartan(){

        Response response = given().accept(ContentType.JSON)
                .pathParam("id", 10)
                .when()
                .get("/spartans/{id}")
                .then()
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.JSON)
                .extract().response();

        // First Approach -->  Response.as()

        Spartan spartran = response.as(Spartan.class);
        System.out.println(spartran);
        System.out.println(spartran.getId());
        System.out.println(spartran.getName());

        // Secound Approach --> JsonPath

        JsonPath jsonPath = response.jsonPath();
        Spartan spartan = jsonPath.getObject("", Spartan.class);
        System.out.println(spartan);
        System.out.println(spartan.getId());
        System.out.println(spartan.getName());


    }
    @Test
    public void searchSpartans(){
        Response response = given().accept(ContentType.JSON)
                .queryParam("nameContains", "f")
                .queryParam("gender", "Female")
                .when()
                .get("/spartans/search")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON.toString())
                .extract().response();


    }
}
