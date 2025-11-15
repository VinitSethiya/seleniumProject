package stepDefinitions.MyAccountSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyAccount7 {

    WebDriver driver = new ChromeDriver();


    @Given("User on account page7")
    public void User_on_account_page7() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://practice.automationtesting.in/my-account/");driver.get("https://practice.automationtesting.in/my-account/");
    }

    @When("User click on account link")
    public void User_click_on_account_link() {
        // Write code here that turns the phrase above into concrete actions
        WebElement form = driver.findElement(By.xpath("//form[@class='login']"));
        form.findElement(By.id("username")).sendKeys("vinitj@sethiya.com");
        form.findElement(By.id("password")).sendKeys("@Vinit123@");
        form.findElement(By.xpath("//input[@value = 'Login']")).click();

        driver.findElement(By.xpath("//a[text() = 'Account Details']")).click();

        
    }

    @Then("User can view his details and can change password")
    public void User_can_view_his_details_and_can_change_password() {
        // Write code here that turns the phrase above into concrete actions
        WebElement formAccount = driver.findElement(By.xpath("//form[@class = 'woocommerce-EditAccountForm edit-account']"));

        String firstName = formAccount.findElement(By.xpath("//input[@id = 'account_first_name']")).getAttribute("value");
        String lastName = formAccount.findElement(By.xpath("//input[@id = 'account_last_name']")).getAttribute("value");
        String email = formAccount.findElement(By.xpath("//input[@id = 'account_email']")).getAttribute("value");

        System.out.printf("First Name: %s /n Last Name: %s /n Email: %s",firstName, lastName, email);
        formAccount.findElement(By.xpath("//input[@id = 'password_current']")).sendKeys("@Vinit123@");
        formAccount.findElement(By.xpath("//input[@id = 'password_1']")).sendKeys("@Vinit123@");
        formAccount.findElement(By.xpath("//input[@id = 'password_2']")).sendKeys("@Vinit123@");

        formAccount.findElement(By.xpath("//input[@value = 'Save changes']")).click();
        System.out.println(driver.findElement(By.xpath("//div[@class = 'woocommerce-message']")).getText());
        driver.quit();
    }
}
