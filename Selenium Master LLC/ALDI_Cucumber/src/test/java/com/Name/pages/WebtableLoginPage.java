package com.Name.pages;

import com.Name.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.print.PageFormat;

public class WebtableLoginPage {
    public WebtableLoginPage (){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@type='text']")
    public WebElement username;
    @FindBy(name = "password")
    public WebElement password;
    @FindBy(xpath = "//button[.='Login']")
    public WebElement loginBtn;


    public void login(){
        username.sendKeys("Test");
        password.sendKeys("Tester");
        loginBtn.click();
    }

    public void login(String user_name, String passWord){
        username.sendKeys(user_name);
        password.sendKeys(passWord);
        loginBtn.click();
    }

}
