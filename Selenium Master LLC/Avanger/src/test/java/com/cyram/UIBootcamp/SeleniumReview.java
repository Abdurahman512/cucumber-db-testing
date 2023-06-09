package com.cyram.UIBootcamp;

import com.cyram.utilities.ConfigurationReader;
import com.cyram.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SeleniumReview {

    WebDriverWait wait;


    @BeforeMethod
    public void setUp(){

        Driver.get().manage().window().maximize();
        Driver.get().get(ConfigurationReader.get("webTable.url"));
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(Driver.get(),10);

    }

    @AfterMethod
    public void teardown(){
        Driver.closeDriver();
    }

    @Test
    public void test1(){
        Driver.get().findElement(By.xpath("//input[@type='text']")).sendKeys(ConfigurationReader.get("web.table.username"));
        Driver.get().findElement(By.xpath("//input[@type='password']")).sendKeys(ConfigurationReader.get("web.table.pw"));
        Driver.get().findElement(By.xpath("//button[@type='submit']")).click();

        System.out.println("Driver.get().getTitle() = " + Driver.get().getTitle());

        Assert.assertEquals("Cydeo Web Table App",Driver.get().getTitle());
    }
}
