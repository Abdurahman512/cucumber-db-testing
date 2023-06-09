package com.Name.pages;

import com.Name.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {

    public GoogleSearchPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "q")
    public WebElement searchBox;
    @FindBy(xpath = "//div[@class='kp-header']//a")
    public WebElement capitalResult;

    @FindBy(xpath = "//div[.='Accept all']")
    public WebElement popup;
}
