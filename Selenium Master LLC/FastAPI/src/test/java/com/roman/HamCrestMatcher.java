package com.roman;


import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class HamCrestMatcher {
    @Test
    public void getAllRegion(){
        given()
                .accept(ContentType.JSON)
        .when()
                .get("/regions")
        .then()
                .statusCode(200)
                .contentType(ContentType.JSON.toString())
                .header("Date",notNullValue())
                .body("items[0].region_name",is("Europe"))
                .body("items.region_name",containsInRelativeOrder("Europe","America","Asia","Middle East and Africa"))
                .body("items.region_id",containsInRelativeOrder(1,2,3,4))
        ;
    }

}
