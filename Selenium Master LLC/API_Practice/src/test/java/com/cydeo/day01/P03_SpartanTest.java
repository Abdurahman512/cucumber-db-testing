package com.cydeo.day01;

import com.cydeo.utilitiy.SpartanTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class P03_SpartanTest extends SpartanTestBase {

    @Test
    public void getAllSpartansTest(){

        Response response = given().log().uri().accept(ContentType.JSON)
                .when().get("/spartans");

        assertEquals(HttpStatus.SC_OK,response.statusCode());
        assertEquals(ContentType.JSON.toString(),response.contentType());

        System.out.println("[0].gender = " + response.path("[0].gender"));
        System.out.println("name[0] = " + response.path("name[0]"));

        List<String> allNames = response.path("name");
        System.out.println("allNames.size() = " + allNames.size());

        for(String name : allNames){
            System.out.print(name+" | ");
        }


    }
}
