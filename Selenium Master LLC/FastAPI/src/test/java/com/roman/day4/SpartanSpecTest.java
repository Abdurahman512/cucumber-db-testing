package com.roman.day4;

import com.utilities.SpartanAuthTestBase;
import com.utilities.SpartanTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SpartanSpecTest extends SpartanAuthTestBase {
    @Test
    public void test1(){
        given().spec(requestSpecification("admin","admin"))
        .when()
                .get("/spartans")
        .then()
                .spec(responseSpecification(200));
    }
    @Test
    public void test2(){
        given()
                .spec(requestSpecification("user","user"))
                .pathParam("id",2)
        .when()
                .get("/spartans/{id}")
        .then()
                .spec(responseSpecification(200));
    }

    /*
    Create GET_RBAC.csv
    username, password, id, statusCode
    admin, admin, 3, 200
    editor, editor 3 200
    user, user, 3 ,200
    guest, guest, 3, 401

    Create a parameterized test to check RBAC for GET method
     */
    @Test
    // negative Test Case

    public void test3(){

        given()
                .spec(requestSpecification("user","user"))
                .pathParam("id",2)
                .when()
                .delete("/spartans/{id}")
                .then()
                .spec(responseSpecification(403));
    }

    @Test
    public void test4(){

    }
}
