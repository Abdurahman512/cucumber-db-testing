package com.cydeo.tests;

import com.cydeo.pages.UploadFilePage;
import com.cydeo.utilities.Driver;
import org.testng.annotations.Test;

public class UploadFileTest {

    UploadFilePage uploadFilePage = new UploadFilePage();

    @Test
    public void uploadFileTest(){
        Driver.get().get("https://practice.cydeo.com/upload");

        uploadFilePage.chooceFileBtn.sendKeys("");
    }
}
