package qa.smartbear.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import qa.smartbear.pages.SmartBearLoginPage;
import qa.smartbear.pages.SmartBearMainPage;
import qa.smartbear.pages.SmartBearOrderPage;
import utils.ConfigReader;
import utils.DriverHelper;

import java.util.List;
import java.util.Map;

public class SmartBearOrderStepDef {

    WebDriver driver = DriverHelper.getDriver();
    SmartBearLoginPage smartBearLoginPage = new SmartBearLoginPage(driver);
    SmartBearMainPage smartBearMainPage = new SmartBearMainPage(driver);
    SmartBearOrderPage smartBearOrderPage = new SmartBearOrderPage(driver);

    @Given("User provides username,password and click loginButton")
    public void user_provides_username_password_and_click_login_button() {
        smartBearLoginPage.login(ConfigReader.readProperty("smartbear_username"),
                ConfigReader.readProperty("smartbear_password"));

    }

    @When("User clicks the Order Link from MainPage")
    public void user_clicks_the_order_link_from_main_page() {
        smartBearMainPage.clickOrderLink();
    }

    @When("User provides the {string},{int} for Product Information")
    public void user_provides_the_for_product_information(String product, int quantity) {
        smartBearOrderPage.provideProductInformation(product, quantity);
    }

    @When("User provides the {string},{string},{string},{string},{string} for Address Information")
    public void user_provides_the_for_address_information(String customerName, String street, String city,
                                                          String state, String zipCode) {
        smartBearOrderPage.provideAddressInformation(customerName, street, city, state, zipCode);
    }

    @When("User provides the {string},{string},{string} for Payment Information")
    public void user_provides_the_for_payment_information(String type, String cardNumber, String expireDate) {
        smartBearOrderPage.provideCardInformation(type, cardNumber, expireDate);
    }

    @Then("User clicks process button and validates {string}")
    public void user_clicks_process_button_and_validates(String expectedMessage) throws InterruptedException {
        smartBearOrderPage.clickProcessButtonAndValidateMessage(expectedMessage);
    }

    @Then("User clicks view all orders Link from MainPage")
    public void user_clicks_view_all_orders_link_from_main_page() {
        smartBearMainPage.clickViewOrderLink();
    }

    @Then("User validates all information {string},{string},{string},{string},{string},{string},{string},{string},{string},{string},{string}")
    public void user_validates_all_information(String customerName, String product, String quantity, String date, String street,
                                               String city, String state, String zip, String cardType, String cardNumber,
                                               String expireDate) {
        smartBearOrderPage.validateAllInformation(customerName, product, quantity, date, street, city, state, zip,
                cardType, cardNumber, expireDate);
    }

    @When("User provides the Product Information")
    public void user_provides_the_product_information(DataTable dataTable) {

        Map<String,String> productInformation=dataTable.asMap();
        System.out.println(productInformation);
        smartBearOrderPage.provideProductInformation(productInformation.get("product"),
                Integer.parseInt(productInformation.get("quantity")));
    }
    @When("User provides the Address Information")
    public void user_provides_the_address_information(DataTable dataTable) {

    }
    @When("User provides the Payment Information")
    public void user_provides_the_payment_information(DataTable dataTable) {

    }
    @Then("User clicks process button and validates")
    public void user_clicks_process_button_and_validates(DataTable dataTable) throws InterruptedException {
        List<String> message=dataTable.asList();
        smartBearOrderPage.clickProcessButtonAndValidateMessage(message.get(0));

    }










}






