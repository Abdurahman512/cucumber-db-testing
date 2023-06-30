package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActionsPage {

    public ActionsPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "(//img)[1]")
    public WebElement img1;
    @FindBy(xpath = "(//img)[2]")
    public WebElement img2;
    @FindBy(xpath = "(//img)[3]")
    public WebElement img3;

    @FindBy(xpath = "//h5[.='name: user1']")
    public WebElement user1;
    @FindBy(xpath = "//h5[.='name: user2']")
    public WebElement user2;
    @FindBy(xpath = "//h5[.='name: user3']")
    public WebElement user3;

    @FindBy(linkText = "A/B Testing")
    public WebElement abTextLink;
    @FindBy(linkText = "CYDEO")
    public WebElement cydeoLink;
    @FindBy(linkText = "Home")
    public WebElement homeLink;




}
