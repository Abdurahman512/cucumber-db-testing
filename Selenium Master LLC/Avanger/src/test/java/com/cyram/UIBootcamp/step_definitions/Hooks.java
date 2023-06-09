package com.cyram.UIBootcamp.step_definitions;

import com.cyram.utilities.DBUtils;
import com.cyram.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before(value = "@wip")
    public void runFirst(){
        System.out.println("I will run before wip Scenario");
    }
    @Before(value = "@smoke")
    public void runAgain(){
        System.out.println("I will run before smoke Scenario");
    }

    @After
    public void teardownScenario(Scenario scenario){

        //scenario.isFailed() --> if scenario fails this method will return TRUE boolean value

        if (scenario.isFailed()){

            byte [] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        Driver.closeDriver();

        //System.out.println("====Closing browser using cucumber @After");
        //System.out.println("====Scenario ended/ Take screenshot if failed!");
    }

    @Before("@db")
    public void connectDB(){
        DBUtils.createConnection();
    }

    @After("@db")
    public void closeDB(){
        DBUtils.destroy();
    }
}
