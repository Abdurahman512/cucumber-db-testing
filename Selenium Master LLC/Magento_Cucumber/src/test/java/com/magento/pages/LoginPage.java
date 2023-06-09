package com.magento.pages;

import com.magento.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(css = "#username")
    public WebElement username;
    @FindBy(xpath = "//input[@name='login[password]']")
    public WebElement password;
    @FindBy(xpath = "//input[@value='Login']")
    public WebElement loginBtn;
    @FindBy(xpath = "//a[@class='link-logout']")
    public WebElement logoutBtn;
}
