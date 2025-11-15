package stepDefinitions.RegisterSteps;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterPage2 {
    
    WebDriver driver = new ChromeDriver();
    @Given("On registration page")
    public void On_registration_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://practice.automationtesting.in/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[text()= 'My Account']")).click();
    }

    @When("Enter invalid email")
    public void Enter_invalid_email() {
        // Write code here that turns the phrase above into concrete actions
        WebElement form = driver.findElement(By.xpath("//form[@class = 'register']"));
        WebElement emailField = form.findElement(By.id("reg_email"));
        emailField.sendKeys("@sethiya.com");
        form.findElement(By.id("reg_password")).sendKeys("@Vinit123@");
        form.findElement(By.xpath("//input[@value = 'Register']")).click();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        String warning = (String)js.executeScript("return arguments[0].validationMessage", emailField);

        System.out.println("Warning: " + warning);
    }

    @Then("Show warning for wrong email")
    public void Show_warning_for_wrong_email() {
        // Write code here that turns the phrase above into concrete actions
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(screenshot, new File("wrongEmailRegister.png"));
        } catch (IOException e) {
            System.out.println("Screenshot saving failed: " + e.getMessage());
        }
        driver.quit();
    }

}
