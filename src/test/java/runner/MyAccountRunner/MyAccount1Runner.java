package runner.MyAccountRunner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/MyAccountFeature/myaccount1.feature", // or a folder
    glue = "stepDefinitions",
    plugin = {"pretty", "html:target/login-report.html"},
    monochrome = true
)

public class MyAccount1Runner {
    
}
