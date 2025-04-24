package qa.weborder.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import qa.blazedemo.pages.BlazeDemoHomePage;
import utils.BrowserUtils;

public class WebOrderGroupPage {

    public WebOrderGroupPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#ConfirmAddressID")
    WebElement deliveryAddress;

    @FindBy(css = "#addressPreview")
    WebElement addressPreview;

    @FindBy(xpath = "//label[@for='GroupOrder']")
    WebElement groupOrderBox;

    @FindBy(css = "#getAddressNextButton")
    WebElement nextButton;

    @FindBy(css = "#InviteNote")
    WebElement inviteeNote;

    @FindBy(css = "#InviteList")
    WebElement inviteList;

    @FindBy(css = "#createGroupOrder")
    WebElement createGroupOrderButton;

    @FindBy(tagName = "h1")
    WebElement header;

    @FindBy(xpath = "//div[@id='mainColumn']//div[@class='col']")
    WebElement description;

    public void clickGroupOrderBoxAndNextButton() {
        groupOrderBox.click();
        nextButton.click();
    }

    public void sendDataToInviteesNoteSection(String data) {
        inviteeNote.sendKeys(data);
    }

    public void sendDataToInviteList(String email1, String email2) {
        inviteList.sendKeys(email1 + "," + email2);
    }

    public void chooseDeliveryAddress(String location, String expectedAddress) {
        BrowserUtils.selectBy(deliveryAddress, location, "text");
        Assert.assertTrue(BrowserUtils.getText(addressPreview).contains(expectedAddress));
    }

    public void clickGroupOrderButton() throws InterruptedException {
        createGroupOrderButton.click();
        Thread.sleep(2000);
    }

    public void validateHeader(String expectedHeader) {
        Assert.assertEquals(expectedHeader, BrowserUtils.getText(header));
    }

    public void validateDescription(String expectedDescription) {
        Assert.assertTrue(BrowserUtils.getText(description).contains(expectedDescription));
    }


}
