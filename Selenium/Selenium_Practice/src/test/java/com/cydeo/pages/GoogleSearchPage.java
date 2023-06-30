package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.print.PageFormat;

public class GoogleSearchPage {

    public GoogleSearchPage(){

        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(name = "q")
    public WebElement searchBox;


}
