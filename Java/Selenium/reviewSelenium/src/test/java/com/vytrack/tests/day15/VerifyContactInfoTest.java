package com.vytrack.tests.day15;

import com.vytrack.pages.ContactInfoPage;
import com.vytrack.pages.ContactsPage;
import com.vytrack.pages.DashboardPage;
import com.vytrack.pages.LoginPage;
import com.vytrack.tests.TestBase;
import com.vytrack.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyContactInfoTest extends TestBase {
    /**
     * open the chrome
     * go to qa1.vytrack
     * login as a sales manager
     * navigate to customers ->contacts
     * click on email mbrackstone9@example.com
     * verify that full name is Mariam Brackstone
     * verify that email is mbrackstone9@example.com
     * verify that phone number is +18982323434
     */
    @Test
    public void contactDetailTest(){
        extentLogger=report.createTest("Contact Info Verification");
        LoginPage loginPage = new LoginPage();
        extentLogger.info("username: "+ ConfigurationReader.get("salesmanager_username")+
                "Password: "+ConfigurationReader.get("salesmanager_password"));
        loginPage.loginAsSalesManager();

        new DashboardPage().navigateToModule("Customers","Contacts");
        extentLogger.info("navigate to customers ->contacts");
        ContactsPage contactsPage = new ContactsPage();
        contactsPage.waitUntilLoaderScreenDisappear();
        contactsPage.getContactEmail("mbrackstone9@example.com").click();
        extentLogger.info("click on email mbrackstone9@example.com");

        ContactInfoPage contactInfoPage=new ContactInfoPage();
        String expectedFullname="Mariam Brackstone";
        String actualFullname=contactInfoPage.fullName.getText();
        Assert.assertEquals(actualFullname,expectedFullname,"Verify Fullname");
        extentLogger.info("verify that full name is Mariam Brackstone");

        Assert.assertEquals(contactInfoPage.email.getText(),
                "mbrackstone9@example.com","Verify Email");
        extentLogger.info("verify that email is mbrackstone9@example.com");

        Assert.assertEquals(contactInfoPage.phone.getText(),"+18982323434","Verify Phone");
        extentLogger.info("verify that phone number is +18982323434");

        extentLogger.pass("Pass");
    }

}
