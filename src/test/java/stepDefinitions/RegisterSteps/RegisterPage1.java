package stepDefinitions.RegisterSteps;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterPage1 {

    String email = "vinitj";

    WebDriver driver = new ChromeDriver();
    @Given("User is on the Website landing page")
    public void User_is_on_the_Website_landing_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://practice.automationtesting.in/");
        driver.manage().window().maximize();
    }

    @When("User go to registration page and register")
    public void User_go_to_registration_page_and_register() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//a[text()= 'My Account']")).click();
        if(driver.getCurrentUrl().contains("account")){
            System.out.println("User is on Account page");
        }else{
            System.out.println("User is not on Account page");
            driver.quit();
        }

        WebElement form = driver.findElement(By.xpath("//form[@class = 'register']"));
        form.findElement(By.id("reg_email")).sendKeys(email + "@sethiya.com");
        form.findElement(By.id("reg_password")).sendKeys("@Vinit123@");
        form.findElement(By.xpath("//input[@value = 'Register']")).click();
        
    }

    @Then("User should navigate to Home page")
    public void User_should_navigate_to_Home_page() {
        // Write code here that turns the phrase above into concrete actions
        try{
            if(driver.findElement(By.xpath("//div[@class = 'woocommerce-MyAccount-content']/p")).getText().contains(email)){
                System.out.println(email + " login Sucssesful");
            }else{
                System.out.println("Wrong Login");
            }
        }catch(NoSuchElementException e){
            System.out.println("User not Login Sucsessfully");
        }
        driver.quit();
    }

}
