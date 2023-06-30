package com.cydeo.tests;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.print.DocFlavor;

public class GoogleSearchTest {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();

   @Test
    public void googleSearchTest(){

       Driver.get().get(ConfigurationReader.getProperty("url"));

       BrowserUtils.waitFor(1);
       Driver.get().findElement(By.xpath("//div[.='Accept all']")).click();

       googleSearchPage.searchBox.sendKeys("apple"+ Keys.ENTER);

       System.out.println(Driver.get().getTitle());

       Assert.assertEquals(Driver.get().getTitle(),"apple - Google Search");
       Driver.closeDriver();

   }
}
