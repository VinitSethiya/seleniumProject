package runner.RegisterRunner;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/RegisterPageFeature/registerPage2.feature", // or a folder
    glue = "stepDefinitions",
    tags = "@registerpage2",  // optional: only if you tag scenarios
    plugin = {"pretty", "html:target/login-report.html"},
    monochrome = true
)


public class RegisterPage2Runner{
    
}
