package spartan.step_defs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import spartan.pages.HomePage;
import spartan.utilities.BrowserUtils;
import spartan.utilities.ConfigurationReader;
import spartan.utilities.DBUtils;
import spartan.utilities.Driver;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class SpartanSteoDefs {

    HomePage homePage = new HomePage();
    int randomSpartan;
    @Given("user is an the spartan home page")
    public void user_is_an_the_spartan_home_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("user clicks on any random spartan")
    public void user_clicks_on_any_random_spartan() {
        int sizeOfAllSpartans = homePage.allSpartans.size();

        Random random = new Random();
        randomSpartan = random.nextInt(sizeOfAllSpartans);

        homePage.getSpartan(randomSpartan).click();
        BrowserUtils.waitFor(3);

    }

    @Then("spartan info should be same with DB")
    public void spartanInfoShouldBeSameWithDB() {
        String query = "select * from spartans where SPARTAN_ID = '"+randomSpartan+"'";
        Map<String, Object> rowMap = DBUtils.getRowMap(query);
        System.out.println(rowMap);
    }
}
