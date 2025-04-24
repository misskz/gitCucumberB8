package qa.blazedemo.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import utils.ConfigReader;
import utils.DriverHelper;

public class BlazeHook {

    public WebDriver driver = DriverHelper.getDriver();

//    @Before // Import from CUCUMBER.io
//    public void setup(){
//        driver.get(ConfigReader.readProperty("blaze_url"));
//
//    }
//
//    @After // Import from CUCUMBER.io
//    public void tearDown(){
//        driver.quit();
//    }
}
