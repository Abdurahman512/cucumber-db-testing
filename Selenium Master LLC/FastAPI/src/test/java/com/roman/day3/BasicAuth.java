package com.roman.day3;

import com.utilities.SpartanAuthTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class BasicAuth extends SpartanAuthTestBase {

    /*
    Role Based Access Control  --> RBAC
       which right, action we have?

    ADMIN   --  GET   POST   PUT   PATCH   DELETE
    EDITOR  --  GET   POST   PUT   PATCH   403
    USER    --  GET   403    403   403     403
    GUEST   --  401   401    401   401     401
     */

   @Test
   public void negativeTest(){

       given().accept(ContentType.JSON)
               .pathParam("id",5)
               .when().get("/spartans{id}").prettyPeek()
               .then().statusCode(401) // Unauthorized User
               .body("error",is("Unauthorized"));
   }

   @Test
    public void getSpartanAsUser(){

       given().log().all().accept(ContentType.JSON)
               .pathParam("id",5)
               .auth().basic("user","user")
               .when().get("spartans/{id}").prettyPeek()
               .then().statusCode(200);
   }

   @Test
    public void deleteSpartan(){

       given().accept(ContentType.JSON)
               .pathParam("id",5)
               .auth().basic("editor","editor")
               .when().delete("/spartans/{id}").prettyPeek()
               .then().statusCode(403)
               .body("error",is("Forbidden"));
   }
   /*
   Create one DDT Test to do RBAC

   @ParameterizedTest
   @CSVFileSource
   @Test
public void getSpartans(String username, String password, int statusCode){

       given().log().all().accept(ContentType.JSON)
               .pathParam("id",5)
               .auth().basic(username,password)
               .when().get("spartans/{id}").prettyPeek()
               .then().statusCode(statusCode);
   }
   Create one csv file to put under resource as getSpartans.csv
        admin, admin, 200
        editor, editor, 200
        user, user, 200
        guest. guest, 401

    */



}
