package qa.weborder.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


//RunWith --> Executes your feature file steps
//CucumberOptions --> It is a special annotation that has some hey words


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features/weborder", //location of feature files(Content)
        glue = "qa/weborder/stepdefinitions", //location of step definition(Source)
        plugin = {"pretty", "html:target/uiReport.html", "rerun:target/uiFailedTests.txt"}
)

public class WebOrderRunner {
}
