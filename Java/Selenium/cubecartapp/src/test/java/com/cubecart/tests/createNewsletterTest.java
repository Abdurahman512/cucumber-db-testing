package com.cubecart.tests;

import com.cubecart.pages.CubecartLoginPage;
import com.cubecart.pages.DashboardPage;
import com.cubecart.utilities.ConfigurationReader;
import com.cubecart.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class createNewsletterTest {

    DashboardPage dashboardPage = new DashboardPage();
    CubecartLoginPage cubecartLoginPage = new CubecartLoginPage();

    @BeforeMethod
    public void setup(){
        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void teardown(){
        Driver.closeDriver();
    }
    @Test
    public void createNewsletterTest() throws InterruptedException {
        cubecartLoginPage.login();
        Thread.sleep(1000);
        dashboardPage.newslettersBtn.click();
        dashboardPage.createNewsletterBtn.click();
        dashboardPage.subjectBox.sendKeys("Weather");
        dashboardPage.sendersName.sendKeys("Alim");
        dashboardPage.sendersEmail.sendKeys("alim@gmail.com");
        dashboardPage.htmlContent.click();

        WebElement iframe = Driver.get().findElement(By.xpath("//iframe[@title='Rich Text Editor, content_html']"));
        Driver.get().switchTo().frame(iframe);
       // WebDriverWait wait = new WebDriverWait(Driver.get(),10);
        //wait.until(ExpectedConditions.visibilityOf(dashboardPage.htmlContentBox));

        dashboardPage.htmlContentBox.sendKeys("the weather is today very well.");

        Driver.get().switchTo().defaultContent();
        dashboardPage.plainTextContent.click();
        dashboardPage.plainTextContentBox.sendKeys("the sun shining so so so!");
        dashboardPage.sendTestEmailBtn.click();
        dashboardPage.recipientEmailBox.sendKeys("ali@gmail.com");
        dashboardPage.saveAndsendBtn.click();





    }


}
