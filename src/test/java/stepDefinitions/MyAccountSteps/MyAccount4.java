package stepDefinitions.MyAccountSteps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyAccount4 {
    
    WebDriver driver = new ChromeDriver();


    @Given("User on my account page4")
    public void User_on_my_account_page4() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://practice.automationtesting.in/my-account/");
    }

    @When("User click orders button and then view for order")
    public void User_click_orders_button_and_then_view_for_order() {
        // Write code here that turns the phrase above into concrete actions
        WebElement form = driver.findElement(By.xpath("//form[@class='login']"));
        form.findElement(By.id("username")).sendKeys("vinitj@sethiya.com");
        form.findElement(By.id("password")).sendKeys("@Vinit123@");
        form.findElement(By.xpath("//input[@value = 'Login']")).click();

        driver.findElement(By.xpath("//a[text()='Orders']")).click();

        WebElement table = driver.findElement(By.xpath("//div[@class='woocommerce-MyAccount-content']//table"));
        List<WebElement> rows = table.findElements(By.xpath(".//tbody/tr"));
        rows.get(0).findElement(By.xpath("//a[text() = 'View']")).click();
    }

    @Then("User can see order details, order number and status")
    public void User_can_see_order_details_order_number_and_status() {
        // Write code here that turns the phrase above into concrete actions
        WebElement content = driver.findElement(By.xpath("//div[@class = 'woocommerce-MyAccount-content']/p"));

        System.out.println(content.getText());

        String orderNumber = content.findElement(By.xpath(".//mark[@class='order-number']")).getText();
        String orderDate = content.findElement(By.xpath(".//mark[@class='order-date']")).getText();
        String orderStatus = content.findElement(By.xpath(".//mark[@class='order-status']")).getText();

        System.out.println("Order number:" + orderNumber);
        System.out.println("Order date:" + orderDate);
        System.out.println("Order status:" + orderStatus);

        driver.quit();
    }

}
