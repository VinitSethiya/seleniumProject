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

public class HomePage7 {
    
    WebDriver driver = new ChromeDriver();
    @Given("On the home page7")
    public void On_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://practice.automationtesting.in");
    }

    @When("Added multiple books in basket")
    public void Added_multiple_books_in_basket() {
        // Write code here that turns the phrase above into concrete actions
        WebElement link =  driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/div[2]/div/div/div/div/div[2]"));
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("arguments[0].scrollIntoView(true);", link);

        WebElement firstProduct = link.findElement(By.xpath("./div[1]"));
        
        //click on first product image link
        System.out.println(firstProduct.findElement(By.tagName("h3")).getText());
        firstProduct.findElement(By.tagName("img")).click();

        driver.findElement(By.xpath("//button[text()='Add to basket']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/div[1]/a"))).click();

        List<WebElement> cartItems = driver.findElements(By.xpath("//tr[@class = 'cart_item']"));
        WebElement bookQuantity = cartItems.getFirst().findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/form/table/tbody/tr[1]/td[5]/div/input"));
        bookQuantity.clear();
        bookQuantity.sendKeys("21");

        cartItems.getLast().findElement(By.xpath("//input[@value='Update Basket']")).click();

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.className("woocommerce-message")));

        if(driver.findElement(By.className("woocommerce-message")).getText().equals("Basket Updated")){
            System.out.println("Cart Updated");
            driver.quit();
        }else{
            System.out.println("Cart not updated");
            driver.quit();
        }
    }

    @Then("Multiple books Added")
    public void Multiple_books_Added() {
        // Write code here that turns the phrase above into concrete actions
    }

}
