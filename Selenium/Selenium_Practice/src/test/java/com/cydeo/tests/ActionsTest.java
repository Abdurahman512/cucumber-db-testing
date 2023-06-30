package com.cydeo.tests;

import com.cydeo.pages.ActionsPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTest {

    ActionsPage actionsPage = new ActionsPage();
    Actions actions = new Actions(Driver.get());

    @BeforeMethod
    public void setUp(){
        Driver.get().get("https://practice.cydeo.com");
    }
    @AfterMethod
    public void teardown(){
        Driver.closeDriver();
    }
    @Test
    public void actionsTest(){

        Driver.get().get("https://practice.cydeo.com/hovers");

        actions.moveToElement(actionsPage.img1).perform();
        Assert.assertTrue(actionsPage.user1.isDisplayed());

        actions.moveToElement(actionsPage.img2).perform();
        Assert.assertTrue(actionsPage.user2.isDisplayed());

        actions.moveToElement(actionsPage.img3).perform();
        Assert.assertTrue(actionsPage.user3.isDisplayed());

    }
    @Test
    public void rightClickTest(){

        actions.contextClick(actionsPage.abTextLink)
                .sendKeys(Keys.ARROW_DOWN
                ,Keys.ARROW_DOWN,Keys.RETURN).perform();

        Assert.assertEquals(Driver.get().getTitle(),"No A/B Test");

    }
    @Test
    public void jsExecutorScrollingTest(){

        JavascriptExecutor js =((JavascriptExecutor) Driver.get());

        js.executeScript("arguments[0].scrollIntoView(true)",actionsPage.cydeoLink,actionsPage.homeLink);
        BrowserUtils.waitFor(5);
        js.executeScript("arguments[1].scrollIntoView(true)",actionsPage.cydeoLink,actionsPage.homeLink);
        BrowserUtils.waitFor(5);
    }
}
