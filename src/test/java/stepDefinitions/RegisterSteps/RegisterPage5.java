package stepDefinitions.RegisterSteps;

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

public class RegisterPage5 {

    WebDriver driver = new ChromeDriver();

    @Given("User is on Account page for just button click")
    public void User_is_on_Account_page_for_just_button_click() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://practice.automationtesting.in/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//a[text()= 'My Account']")).click();
        
    }


    @When("User enter register without clicking")
    public void User_enter_register_without_clicking() {
        // Write code here that turns the phrase above into concrete actions
        WebElement form = driver.findElement(By.xpath("//form[@class = 'register']"));
        form.findElement(By.xpath("//input[@value = 'Register']")).click();
    }

    @Then("User see error message for empty email and password")
    public void User_see_error_message_for_empty_email_and_password() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println(driver.findElement(By.xpath("//ul[@class = 'woocommerce-error']")).getText());
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(screenshot, new File("emptyBothRegister.png"));
        } catch (IOException e) {
            System.out.println("Screenshot saving failed: " + e.getMessage());
        }
        driver.quit();
    }
}
