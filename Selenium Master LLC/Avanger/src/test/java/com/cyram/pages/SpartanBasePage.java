package com.cyram.pages;

import com.cyram.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public abstract class SpartanBasePage {

    public SpartanBasePage(){
        PageFactory.initElements(Driver.get(),this);
    }
}
