package stepDefinitions.LoginSteps;


import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login5 {

    WebDriver driver = new ChromeDriver();

    @Given("login page5")
    public void login_page5() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://practice.automationtesting.in/my-account/");
    }

    @When("Enter without username and password")
    public void Enter_without_username_and_password() {
        // Write code here that turns the phrase above into concrete actions
        WebElement form = driver.findElement(By.xpath("//form[@class='login']"));
        form.findElement(By.xpath("//input[@value = 'Login']")).click();
    }

    @Then("login unsucssesful4")
    public void login_unsucssesful() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(driver.findElement(By.xpath("//ul[@class = 'woocommerce-error']")).getText());
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(screenshot, new File("emptyUserPasswordLogin.png"));
        } catch (IOException e) {
            System.out.println("Screenshot saving failed: " + e.getMessage());
        }
        driver.quit();
    }
}
