package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features",
        glue = {"stepdefinitions","hooks"},
        plugin = {"pretty","html:target/CucumberReports/CucumberReport.html"},
        dryRun = true,
        monochrome = true
)

public class MyRunner {
}
