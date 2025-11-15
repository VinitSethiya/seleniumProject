package stepDefinitions.LoginSteps;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login8 {

    WebDriver driver = new ChromeDriver();

    @Given("login page8")
    public void login_page8() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://practice.automationtesting.in/my-account/");
    }

    @When("User login with credantials and log out")
    public void User_login_with_credantials_and_log_out() {
        // Write code here that turns the phrase above into concrete actions
        WebElement form = driver.findElement(By.xpath("//form[@class='login']"));
        form.findElement(By.id("username")).sendKeys("vinitj@sethiya.com");
        form.findElement(By.id("password")).sendKeys("@Vinit123@");
        form.findElement(By.xpath("//input[@value = 'Login']")).click();

        driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/nav/ul/li[6]/a")).click();
        driver.navigate().back();
    }

    @Then("Back the page to check")
    public void Back_the_page_to_check() {
        // Write code here that turns the phrase above into concrete actions
        if(driver.findElement(By.xpath("//form[@class='login']")).isDisplayed()){
            System.out.println("Logout sucssessful");
        }else{
            System.out.println("Log Out unsucsessful");
        }
        driver.quit();
    }
}
