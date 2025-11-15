package runner.LoginRunner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/LoginFeature/login2.feature", // or a folder
    glue = "stepDefinitions",
    plugin = {"pretty", "html:target/login-report.html"},
    monochrome = true
)


public class Login2Runner {
    
}
