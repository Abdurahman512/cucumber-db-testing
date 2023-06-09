package com.magento.pages;

import com.magento.utilities.BrowserUtils;
import com.magento.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MarketingDashboardPage {

    public MarketingDashboardPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span[text()='Promotions']")
    public WebElement promotionsLink;
    @FindBy(xpath = "//span[text()='Catalog Price Rules']")
    public WebElement catalogPriceRulesLink ;
    @FindBy(xpath = "(//span[text()='Add New Rule'])[1]")
    public WebElement addNewRoleBtn;
    @FindBy(id = "rule_name")
    public WebElement ruleNameField;
    @FindBy(id = "rule_description")
    public WebElement descriptionField;
    @FindBy(xpath = "//input[@name='from_date']")
    public WebElement fromDateField;
    @FindBy(xpath = "//input[@name='to_date']")
    public WebElement toDateField;
    @FindBy(id = "rule_sort_order")
    public WebElement priorityField;
    @FindBy(xpath = "(//span[text()='Save'])[1]")
    public WebElement saveButton;

    @FindBy(id = "rule_is_active")
    public WebElement status;
    @FindBy(id ="rule_website_ids" )
    public WebElement websites;
    @FindBy(id="rule_customer_group_ids")
    public WebElement customerGroups;
    @FindBy(id = "rule_discount_amount")
    public WebElement discountAmountField;
    @FindBy(xpath = "//span[text()='The rule has been saved.']")
    public WebElement successMessages;
    @FindBy(xpath = "//input[@name='name']")
    public WebElement ruleNameSearchField;
    @FindBy(xpath = "//span[text()='Search']")
    public WebElement searchBtn;
    @FindBy(xpath = "(//table[@id='promo_catalog_grid_table']//tbody//td[contains(text(),'My-Rule')])[1]")
    public WebElement editRuleName;



    public void clickCatalogPriceRulesLink() {
       /*
        testUtility.waitForElementPresent(promotionsLink);
        actions.moveToElement(promotionsLink).click().perform();
        testUtility.sleep(2);
        testUtility.waitForElementPresent(catalogPriceRulesLink);
        actions.moveToElement(catalogPriceRulesLink).click().perform();
*/
        BrowserUtils.hover(promotionsLink);
        BrowserUtils.hover(catalogPriceRulesLink);
        catalogPriceRulesLink.click();

    }
    public void addNewCatalogPriceRule(String ruleName,String description ,String priority ){
/*
        clickCatalogPriceRulesLink();
        testUtility.waitForElementPresent(addNewRoleBtn);
        addNewRoleBtn.click();
        testUtility.waitForElementPresent(ruleNameField);
        ruleNameField.sendKeys(ruleName);
        testUtility.waitForElementPresent(descriptionField);
        descriptionField.sendKeys(description);
        Select dropDownStatus = new Select(status);
        dropDownStatus.selectByVisibleText("Active");
        Select dropDownWebsites=new Select(websites);
        dropDownWebsites.selectByIndex(1);
        Select dropDownGroups=new Select(customerGroups);
        dropDownGroups.selectByValue("1");
        testUtility.waitForElementPresent(fromDateField);
        fromDateField.sendKeys("04/12/2023");
        testUtility.waitForElementPresent(toDateField);
        toDateField.sendKeys("04/19/2023");
        testUtility.waitForElementPresent(priorityField);
        priorityField.sendKeys(priority);

        testUtility.waitForElementPresent(saveButton);
        actions.moveToElement(saveButton).build().perform();
        saveButton.click();
        testUtility.sleep(2);
        discountAmountField.sendKeys("50%");
        saveButton.click();
*/
        clickCatalogPriceRulesLink();
        addNewRoleBtn.click();
        ruleNameField.sendKeys(ruleName);
        descriptionField.sendKeys(description);
        Select dropDownStatus = new Select(status);
        dropDownStatus.selectByVisibleText("Active");
        Select dropDownWebsites=new Select(websites);
        dropDownWebsites.selectByIndex(1);
        Select dropDownGroups=new Select(customerGroups);
        dropDownGroups.selectByValue("1");
        fromDateField.sendKeys("04/12/2023");
        toDateField.sendKeys("04/19/2023");
        priorityField.sendKeys(priority);
        BrowserUtils.waitFor(2);
        BrowserUtils.hover(saveButton);
        saveButton.click();
        discountAmountField.sendKeys("50%");
        saveButton.click();

    }
    public boolean verifyAddNewCatalogPriceRuleSuccessfully() {
        if (Driver.getDriver().getPageSource().contains(successMessages.getText())) {
            System.out.println("Marketing Manager can Add New Catalog Price Rule Test is Passed!!!");
            return true;
        } else {
            System.out.println("Marketing Manager can Add New Catalog Price Rule Test is Failed!!!");
            return false;
        }
    }

    public void updatedCatalogPriceRule(String ruleName, String updatedRuleName ){
        clickCatalogPriceRulesLink();
        BrowserUtils.waitFor(1);
        ruleNameSearchField.sendKeys(ruleName);
        searchBtn.click();
        BrowserUtils.waitFor(1);
        editRuleName.click();
        ruleNameField.sendKeys(updatedRuleName);
        saveButton.click();

    }
    public boolean verifyupdateNewCatalogPriceRuleSuccessfully() {
        if (Driver.getDriver().getPageSource().contains(successMessages.getText())) {
            System.out.println("Marketing Manager can Add New Catalog Price Rule Test is Passed!!!");
            return true;
        } else {
            System.out.println("Marketing Manager can Add New Catalog Price Rule Test is Failed!!!");
            return false;
        }
    }


}
