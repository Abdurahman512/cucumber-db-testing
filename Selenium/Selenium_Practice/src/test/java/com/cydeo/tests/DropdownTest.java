package com.cydeo.tests;

import com.cydeo.pages.DropdownPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropdownTest {
    DropdownPage dropdownPage = new DropdownPage();

    @BeforeMethod
    public void setUp(){
        Driver.get().get("https://practice.cydeo.com/dropdown");
    }
    @AfterMethod
    public void teardown(){
        Driver.closeDriver();
    }
    @Test
    public void stateDropdownTest(){

        Select stateSelect = new Select(dropdownPage.stateDropdown);
        stateSelect.selectByVisibleText("Illinois");

        String actualOption = stateSelect.getFirstSelectedOption().getText();
        String expectedOption = "Illinois";
        Assert.assertEquals(actualOption,expectedOption);

        stateSelect.selectByValue("VA");
        actualOption = stateSelect.getFirstSelectedOption().getText();
        expectedOption="Virginia";
        Assert.assertEquals(actualOption,expectedOption);

        stateSelect.selectByIndex(5);
        actualOption = stateSelect.getFirstSelectedOption().getText();
        expectedOption="California";
        Assert.assertEquals(actualOption,expectedOption);

    }

    @Test
    public void dateOfBrithDropdownTest(){

        Select yearSelect = new Select(dropdownPage.yearDropdown);
        yearSelect.selectByVisibleText("1950");

        String actualYearOption = yearSelect.getFirstSelectedOption().getText();
        String expectedYearOption = "1950";
        Assert.assertEquals(actualYearOption,expectedYearOption,"Year NOT pass!");

        Select monthSelect = new Select(dropdownPage.monthDropdown);
        monthSelect.selectByValue("11");
        String actualMothOption = monthSelect.getFirstSelectedOption().getText();
        String expectedMothOption = "December";
        Assert.assertEquals(actualYearOption,expectedYearOption,"moth NOT pass!");

        Select daySelect = new Select(dropdownPage.dayDropdown);
        daySelect.selectByIndex(0);
        String actualDayOption = daySelect.getFirstSelectedOption().getText();
        String expectedDayOption = "1";
        Assert.assertEquals(actualYearOption,expectedYearOption,"day NOT pass!");
    }

    @Test
    public void languagesDropdownTest(){

        Select languageSelct = new Select(dropdownPage.languagesDropdown);
        List<WebElement> languagesOption = languageSelct.getOptions();

        for (WebElement eachOption : languagesOption) {
            languageSelct.selectByVisibleText(eachOption.getText());
            System.out.println(eachOption.getText());
            Assert.assertTrue(eachOption.isSelected(),"NOT selected");
        }
        languageSelct.deselectAll();
        for (WebElement eachOption : languageSelct.getOptions()) {
            Assert.assertTrue(!eachOption.isSelected());
        }

    }
}
