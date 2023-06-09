package com.roman.day3;

import com.roman.pojo.Campus;
import com.utilities.BookitTestBase;
import com.utilities.BookitUtils;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Bookit extends BookitTestBase {
    /*
    Deserialization Exerecise
        send a request to get all campuses
        verify status code 200
        create an POJO to get all data
            find out how many campus we have
            find out how many clusterwe have in VA
            find out how many room we have in light.side
     */
    @Test
    public void getCampuses(){

       String email = "blyst6@si.edu";
       String password = "barbabaslyst";

        // GET TOKEN
       String token = BookitUtils.getToken(email,password);

        //GET CAMPUSES
        JsonPath jsonPath = given().accept(ContentType.JSON)
                .header("Authorization", token)
                .when().get("/api/campuses")
                .then().statusCode(200)
                .contentType(ContentType.JSON)
                .extract().jsonPath();

        // do De-serialization
        List<Campus> allCampuses = jsonPath.getList("", Campus.class);
        System.out.println(allCampuses);

        // how many campus we have
        System.out.println("allCampuses.size() = " + allCampuses.size());

        // how many clusterwe have in VA
        System.out.println("Cluster= " + allCampuses.get(0).getClusterList().size());

        // how many room we have in light.side
        System.out.println("Room = "+allCampuses.get(0).getClusterList().get(0).getRoomList().size());

        // all romms where capacity is 6
        
    }
}
