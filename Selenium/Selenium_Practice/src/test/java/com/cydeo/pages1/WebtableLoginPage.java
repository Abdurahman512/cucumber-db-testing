package com.cydeo.pages1;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebtableLoginPage {

    public WebtableLoginPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//input[@name='username']")
    public WebElement username;
    @FindBy(name = "password")
    public WebElement password;
    @FindBy(xpath = "//button[.='Login']")
    public WebElement loginBtn;

    public void login(String user_name, String passWord){
        username.sendKeys(user_name);
        password.sendKeys(passWord);
        loginBtn.click();
    }

}
