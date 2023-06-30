package com.cydeo.tests;

import com.cydeo.pages.IframePage;
import com.cydeo.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IframeTest {

    IframePage iframePage = new IframePage();

    @Test
    public void iframeTest(){

        Driver.get().get("https://practice.cydeo.com/iframe");

        Driver.get().switchTo().frame(iframePage.iframe);

        String actualText = iframePage.contentTextArea.getText();
        String expectedText = "Your content goes here.";

        Assert.assertEquals(actualText,expectedText);

        Driver.get().switchTo().defaultContent();
        Assert.assertTrue(iframePage.headerText.getText().contains("TinyMCE"));
    }
}
