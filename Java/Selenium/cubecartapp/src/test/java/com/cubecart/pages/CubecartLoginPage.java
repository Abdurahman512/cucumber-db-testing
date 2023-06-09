package com.cubecart.pages;

import com.cubecart.utilities.ConfigurationReader;
import com.cubecart.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CubecartLoginPage {

    public CubecartLoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    public void login(){
        username.sendKeys("testautomation1");
        password.sendKeys("automation123!");
        loginBtn.click();
    }
    @FindBy(xpath="//input[@id='username']")
    public WebElement username;
    @FindBy(xpath="//input[@id='password']")
    public WebElement password;
    @FindBy(xpath="//input[@id='login']")
    public WebElement loginBtn;
}
