package com.cyram.APIBootcamp;

import com.cyram.utilities.ConfigurationReader;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class SpartanApiTestsWithTestNG {
    String spartanUrl = ConfigurationReader.get("spartan.apiUrl");

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
}
