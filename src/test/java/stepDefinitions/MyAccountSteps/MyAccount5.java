package stepDefinitions.MyAccountSteps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyAccount5 {
    
    WebDriver driver = new ChromeDriver();


    @Given("User on account page5")
    public void User_on_account_page5() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://practice.automationtesting.in/my-account/");
    }

    @When("User click on address button")
    public void User_click_on_address_button() {
        // Write code here that turns the phrase above into concrete actions
        WebElement form = driver.findElement(By.xpath("//form[@class='login']"));
        form.findElement(By.id("username")).sendKeys("vinitj@sethiya.com");
        form.findElement(By.id("password")).sendKeys("@Vinit123@");
        form.findElement(By.xpath("//input[@value = 'Login']")).click();

        driver.findElement(By.xpath("//a[text() = 'Addresses']")).click();
    }

    @Then("User can see shipping and billing address")
    public void User_can_see_shipping_and_billing_address() {
        // Write code here that turns the phrase above into concrete actions
        List<WebElement> addresses = driver.findElements(By.tagName("address"));

        String billingAddress = addresses.get(0).getAttribute("innerText");
        String shipingAddress = addresses.get(1).getAttribute("innerText");
        
        System.out.println("Billing Address");
        System.out.println(billingAddress);
        System.out.println("Shipping Address");
        System.out.println(shipingAddress);

        driver.quit();
    }

}
