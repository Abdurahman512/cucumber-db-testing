import com.bookit.utilities.BookItApiUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyStepdefs {
    String token;
    @Given("I logged Bookit api using {string} and {string}")
    public void iLoggedBookitApiUsingAnd(String email, String password) {
        token = BookItApiUtils.generateToken(email,password);
    }

    @When("I get the current user information from api")
    public void iGetTheCurrentUserInformationFromApi() {
    }

    @Then("status code should be {int}")
    public void statusCodeShouldBe(int arg0) {
    }
}
