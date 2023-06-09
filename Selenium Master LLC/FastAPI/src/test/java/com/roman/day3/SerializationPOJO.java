package com.roman.day3;

import com.roman.pojo.Spartan;
import com.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class SerializationPOJO extends SpartanTestBase {

    @Test
    public void postSpartan(){
        Spartan spartan = new Spartan();
        spartan.setName("POST POJO");
        spartan.setGender("Male");
        spartan.setPhone(1234123434L);

        System.out.println(spartan);

        given().log().body().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(spartan)
        .when()
                .post("spartans")
        .then()
                .statusCode(201);


    }
}
