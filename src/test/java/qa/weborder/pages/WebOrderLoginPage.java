package qa.weborder.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

public class WebOrderLoginPage {

    public WebOrderLoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#Email")
    WebElement email;

    @FindBy(css = "#Password")
    WebElement password;

    @FindBy(tagName = "label")
    WebElement rememberMeBox;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement signInButton;

    @FindBy(css = ".alert-danger")
    WebElement errorMessage;

    public void login(String email, String password){
        this.email.clear();
        this.email.sendKeys(email);
        this.password.clear();
        this.password.sendKeys(password);
    }

    public void rememberMeAndLoginButton(){
        if (rememberMeBox.isDisplayed() && !rememberMeBox.isSelected()){
            rememberMeBox.click();
        }
        signInButton.click();
    }

    public void validateErrorMessageForNegativeLogin(String expectedMessage){
        Assert.assertEquals(expectedMessage, BrowserUtils.getText(errorMessage));
    }



}
