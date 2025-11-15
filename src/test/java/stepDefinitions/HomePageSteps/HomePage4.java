package stepDefinitions.HomePageSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePage4 {
    WebDriver driver = new ChromeDriver();

    @Given("Go to product page from home page")
    public void Go_to_product_page_from_home_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.manage().window().maximize();
        driver.get("https://practice.automationtesting.in");
    }

    @When("Find the description")
    public void Find_the_description() {
        // Write code here that turns the phrase above into concrete actions
        WebElement link =  driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/div[2]/div/div/div/div/div[2]"));
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("arguments[0].scrollIntoView(true);", link);

        WebElement firstProduct = link.findElement(By.xpath("./div[2]"));
        
        //click on first product image link
        System.out.println(firstProduct.findElement(By.tagName("h3")).getText());
        firstProduct.findElement(By.tagName("img")).click();


        WebElement description = driver.findElement(By.id("tab-description"));
        
        j.executeScript("arguments[0].scrollIntoView(true)", description);
        System.out.println(description.findElement(By.tagName("p")).getText());
    }

    @Then("If right page then quit")
    public void If_right_page_then_quit() {
        // Write code here that turns the phrase above into concrete actions
        driver.quit();
    }
}
