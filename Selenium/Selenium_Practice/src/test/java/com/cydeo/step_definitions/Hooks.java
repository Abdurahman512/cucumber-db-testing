package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setupScenario(){
        System.out.println("Setting up browser using cucumber @Befor each scenario");
    }

    @Before(value = "@db")
    public void setupDBScenario(){
        System.out.println("Setting up DB using cucumber @Befor each scenario");
    }
    @After
    public void teardownScenario(Scenario scenario){
       // System.out.println("It will be closing browser using cucumber @After each scenario");

        if (scenario.isFailed()){
           byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
           scenario.attach(screenshot,"image/png",scenario.getName());
        }

        Driver.closeDriver();
    }


}
