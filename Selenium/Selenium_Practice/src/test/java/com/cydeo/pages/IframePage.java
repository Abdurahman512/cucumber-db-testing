package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IframePage {

    public IframePage(){

        PageFactory.initElements(Driver.get(),this);
    }
    @FindBy(xpath = "//p[.='Your content goes here.']")
    public WebElement contentTextArea;
    @FindBy(xpath = "//h3[contains(text(),'TinyMCE')]")
    public WebElement headerText;
    @FindBy(id = "mce_0_ifr")
    public WebElement iframe;
}
