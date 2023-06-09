package com.roman.day4;

import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class FormulaXML{

    // http://ergast.com/api/f1/drivers
    /*
    Send GET Request / drivers
          first Driver Given Name
          all Drivers Given Name
          print out first driver driverID attribute
          print out all driver driverID attribute
          print out all ariver given name if their nationality is Italian
     */
    @Test
    public void xmlTest(){
        Response response = get("http://ergast.com/api/f1/drivers")
                .then()
                .statusCode(200)
                .extract().response();

        XmlPath xmlPath = response.xmlPath();

       // first Driver Given Name
        // path--> MRData.DriverTable.Driver[0].GivenName
        String firstDriverName = xmlPath.getString("MRData.DriverTable.Driver[0].GivenName");
        System.out.println(firstDriverName);

        // all Drivers Given Name
         // path --> MRData.DriverTable.Driver.GivenName
        List<String> allDriversName = xmlPath.getList("MRData.DriverTable.Driver.GivenName");
        System.out.println(allDriversName.size());

        // print out first driver driverID attribute
         // path --> MRData.DriverTable.Driver[0].@driverId
        String driverID = xmlPath.getString("MRData.DriverTable.Driver[0].@driverId");
        System.out.println(driverID);

        // print out all driver driverID attribute
         // path --> MRData.DriverTable.Driver.@driverId
        List<String> allDriversID = xmlPath.getList("MRData.DriverTable.Driver.@driverId");

        // print out all ariver given name if their nationality is Italian
         // path --> MRData.DriverTable.Driver.findAll (it.Nationality=='Italian').GivenName
        List<String> allItalianDrivers = xmlPath.getList("MRData.DriverTable.Driver.findAll {it.Nationality=='Italian'}.GivenName");
        System.out.println(allItalianDrivers.size());
        System.out.println(allItalianDrivers);

    }
}
