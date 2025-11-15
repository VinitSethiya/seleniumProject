package stepDefinitions.LoginSteps;


import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login7 {

    WebDriver driver = new ChromeDriver();

    @Given("login page7")
    public void login_page7() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://practice.automationtesting.in/my-account/");
    }

    @When("Enter username without case sensative")
    public void Enter_username_without_case_sensative() {
        // Write code here that turns the phrase above into concrete actions
        WebElement form = driver.findElement(By.xpath("//form[@class='login']"));
        form.findElement(By.id("username")).sendKeys("VINITj@sethiya.com");
        form.findElement(By.id("password")).sendKeys("@Vinit123@");
        form.findElement(By.xpath("//input[@value = 'Login']")).click();
    }

    @Then("login unsucssesful7")
    public void login_unsucssesful7() {
        // Write code here that turns the phrase above into concrete actions
        try{
            if(driver.findElement(By.xpath("//div[@class = 'woocommerce-MyAccount-content']/p")).getText().contains("vinitj")){
                System.out.println("vinitj" + " login Sucssesful");
            }else{
                System.out.println("Wrong Login");
            }
        }catch(NoSuchElementException e){
            System.out.println("User not Login Sucsessfully");
        }
        driver.quit();
    }
}
