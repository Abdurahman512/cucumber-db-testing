package com.roman.day2;

import com.roman.pojo.Search;
import com.roman.pojo.Spartan;
import com.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class JsonToPOJO extends SpartanTestBase {

    @Test
    public void getSingleSpartan(){
        Response response =
                given().accept(ContentType.JSON)
                        .pathParam("id", 10)
               .when()
                        .get("/spartans/{id}")
               .then()
                        .statusCode(200)
                        .contentType(ContentType.JSON)
                        .extract().response();

        /*
        {
    "id": 10,
    "name": "Lorenza",
    "gender": "Female",
    "phone": 3312820936
}
         */

        System.out.println("**** First Approach --  Response.as() ***");
        Spartan spartan = response.as(Spartan.class);
        System.out.println(spartan);
        System.out.println(spartan.getId());
        System.out.println(spartan.getName());


        System.out.println("___ Second Approach -- JsonPath ___");

        JsonPath jsonPath = response.jsonPath();
        Spartan sparta = jsonPath.getObject("", Spartan.class);
        System.out.println(sparta);
        System.out.println(sparta.getGender());
        System.out.println(sparta.getPhone());
    }
    @Test
    public void searchSpartans(){
        Response response = given().accept(ContentType.JSON)
                .queryParam("nameContains", "f")
                .queryParam("gender", "Female")
                .when().get("/spartans/search")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON.toString())
                .extract().response();

        System.out.println("**** First Approach --  JsonPath ***");
        // we are not use response.as() method to get partial of response as POJO class
        // it dose not have path parameter to do it

        JsonPath jsonPath = response.jsonPath();
        Spartan spartan = jsonPath.getObject("content[0]", Spartan.class);
        System.out.println(spartan);
        System.out.println(spartan.getId());
    }
    @Test
    public void searchSpartanPOJO(){

        Response response = given().accept(ContentType.JSON)
                .queryParam("nameContains", "f")
                .queryParam("gender", "Female")
                .when().get("/spartans/search")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON.toString())
                .extract().response();

        JsonPath jsonPath = response.jsonPath();
        Search search = jsonPath.getObject("", Search.class);


        // total element
        System.out.println(search.getTotalElement());
        /*
        // how many spartan we have
        List<Spartan> content = search.getContent();
        System.out.println(search.getContent().size());

        // first spartan info
        System.out.println(content.get(0));

        // first spartan name
        System.out.println(content.get(0).getName());
         */

        // how many spartan we have
        List<Spartan> allSpartans = search.getAllSpartans();
        System.out.println(allSpartans);

        System.out.println(allSpartans.get(0));
        // first spartan name
        System.out.println(allSpartans.get(0).getName());
    }
}
