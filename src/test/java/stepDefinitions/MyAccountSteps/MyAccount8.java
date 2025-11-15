package stepDefinitions.MyAccountSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyAccount8 {

    WebDriver driver = new ChromeDriver();


    @Given("User on account page8")
    public void User_on_account_page8() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://practice.automationtesting.in/my-account/");
    }

    @When("User click on log out link")
    public void User_click_on_log_out_link() {
        // Write code here that turns the phrase above into concrete actions
        WebElement form = driver.findElement(By.xpath("//form[@class='login']"));
        form.findElement(By.id("username")).sendKeys("vinitj@sethiya.com");
        form.findElement(By.id("password")).sendKeys("@Vinit123@");
        form.findElement(By.xpath("//input[@value = 'Login']")).click();

        driver.findElement(By.xpath("//a[text() = 'Logout']")).click();

        driver.navigate().back();
    }

    @Then("User log out sucsessfully")
    public void User_log_out_sucsessfully() {
        // Write code here that turns the phrase above into concrete actions
        if(driver.findElement(By.xpath("//form[@class='login']")).isDisplayed()){
            System.out.println("Logout sucssessful");
        }else{
            System.out.println("Log Out unsucsessful");
        }
        driver.quit();
    }
}
