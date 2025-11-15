package stepDefinitions.MyAccountSteps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyAccount3 {
    
    WebDriver driver = new ChromeDriver();


    @Given("User on my account page3")
    public void User_on_my_account_page3() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://practice.automationtesting.in/my-account/");
    }

    @When("User click orders button and then view for a order")
    public void User_click_orders_button_and_then_view_for_a_order() {
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

    @Then("User can see customer detials, billing details and address")
    public void User_can_see_customer_detials_billing_details_and_address() {
        // Write code here that turns the phrase above into concrete actions
        WebElement orderDetailsTable = driver.findElement(By.xpath("//table[@class = 'shop_table order_details']"));

        List<WebElement> orderTableHead = orderDetailsTable.findElements(By.xpath(".//thead/tr/th"));

        List<WebElement> orderTableData = orderDetailsTable.findElements(By.xpath(".//tbody/tr"));

        List<WebElement> orderTableFooter = orderDetailsTable.findElements(By.xpath(".//tfoot/tr"));
    
        System.out.println(orderTableHead.get(0).getText() + ":    " + orderTableHead.get(1).getText());

        for(WebElement d : orderTableData){
            List<WebElement> orderTableDataElement = d.findElements(By.xpath(".//td"));
            System.out.println(orderTableDataElement.get(0).getText() + ":    " + orderTableDataElement.get(1).getText());
        }

        for(WebElement d : orderTableFooter){
            System.out.println(d.findElement(By.xpath(".//th")).getText() + ":   " + d.findElement(By.xpath(".//td")).getText());
        }

        driver.quit();
    }
}
