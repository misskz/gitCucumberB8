package qa.blazedemo.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class BlazeDemoHomePage {

    public BlazeDemoHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//select[@name='fromPort']")
    WebElement departure;

    @FindBy(xpath = "//select[@name='toPort']")
    WebElement destination;

    @FindBy(tagName = "input")
    WebElement findingFlights;

    @FindBy(tagName = "h3")
    WebElement header;

    @FindBy(xpath = "//input[@type='submit']")
    List<WebElement> allFlights;

    @FindBy(css = "#inputName")
    WebElement firstAndLastName;

    @FindBy(css = "#address")
    WebElement address;

    @FindBy(css = "#city")
    WebElement city;

    @FindBy(css = "#state")
    WebElement state;

    @FindBy(css = "#zipCode")
    WebElement zipCode;

    @FindBy(css = "#cardType")
    WebElement cardType;

    @FindBy(css = "#creditCardNumber")
    WebElement creditCard;

    @FindBy(css = "#creditCardMonth")
    WebElement month;

    @FindBy(css = "#creditCardYear")
    WebElement year;

    @FindBy(css = "#nameOnCard")
    WebElement nameOnCard;

    @FindBy(css = "#rememberMe")
    WebElement remember;

    @FindBy(xpath = "//input[@value='Purchase Flight']")
    WebElement purchaseFlightButton;

    @FindBy(tagName = "h1")
    WebElement purchaseHeader;


    public void chooseDeparture(String departure) {
        BrowserUtils.selectBy(this.departure, departure, "value");
    }

    public void chooseDestinationAndClickFindingFlights(String destination) {
        BrowserUtils.selectBy(this.destination, destination, "text");
        findingFlights.click();
    }

    public void validateHeader(String expectedHeader) {
        Assert.assertEquals(expectedHeader, BrowserUtils.getText(header));
    }

    public void clickFirstFlight() {
        allFlights.get(0).click();

//        for (WebElement flight : allFlights){
//            flight.click();
//            break;
    }

    public void providePersonalInformation(String fullName, String address, String city, String state, String zipCode) {
        this.firstAndLastName.sendKeys(fullName);
        this.address.sendKeys(address);
        this.city.sendKeys(city);
        this.state.sendKeys(state);
        this.zipCode.sendKeys(zipCode);
    }

    public void provideCardInformation(String cardType, String cardNumber, String month, String year, String nameOnCard){
        BrowserUtils.selectBy(this.cardType, cardType, "text");
        this.creditCard.sendKeys(cardNumber);
        this.month.clear();
        this.month.sendKeys(month);
        this.year.clear();
        this.year.sendKeys(year);
        this.nameOnCard.sendKeys(nameOnCard);
    }

    public void clickRememberMeAndPurchaseFlight() throws InterruptedException {
        remember.click();
        Thread.sleep(6000);
        purchaseFlightButton.click();
    }

    public void validatePurchaseMessage(String expectedMessage){
        Assert.assertEquals(expectedMessage, BrowserUtils.getText(purchaseHeader));
    }


}
