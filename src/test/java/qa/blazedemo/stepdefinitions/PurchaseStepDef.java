package qa.blazedemo.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import qa.blazedemo.pages.BlazeDemoHomePage;
import utils.DriverHelper;

public class PurchaseStepDef {
    WebDriver driver = DriverHelper.getDriver();
    BlazeDemoHomePage blazeDemoHomePage = new BlazeDemoHomePage(driver);

    @Given("User navigates to the {string}")
    public void user_navigates_to_the(String url) {
        driver.get(url);
    }

    @When("User chooses {string} for departure")
    public void user_chooses_for_departure(String departure) {
        blazeDemoHomePage.chooseDeparture(departure);

    }

    @When("User chooses {string} for destination and click Finding Flight Button")
    public void user_chooses_for_destination_and_click_finding_flight_button(String destination) {
        blazeDemoHomePage.chooseDestinationAndClickFindingFlights(destination);
    }

    @Then("User validates the header {string}")
    public void user_validates_the_header(String expectedHeader) {
        blazeDemoHomePage.validateHeader(expectedHeader);
    }

    @When("User clicks the first flight")
    public void user_clicks_the_first_flight() {
        blazeDemoHomePage.clickFirstFlight();
    }
    @When("User provides {string}, {string}, {string}, {string}, {string}")
    public void user_provides(String fullName, String address, String city, String state, String zipCode) {
blazeDemoHomePage.providePersonalInformation(fullName, address, city, state, zipCode);
    }
    @When("User provides card information {string}, {string}, {string}, {string}, {string}")
    public void user_provides_card_information(String cardType, String cardNumber, String month, String year, String nameOnCard) {
blazeDemoHomePage.provideCardInformation(cardType, cardNumber, month, year, nameOnCard);
    }
    @When("User clicks remember me and Purchase Flight button")
    public void user_clicks_remember_me_and_purchase_flight_button() throws InterruptedException {
blazeDemoHomePage.clickRememberMeAndPurchaseFlight();
    }
    @Then("User validates the purchase message {string}")
    public void user_validates_the_purchase_message(String expectedHeader) {
blazeDemoHomePage.validatePurchaseMessage(expectedHeader);
    }


}
