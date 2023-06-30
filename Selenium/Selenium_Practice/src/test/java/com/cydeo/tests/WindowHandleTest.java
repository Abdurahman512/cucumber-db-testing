package com.cydeo.tests;

import com.cydeo.pages.WindowHandlePage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class WindowHandleTest {

    WindowHandlePage windowHandlePage = new WindowHandlePage();

    @Test
    public void windowHandleTest(){

        Driver.get().get("https://practice.cydeo.com/windows");

        Assert.assertEquals(Driver.get().getTitle(),"Windows");

        String currentWindow = Driver.get().getWindowHandle();
        System.out.println(currentWindow);

        windowHandlePage.clickHereLink.click();
        windowHandlePage.cydeoLink.click();

        Set<String> allWindowsHandle = Driver.get().getWindowHandles();

        for (String eachWindow : allWindowsHandle) {
            Driver.get().switchTo().window(eachWindow);

            System.out.println(Driver.get().getTitle());

            if (Driver.get().getTitle().equals("Cydeo")){
                break;
            }
        }

        BrowserUtils.waitFor(5);
        Assert.assertEquals(Driver.get().getTitle(),"Cydeo");

        Driver.get().switchTo().window(currentWindow);
        Assert.assertEquals(Driver.get().getTitle(),"Windows");

    }
}
