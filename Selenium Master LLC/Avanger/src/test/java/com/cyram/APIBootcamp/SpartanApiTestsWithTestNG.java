package com.cyram.APIBootcamp;

import com.cyram.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.testng.Assert.*;

import org.hamcrest.Matchers;
import org.jsoup.select.Evaluator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.*;

public class SpartanApiTestsWithTestNG {
    String spartanUrl = ConfigurationReader.get("spartan.apiUrl");
    String hrUrl = ConfigurationReader.get("hr.apiUrl");

    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON)
                .queryParam("nameContains","Fe")
                .queryParam("gender","Female")
                .get(spartanUrl+"/api/spartans/search")
                .prettyPeek();
        assertEquals(response.statusCode(),200);
        assertEquals(response.contentType(),"application/json");
        assertEquals(response.header("Transfer-Encoding"),"chunked");
        assertTrue(response.headers().hasHeaderWithName("Date"));
        assertEquals(response.body().path("content[0].name"),"Fenelia");

    }
    @Test
    public void test2(){
        // get request to all spartans
        // use jsonpath, Gpath syntax

        Response response = given().accept(ContentType.JSON)
                .get(spartanUrl+"/api/spartans");

        JsonPath jsonPath = response.jsonPath();
        List<String> maleSpartansNames = jsonPath.getList("findAll{it.gender=='Male'}.name");

        System.out.println("maleSpartansNames.size() = " + maleSpartansNames.size());
       // System.out.println("maleSpartansNames = " + maleSpartansNames);

        System.out.println("maleSpartansNames.get(0) = " + maleSpartansNames.get(0));
    }

    @Test
    public void test3(){
        /*

       send a GET request to ords api all regions point
       check all when region_id = 1
       then region_name is equal Europe
         */

        Response response = given().accept(ContentType.JSON)
                .get(hrUrl+"/regions");

        JsonPath jsonPath = response.jsonPath();

        String expectedRegionName = "Europe";
        String actualRegionName = jsonPath.getString("items.findAll{it.region_id==1}.region_name");

        String actualRegionName1 = jsonPath.getString("items.findAll{it.region_id==1}[0].region_name");
        System.out.println("actualRegionName1 = " + actualRegionName1);
        System.out.println("actualRegionName = " + actualRegionName);
        Assert.assertTrue(actualRegionName.contains(expectedRegionName));
        Assert.assertEquals(actualRegionName1,expectedRegionName);
    }

    @Test
    public void test4(){

      // chain methods using HEmcrest Matchers assertions
      given().accept(ContentType.JSON)
              .and().queryParam("nameContains","Fe")
              .queryParam("gender","Female")
     .when()
              .get(spartanUrl+"/api/spartans/search")
      .then()
              .assertThat().statusCode(200)
              .assertThat().body("content[0].name", Matchers.equalTo("Fenelia"))
              .log().all();
    }

    @Test
    public void test5(){

        given().accept(ContentType.JSON)
                .pathParam("id",8)
                .when()
                .get(spartanUrl+"/api/spartans/{id}")
                .then()
                .statusCode(200)
                .and()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("singleSpartan.json"));



    }
}
