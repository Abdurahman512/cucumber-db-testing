package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExplicitWaitPage {

    public ExplicitWaitPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//button[.='Start']")
    public WebElement startBtn;
    @FindBy(id = "username")
    public WebElement userName;
    @FindBy(id = "pwd")
    public WebElement password;
    @FindBy(xpath = "//button[.='Submit']")
    public WebElement submitBtn;
    @FindBy(id = "flash")
    public WebElement resultText;
    @FindBy(xpath = "//strong[.='Done!']")
    public WebElement doneMsg;
    @FindBy(xpath = "//img[@class='rounded mx-auto d-block']")
    public WebElement image;


}
