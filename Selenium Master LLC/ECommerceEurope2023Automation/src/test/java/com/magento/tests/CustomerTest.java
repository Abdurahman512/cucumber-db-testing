package com.magento.tests;

import com.magento.pages.CustomeGroupsPage;
import com.magento.pages.LoginPage;
import com.magento.utilities.ConfigurationReader;
import com.magento.utilities.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import java.util.concurrent.TimeUnit;

public class CustomerTest {

    Assertion assertions = new Assertion();
    LoginPage loginPage = new LoginPage();
    CustomeGroupsPage customeGroupsPage = new CustomeGroupsPage();

    @BeforeMethod
    public void setUp(){
        Driver.get().manage().window().maximize();
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.get().get(ConfigurationReader.getProperty("backendurl"));
        loginPage.login();
    }
    @AfterMethod
    public void teardown(){
        Driver.closeDriver();
    }

    @Test
    public void addNewCustomerGroup(){

        customeGroupsPage.addNewCustomerGroups();
        customeGroupsPage.verifyAddedNewCustomerGroup();
    }

    @Test
    public void updateCustomerGroup(){
        customeGroupsPage.updateCustomerGroup();
        customeGroupsPage.verifyAddedNewCustomerGroup();
    }

    @Test
    public void deleteCustomerGroup(){
        customeGroupsPage.deleteCustomerGroup();
        customeGroupsPage.verifyDeleteCustomerGroup();
    }
}
