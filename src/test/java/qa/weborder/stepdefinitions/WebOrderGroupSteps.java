package qa.weborder.stepdefinitions;

import io.cucumber.java.en.*; // * will import for everything
import org.openqa.selenium.WebDriver;
import qa.weborder.pages.WebOrderGroupPage;
import qa.weborder.pages.WebOrderLoginPage;
import utils.ConfigReader;
import utils.DriverHelper;

public class WebOrderGroupSteps {

    WebDriver driver = DriverHelper.getDriver();
    WebOrderLoginPage webOrderLoginPage = new WebOrderLoginPage(driver);
    WebOrderGroupPage webOrderGroupPage = new WebOrderGroupPage(driver);

    @Given("User provides username and password to the Login Page")
    public void user_provides_username_and_password_to_the_login_page() {
        webOrderLoginPage.login(ConfigReader.readProperty("weborder_username"),
                ConfigReader.readProperty("weborder_password"));
    }

    @When("User clicks Group Order Box and Next Button")
    public void user_clicks_group_order_box_and_next_button() {
        webOrderGroupPage.clickGroupOrderBoxAndNextButton();
    }

    @When("User sends the word {string} for note tp the Invitees Section")
    public void user_sends_the_word_for_note_tp_the_invitees_section(String inviteesNote) {
        webOrderGroupPage.sendDataToInviteesNoteSection(inviteesNote);
    }

    @When("User sends email address which are {string} and {string} to the Invite List")
    public void user_sends_email_address_which_are_and_to_the_invite_list(String email1, String email2) {
        webOrderGroupPage.sendDataToInviteList(email1, email2);
    }

    @When("User chooses delivery address {string} and validates the address {string}")
    public void user_chooses_delivery_address_and_validates_the_address(String location, String address) {
        webOrderGroupPage.chooseDeliveryAddress(location, address);
    }

    @When("User clicks Group Order Button")
    public void user_clicks_group_order_button() throws InterruptedException {
        webOrderGroupPage.clickGroupOrderButton();
    }

    @Then("User validates the header is {string}")
    public void user_validates_the_header_is(String header) {
        webOrderGroupPage.validateHeader(header);
    }

    @Then("User validates the description contains {string}")
    public void user_validates_the_description_contains(String description) {
        webOrderGroupPage.validateDescription(description);
    }
}
