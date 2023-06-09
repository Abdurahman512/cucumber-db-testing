package com.cyram.UIBootcamp;

import com.cyram.pages.LoginPage;
import com.cyram.utilities.ConfigurationReader;
import com.cyram.utilities.Driver;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BasicNavigationWithTestNG {

    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage = new LoginPage();
    @BeforeMethod
    public void setUp(){

        driver = Driver.get();
        driver.manage().window().maximize();
        driver.get(ConfigurationReader.get("webTable.url"));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,10);

    }

    @AfterMethod
    public void teardown(){
        Driver.closeDriver();
    }

    @Test
    public void test1(){
        Point locationOfUserName = loginPage.userNameBox.getLocation();
        int y_coordinateOfUserName = locationOfUserName.getY();
        System.out.println("y_coordinateOfUserName = " + y_coordinateOfUserName);
        int y_coordinateOfPassword = loginPage.passwordBox.getLocation().getY();
        System.out.println("y_coordinateOfPassword = " + y_coordinateOfPassword);
        int y_coordinateOfLoginButton = loginPage.loginBtn.getLocation().getY();
        System.out.println("y_coordinateOfLoginButton = " + y_coordinateOfLoginButton);

        Assert.assertTrue(y_coordinateOfUserName<y_coordinateOfPassword);
        Assert.assertTrue(y_coordinateOfPassword<y_coordinateOfLoginButton);
    }
}
