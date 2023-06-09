package spartan.pages;

import org.openqa.selenium.support.PageFactory;
import spartan.utilities.Driver;

import java.awt.print.PageFormat;

public class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }
}
