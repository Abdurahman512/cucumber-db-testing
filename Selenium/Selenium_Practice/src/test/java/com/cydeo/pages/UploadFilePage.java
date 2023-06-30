package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UploadFilePage {

    public UploadFilePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "file-upload")
    public WebElement chooceFileBtn;
}
