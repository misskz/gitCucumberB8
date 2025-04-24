package qa.smartbear.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class SmartBearOrderPage {

    public SmartBearOrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#ctl00_MainContent_fmwOrder_ddlProduct")
    WebElement product;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_txtQuantity")
    WebElement quantity;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_txtName")
    WebElement customerName;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox2")
    WebElement street;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox3")
    WebElement city;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox4")
    WebElement state;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox5")
    WebElement zipCode;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_cardList_0")
    WebElement visa;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_cardList_1")
    WebElement masterCard;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_cardList_2")
    WebElement americanExpress;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox6")
    WebElement cardNumber;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_TextBox1")
    WebElement expireDate;

    @FindBy(css = "#ctl00_MainContent_fmwOrder_InsertButton")
    WebElement processButton;

    @FindBy(tagName = "strong")
    WebElement message;

    @FindBy(xpath = "//tr[2]//td")
    List<WebElement> allInformation;

    public void provideProductInformation(String product, int quantity) {
        BrowserUtils.selectBy(this.product, product, "text");
        this.quantity.clear();
        this.quantity.sendKeys(String.valueOf(quantity));
    }

    public void provideAddressInformation(String customerName, String street, String city,
                                          String state, String zipCode) {
        this.customerName.sendKeys(customerName);
        this.street.sendKeys(street);
        this.city.sendKeys(city);
        this.state.sendKeys(state);
        this.zipCode.sendKeys(zipCode);
    }

    public void provideCardInformation(String type,String cardNumber,String expireDate) {
        chooseCardType(type);
        this.cardNumber.sendKeys(cardNumber);
        this.expireDate.sendKeys(expireDate);
    }

    public void chooseCardType(String type) {

        type = type.toLowerCase();

        switch (type) {

            case "visa":
                visa.click();
                break;
            case "mastercard":
                masterCard.click();
                break;
            case "american express":
                americanExpress.click();
                break;
            default:
                Assert.fail("Provide correct card type like visa,mastercard,american express");
        }
    }

    public void clickProcessButtonAndValidateMessage(String expectedMessage) throws InterruptedException {
        Thread.sleep(3000);
        processButton.click();
        Thread.sleep(3000);
        Assert.assertEquals(expectedMessage,BrowserUtils.getText(message));
    }

    public void validateAllInformation(String customerName,String product,String quantity,String date,String street,
                                       String city,String state,String zip,String cardType,String cardNumber,
                                       String expireDate){
        List<String> expectedInformation= Arrays.asList(customerName,product,quantity,date,street,city,state,
                zip,cardType,cardNumber,expireDate);

        for(int i=1;i<allInformation.size()-1;i++){
            Assert.assertEquals(expectedInformation.get(i-1),BrowserUtils.getText(allInformation.get(i)));
        }
    }
}






