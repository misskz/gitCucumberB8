package qa.smartbear.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartBearMainPage {

    public SmartBearMainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    @FindBy(linkText = "Order")
    WebElement orderLink;

    @FindBy(partialLinkText = "all orders")
    WebElement viewOrderLink;

    public void clickOrderLink(){
        orderLink.click();
    }
    public void clickViewOrderLink(){
        viewOrderLink.click();
    }



}
