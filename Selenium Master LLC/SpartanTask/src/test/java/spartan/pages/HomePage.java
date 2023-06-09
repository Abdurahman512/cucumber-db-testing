package spartan.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import spartan.utilities.Driver;

import java.util.List;

public class HomePage extends BasePage {


    @FindBy (xpath = "//tbody//tr")
    public List<WebElement> allSpartans;

    public WebElement getSpartan (int id){
        return Driver.get().findElement(By.id("view_spartan_"+id));
    }
}
