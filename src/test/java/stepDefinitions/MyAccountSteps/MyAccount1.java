package stepDefinitions.MyAccountSteps;

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

public class MyAccount1 {
 
    WebDriver driver = new ChromeDriver();

    
    @Given("User on my account page1")
    public void User_on_my_account_page1() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://practice.automationtesting.in/my-account/");
        
    }

    @When("Click Dashboard button")
    public void Click_Dashboard_button() {
        // Write code here that turns the phrase above into concrete actions
        WebElement form = driver.findElement(By.xpath("//form[@class='login']"));
        form.findElement(By.id("username")).sendKeys("vinitj@sethiya.com");
        form.findElement(By.id("password")).sendKeys("@Vinit123@");
        form.findElement(By.xpath("//input[@value = 'Login']")).click();

        driver.findElement(By.xpath("//a[text()='Dashboard']")).click();
    }

    @Then("User can see Dashboard")
    public void User_can_see_Dashboard() {
        // Write code here that turns the phrase above into concrete actions
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileHandler.copy(screenshot, new File("dashboard.png"));
        } catch (IOException e) {
            System.out.println("Screenshot saving failed: " + e.getMessage());
        }
        driver.quit();
    }
}
