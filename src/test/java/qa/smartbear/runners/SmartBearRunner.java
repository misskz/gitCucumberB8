package qa.smartbear.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/smartbear",
        glue = "qa/smartbear/stepdefinitions",
        dryRun = false, //it gets the snips without execution feature file
        tags = "@regression", //it's all about filtration
        plugin = {"pretty","html:target/uiReport.html","rerun:target/uiFailedTests.txt",
        "json:target/cucumber-reports/cucumber.json"}
)
public class SmartBearRunner {
}
