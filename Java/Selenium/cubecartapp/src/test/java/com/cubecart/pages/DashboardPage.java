package com.cubecart.pages;

import com.cubecart.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

    public DashboardPage(){
        PageFactory.initElements(Driver.get(),this);
    }
    @FindBy(xpath="//ul[@class='submenu']//a[.='Newsletters']")
    public WebElement newslettersBtn;
    @FindBy(xpath = "//a[.='Create Newsletter']")
    public WebElement createNewsletterBtn;
    @FindBy(css = "#email_subject")
    public WebElement subjectBox;
    @FindBy(css = "#sender_name")
    public WebElement sendersName;
    @FindBy(css = "#sender_email")
    public WebElement sendersEmail;

    @FindBy(xpath = "//a[.='HTML Content']")
    public WebElement htmlContent;

    @FindBy(css = "#cke_1_contents")
    public WebElement htmlContentBox;

    @FindBy(xpath = "//a[.='Plain Text Content']")
    public WebElement plainTextContent;
    @FindBy(css = "#content_text")
    public WebElement plainTextContentBox;
    @FindBy(xpath = "//a[.='Send Test Email']")
    public WebElement sendTestEmailBtn;
    @FindBy(css = "#email_test")
    public WebElement recipientEmailBox;
    @FindBy(xpath = "//input[@value='Save & Send']")
    public WebElement saveAndsendBtn;
    @FindBy(xpath = "//div[.='Newsletter Saved.']")
    public WebElement resultText;
}
