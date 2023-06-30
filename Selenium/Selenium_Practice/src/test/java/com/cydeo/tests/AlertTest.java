package com.cydeo.tests;

import com.cydeo.pages.AlertPage;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest {

    AlertPage alertPage = new AlertPage();

    @Test
    public void alerttest(){

        Driver.get().get("https://practice.cydeo.com/javascript_alerts");
        alertPage.jsButton.click();

        Alert alert = Driver.get().switchTo().alert();
        alert.sendKeys("Hello");
        alert.accept();

        String actualText = alertPage.resultText.getText();
        System.out.println(actualText);
        String expectedText = "You entered: Hello";

        Assert.assertEquals(actualText,expectedText);

    }
}
