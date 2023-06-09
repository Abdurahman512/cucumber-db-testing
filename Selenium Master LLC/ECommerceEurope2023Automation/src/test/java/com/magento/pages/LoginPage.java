package com.magento.pages;

import com.magento.utilities.ConfigurationReader;
import com.magento.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "username")
    public WebElement userNameField;

    @FindBy(id = "login")
    public WebElement passwordField;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement loginButton;

    public void login(){


        userNameField.sendKeys(ConfigurationReader.getProperty("cususername"));
        passwordField.sendKeys(ConfigurationReader.getProperty("password"));
        loginButton.click();
    }
}
