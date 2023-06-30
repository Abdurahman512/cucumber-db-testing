package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowHandlePage {

    public WindowHandlePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(linkText = "Click Here")
    public WebElement clickHereLink;

    @FindBy(linkText = "CYDEO")
    public WebElement cydeoLink;
}
