package com.roman;

import com.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;
import static org.junit.jupiter.api.Assertions.*;



public class PO6_JsonToJava extends SpartanTestBase {

    @Test
    public void getSingleSpartan(){
        Response response =
         given()
                .log().all().accept(ContentType.JSON)
                .pathParam("id", 10)
         .when()
                .get("/spartans/{id}").prettyPeek()
         .then()
                .log().ifValidationFails()
                .statusCode(HttpStatus.SC_OK)
                .contentType(ContentType.JSON.toString())
                .extract().response();

        // first approach --> Response
        //Map<String, Object> spartanMap = response.as(Map.class);

        Map<String,Object> spartanMap = response.path("");
        System.out.println(spartanMap);
        int id = (int) spartanMap.get("id");
        String name = (String) spartanMap.get("name");
        System.out.println(id);
        System.out.println(name);

        // secound approach ---> JsonPath

        JsonPath jsonPath = response.jsonPath();
        Map<String, Object> spMap = jsonPath.getMap("");
        int id1 = (int) spMap.get("id");
        String name1 = (String) spMap.get("name");
        System.out.println(id1);
        System.out.println(name1);


    }

    @Test
    public void getAllSpartan(){

        Response response =

         given()
                .accept(ContentType.JSON)
         .when()
                .get("/spartans")
         .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().response();

        List<Map<String,Object>> allSpartans = response.path("");

        for (Map<String, Object> eachSpartan : allSpartans) {
            System.out.println(eachSpartan);
        }

        System.out.println("First spartan "+allSpartans.get(0));
        Map<String, Object> firstSpartan = allSpartans.get(0);
        String name = (String) firstSpartan.get("name");


        System.out.println("First Spartan name "+allSpartans.get(0).get("name"));


        // secound approach --> JsonPath
        JsonPath jsonPath = response.jsonPath();
        List<Map<String, Object>> spartans = jsonPath.getList("");
        for (Map<String, Object> eachSpartan : spartans) {
            System.out.println(eachSpartan);
        }
        System.out.println(spartans.get(0));
        System.out.println(spartans.get(0).get("name"));


    }
}
