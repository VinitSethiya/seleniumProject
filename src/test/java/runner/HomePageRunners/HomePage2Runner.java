package runner.HomePageRunners;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/HomePageFeature/homepage2.feature", // or a folder
    glue = "stepDefinitions",
    tags = "@homepage2",  // optional: only if you tag scenarios
    plugin = {"pretty", "html:target/login-report.html"},
    monochrome = true
)

public class HomePage2Runner {
    
}
