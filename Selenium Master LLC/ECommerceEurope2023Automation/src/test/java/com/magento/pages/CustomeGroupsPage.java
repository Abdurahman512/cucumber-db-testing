package com.magento.pages;

import com.github.javafaker.Faker;
import com.magento.utilities.BrowserUtils;
import com.magento.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import java.awt.print.PageFormat;

public class CustomeGroupsPage {

    Faker faker = new Faker();
    String gName = faker.book().title();
    Assertion assertions = new Assertion();
    public CustomeGroupsPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "(//span[.='Customers'])[1]")
    public WebElement customersLink;

    @FindBy(xpath = "//a[.='Customer Groups']")
    public WebElement customerGroupsLink;

    @FindBy(xpath = "(//span[.='Add New Customer Group'])[1]")
    public WebElement addNewCustomerGroupButton;

    @FindBy(id = "customer_group_code")
    public WebElement groupNameField;

    @FindBy(xpath = "(//span[.='Save Customer Group'])[1]")
    public WebElement saveCustomerGroupButton;

    @FindBy(xpath = "//span[.='The customer group has been saved.']")
    public WebElement successMessage;

    @FindBy(xpath = "//span[.='The customer group has been deleted.']")
    public WebElement deleteSuccessMessage;

    @FindBy(xpath = ("(//span[.='Delete Customer Group'])[1]"))
    public WebElement deleteCustomerGroupButton;


    public void navigateTo(){
        BrowserUtils.hover(customersLink);
        customerGroupsLink.click();
    }
    public void addNewCustomerGroups(){
       navigateTo();
       BrowserUtils.waitFor(2);
      // BrowserUtils.clickWithJS(addNewCustomerGroupButton);
        addNewCustomerGroupButton.click();
        groupNameField.sendKeys(gName);
        BrowserUtils.waitFor(2);
        saveCustomerGroupButton.click();
    }

    public void verifyAddedNewCustomerGroup(){
        String text = successMessage.getText();
        System.out.println(text);
        // verify that new customer groups added
        assertions.assertEquals("The customer group has been saved.", text);
    }

    public void clickGroupName(String gName){
        WebElement groupName = Driver.get().findElement(By.xpath("//td[normalize-space(text())='"+gName+"']"));
        groupName.click();
    }
    public void updateCustomerGroup(){
        navigateTo();
        BrowserUtils.waitFor(2);
        clickGroupName(gName);
        //groupName.click();
        groupNameField.clear();
        groupNameField.sendKeys("bosch");
        saveCustomerGroupButton.click();
    }
    public void deleteCustomerGroup(){
        navigateTo();
        clickGroupName(gName);
        deleteCustomerGroupButton.click();
        Alert alert = Driver.get().switchTo().alert();
        alert.accept();
    }

    public void verifyDeleteCustomerGroup(){
        String text = deleteSuccessMessage.getText();
        System.out.println(text);
        // verify that new customer groups added
        assertions.assertEquals("The customer group has been deleted.", text);
    }
}
