package stepDefinitions.MyAccountSteps;

//import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyAccount6 {

    WebDriver driver = new ChromeDriver();


    @Given("User on account page6")
    public void User_on_account_page6() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://practice.automationtesting.in/my-account/");
    }

    @When("User click on address link")
    public void User_click_on_address_link() {
        // Write code here that turns the phrase above into concrete actions
        WebElement form = driver.findElement(By.xpath("//form[@class='login']"));
        form.findElement(By.id("username")).sendKeys("vinitj@sethiya.com");
        form.findElement(By.id("password")).sendKeys("@Vinit123@");
        form.findElement(By.xpath("//input[@value = 'Login']")).click();

        driver.findElement(By.xpath("//a[text() = 'Addresses']")).click();
        driver.findElement(By.xpath("//a[@href= 'https://practice.automationtesting.in/my-account/edit-address/shipping']")).click();
    }

    @Then("User can edit shipping addess")
    public void User_can_edit_shipping_addess() {
        // Write code here that turns the phrase above into concrete actions
        WebElement form = driver.findElement(By.tagName("form"));
        form.findElement(By.xpath("//input[@id = 'shipping_first_name']")).sendKeys("XYZ");
        form.findElement(By.xpath("//input[@id = 'shipping_last_name']")).sendKeys("ABC");
        form.findElement(By.xpath("//input[@id = 'shipping_company']")).sendKeys("Test");
        form.findElement(By.xpath("//a[@class = 'select2-choice']")).click();
        //List<WebElement> countryList = s.getOptions();

        driver.findElement(By.xpath("//input[@id = 's2id_autogen1_search']")).sendKeys("Russia");
        Actions a = new Actions(driver);
        a.keyDown(Keys.ENTER).release().perform();

        Select s = new Select(form.findElement(By.xpath("//select[@id = 'shipping_country']")));

        System.out.println("Selected country:" + s.getFirstSelectedOption().toString());

        form.findElement(By.xpath("//input[@id = 'shipping_address_1']")).sendKeys("Police Station ");
        form.findElement(By.xpath("//input[@id = 'shipping_city']")).sendKeys("Testers Hub");
        
        form.findElement(By.xpath("//input[@id = 'shipping_state']")).sendKeys("Marwad");
        form.findElement(By.xpath("//input[@id = 'shipping_postcode']")).sendKeys("789456 ");

        form.findElement(By.xpath("//input[@name = 'save_address']")).click();
        
    }

}
