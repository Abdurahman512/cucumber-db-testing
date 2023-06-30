package com.cydeo.tests;

import com.cydeo.pages.ExplicitWaitPage;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExplicitWaitTest {

    ExplicitWaitPage explicitWaitPage = new ExplicitWaitPage();
    WebDriverWait wait = new WebDriverWait(Driver.get(),15);

    @Test
    public void dynamocLoad1(){

        Driver.get().get("https://practice.cydeo.com/dynamic_loading/1");
        explicitWaitPage.startBtn.click();
        wait.until(ExpectedConditions.visibilityOf(explicitWaitPage.userName));

        Assert.assertTrue(explicitWaitPage.userName.isDisplayed());

        explicitWaitPage.userName.sendKeys("tomsmith");
        explicitWaitPage.password.sendKeys("incorrect");

        explicitWaitPage.submitBtn.click();

        Assert.assertTrue(explicitWaitPage.resultText.isDisplayed());

        Driver.closeDriver();
    }

    @Test
    public void dynamicLoad7(){
        Driver.get().get("https://practice.cydeo.com/dynamic_loading/7");
        wait.until(ExpectedConditions.titleIs("Dynamic title"));

        Assert.assertTrue(explicitWaitPage.doneMsg.isDisplayed());

        Assert.assertTrue(explicitWaitPage.image.isDisplayed());
        Driver.closeDriver();
    }
}
