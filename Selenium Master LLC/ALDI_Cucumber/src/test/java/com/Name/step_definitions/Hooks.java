package com.Name.step_definitions;

import com.Name.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setUpScenario(){
        System.out.println("Cucumber @Before");
    }
    @Before(value="db")
    public void setUpBDScenario(){
        System.out.println("Database Cucumber @Before");
    }

    @After
    public void teardownScenario(Scenario scenario){
        System.out.println("Cucumber @After");

        if (scenario.isFailed()){
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png",scenario.getName());
        }
        Driver.closeDriver();

    }
}
