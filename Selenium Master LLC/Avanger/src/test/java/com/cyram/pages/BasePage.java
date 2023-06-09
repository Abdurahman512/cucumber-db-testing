package com.cyram.pages;

import com.cyram.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

import java.awt.print.PageFormat;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }
}
