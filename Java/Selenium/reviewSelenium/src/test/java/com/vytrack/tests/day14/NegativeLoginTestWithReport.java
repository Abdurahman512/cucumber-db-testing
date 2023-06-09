package com.vytrack.tests.day14;

import com.vytrack.pages.LoginPage;
import com.vytrack.tests.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {

    @Test
    public void wrongPasswordTest(){
        extentLogger=report.createTest("Wrong Password Test");
        LoginPage loginPage= new LoginPage();
        extentLogger.info("Enter Username :user1");
        loginPage.usernameInput.sendKeys("user1");
        extentLogger.info("Enter Password : somepassword");
        loginPage.passwordInput.sendKeys("somepassword");
        extentLogger.info("Click login Button");
        loginPage.loginBtn.click();

        extentLogger.info("Verify Page URL");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");
        extentLogger.pass("Wrong Password Test is Passed");
    }
    @Test
    public void wrongUsername(){
        extentLogger=report.createTest("Wrong Username Test");
        LoginPage loginPage= new LoginPage();
        extentLogger.info("Enter Wrong Username: someusername");
        loginPage.usernameInput.sendKeys("someuser");
        extentLogger.info("Enter Password: UserUser123");
        loginPage.passwordInput.sendKeys("UserUser123");
        extentLogger.info("Click Login Button");
        loginPage.loginBtn.click();

        extentLogger.info("Verify Page URL");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");
        extentLogger.pass("Passed");
    }
}
