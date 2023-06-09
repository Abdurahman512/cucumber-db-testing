package com.roman.day2;

import com.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class SpartanTest extends SpartanTestBase {
    /*
    Send a request to GET/spartans/search
    Query parameters value are
         gender            --- Female
         nameContains      --- f
    Log Everything
    Verify followings
        status code is 200
        content type is application/json
        total element 13
        jsonArray size hasSize 13
        names hasItem "Alfy"
        every gender is Female
     */
    @Test
    public void searchSpartans(){

        given().log().all()
                .queryParam("gender","Female")
                .queryParam("nameContains","f")
        .when()
                .get("/spartans/search").prettyPeek()
        .then()
                .log().ifValidationFails()  // if any validation fails in then() by using HamCrest it will log detail
                .statusCode(200)
                .contentType(ContentType.JSON.toString())
                .body("totalElement",is(13))
                .body("content",hasSize(13))
                .body("content.name",hasItem("Alfy"))
                .body("content.gender",everyItem(is("Female")));
    }
}
