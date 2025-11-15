package stepDefinitions.MyAccountSteps;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyAccount2 {
    
    WebDriver driver = new ChromeDriver();


    @Given("User on my account page2")
    public void User_on_my_account_page2() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://practice.automationtesting.in/my-account/");
    }

    @When("User click orders button")
    public void User_click_orders_button() {
        // Write code here that turns the phrase above into concrete actions
        WebElement form = driver.findElement(By.xpath("//form[@class='login']"));
        form.findElement(By.id("username")).sendKeys("vinitj@sethiya.com");
        form.findElement(By.id("password")).sendKeys("@Vinit123@");
        form.findElement(By.xpath("//input[@value = 'Login']")).click();

        driver.findElement(By.xpath("//a[text()='Orders']")).click();

        WebElement table = driver.findElement(By.xpath("//div[@class='woocommerce-MyAccount-content']//table"));

        // Get all header columns
        List<WebElement> headers = table.findElements(By.xpath(".//thead/tr/th"));

        // Get all rows in tbody
        List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));

        System.out.println("Headers found: " + headers.size());
        System.out.println("Rows found: " + rows.size());

        // Loop through each row
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.xpath(".//td"));

            for (int i = 0; i < cells.size()-1; i++) {
                String header = i < headers.size() ? headers.get(i).getText().trim() : "Column " + (i + 1);
                String cellData = cells.get(i).getText().trim();
                System.out.println(header + ": " + cellData);
            }

            System.out.println("----------------------------");
        }

    }

    @Then("User can see orders")
    public void User_can_see_orders() {
        // Write code here that turns the phrase above into concrete actions
        driver.quit();
    }

}
