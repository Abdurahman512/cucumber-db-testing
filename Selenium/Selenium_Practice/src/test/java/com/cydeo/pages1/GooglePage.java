package com.cydeo.pages1;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GooglePage {

    public GooglePage(){
        PageFactory.initElements(Driver.get(),this);
    }
    @FindBy(name = "q")
    public WebElement searchBox;
    @FindBy(xpath = "//div[@class='kp-header']//a[@class='FLP8od']")
    public WebElement capitalResult;
}
