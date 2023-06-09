package com.cyram.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(name = "username")
    public WebElement userNameBox;
    @FindBy(name = "password")
    public WebElement passwordBox;
    @FindBy(xpath = "//button[.='Login']")
    public WebElement loginBtn;
}
