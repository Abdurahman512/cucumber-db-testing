package com.cydeo.utilitiy;

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;

public abstract class SpartanTestBase {

    @BeforeAll
    public static void init(){
        baseURI="http://50.19.174.10:8000";
        basePath= "/api";
    }
    @AfterAll
    public static void destroy(){
        RestAssured.reset();
    }
}
