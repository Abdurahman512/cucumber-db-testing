package com.roman.day2;

import com.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class JsonToJava extends SpartanTestBase {
    /*
    Given accept type is application/json
    And path param id = 10
    When I send GET request ro /api/spartans
    Then status code should be 200
    And content type is json
    And spartan data matching:
          id -- 10
          name -- Lorenze
          gender  -- Female
          phone  -- 3312820936
     */
    @Test
    public void test(){
        Response response =
        given().accept(ContentType.JSON)
                .pathParam("id", 10)
        .when().get("/spartans/{id}")
        .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().response();

        // First Approach --  Response
        System.out.println("**** First Approach --  Response.path() ***");
       // Map<String, Object> spartanMap = response.as(Map.class);  // as tring to use deserilization

        Map<String, Object> spartanMap = response.path("");
        System.out.println(spartanMap);
        int id = (int) spartanMap.get("id");
        System.out.println("id = " + id);
        String name = (String) spartanMap.get("name");
        System.out.println("name = " + name);

        System.out.println("___ Second Approach --  Response -- JsonPath ___");
        JsonPath jsonPath = response.jsonPath();

        Map<String, Object> spMap = jsonPath.getMap("");
        int id1 = (int) spMap.get("id");
        String name1 = (String) spMap.get("name");

        System.out.println("id1 = " + id1);
        System.out.println("name1 = " + name1);
    }
    @Test
    public void getAllSpartans(){

        System.out.println("**** First usage --  Response.path() ***");
        Response response =
                        given()
                .accept(ContentType.JSON)
                        .when()
                .get("/spartans")
                        .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract().response();

        List<Map<String,Object>> allSpartans = response.path("");  // path("") means whatever we have in the response
        // print out spartans
        for (Map<String, Object> eachSpartan : allSpartans) {
            System.out.println(eachSpartan);
        }
        System.out.println("*********************");
        // find me first spartan info
        System.out.println("First Spartan Info "+allSpartans.get(0));

        // find me first spartan name
        System.out.println("*********************");
        Map<String, Object> firstSpartan = allSpartans.get(0);
        String name = (String) firstSpartan.get("name");
        System.out.println(name);

        System.out.println(allSpartans.get(0).get("name"));

        System.out.println("___ Second usage --  Response -- JsonPath ___");

        JsonPath jsonPath = response.jsonPath();
        List<Map<String, Object>> listOfAllSpartan = jsonPath.getList("");
        for (Map<String, Object> eachSpartan1 : listOfAllSpartan) {
            System.out.println(eachSpartan1);
        }

        System.out.println("*********************");
        // First spartan
        System.out.println(listOfAllSpartan.get(0));
        // find me first spartan name
        System.out.println(listOfAllSpartan.get(0).get("name"));


    }


}
