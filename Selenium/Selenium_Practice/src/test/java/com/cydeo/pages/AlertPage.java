package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertPage {

    public AlertPage(){

        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//button[.='Click for JS Prompt']")
    public WebElement jsButton;
    @FindBy(id = "result")
    public WebElement resultText;

}
