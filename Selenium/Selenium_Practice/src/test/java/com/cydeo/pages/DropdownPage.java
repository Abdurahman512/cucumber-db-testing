package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DropdownPage {

    public DropdownPage(){

        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(id = "state")
    public WebElement stateDropdown;
    @FindBy(id = "year")
    public WebElement yearDropdown;
    @FindBy(id = "month")
    public WebElement monthDropdown;
    @FindBy(id = "day")
    public WebElement dayDropdown;
    @FindBy(name = "Languages")
    public WebElement languagesDropdown;

}
