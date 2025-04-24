package qa.weborder.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import qa.weborder.pages.WebOrderLoginPage;
import utils.DriverHelper;

public class WebOrderLoginSteps {
    WebDriver driver = DriverHelper.getDriver();
    WebOrderLoginPage webOrderLoginPage = new WebOrderLoginPage(driver);

    @When("User provides username {string} and password {string}")
    public void user_provides_username_and_password(String username, String password) {
        webOrderLoginPage.login(username, password);
    }

    @When("User selects Remember Me CheckBox and Clicks Login Button")
    public void user_selects_remember_me_check_box_and_clicks_login_button() {
        webOrderLoginPage.rememberMeAndLoginButton();
    }

    @Then("User validates the title {string}")
    public void user_validates_the_title(String expectedTitle) {
        Assert.assertEquals(expectedTitle, driver.getTitle());
    }

    @Then("User validates the {string} from Login Page")
    public void user_validates_the_from_login_page(String expectedMessage) {
        webOrderLoginPage.validateErrorMessageForNegativeLogin(expectedMessage);

    }

}
