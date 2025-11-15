package stepDefinitions.HomePageSteps;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePage6 {
    WebDriver driver = new ChromeDriver();
    @Given("On the home page and go to product page")
    public void On_the_home_page_and_go_to_product_page() {
        // Write code here that turns the phrase above into concrete actions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://practice.automationtesting.in");
    }

    @When("Click add to basket")
    public void Click_add_to_basket() {
        // Write code here that turns the phrase above into concrete actions
        WebElement link =  driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/div[2]/div/div/div/div/div[2]"));
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("arguments[0].scrollIntoView(true);", link);

        WebElement firstProduct = link.findElement(By.xpath("./div[1]"));
        String productName =firstProduct.findElement(By.tagName("h3")).getText();
        
        //click on first product image link
        System.out.println(firstProduct.findElement(By.tagName("h3")).getText());
        firstProduct.findElement(By.tagName("img")).click();

        driver.findElement(By.xpath("//button[text()='Add to basket']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/div[1]/a"))).click();

        List<WebElement> cartItems = driver.findElements(By.xpath("//tr[@class = 'cart_item']"));
        for (int i = 0; i < cartItems.size(); i++) {
            if(cartItems.get(i).findElement(By.xpath("//td[@class='product-name']")).getText().equals(productName)){
                System.out.println("Book found in cart");
                break;
            }else{
                System.out.println("Book Name: "+cartItems.get(i).findElement(By.xpath("//td[@class='product-name']")).getText());
            }
        }
    }

    @Then("Book should be added in basket")
    public void Book_should_be_added_in_basket() {
        // Write code here that turns the phrase above into concrete actions
        driver.quit();
    }


}
