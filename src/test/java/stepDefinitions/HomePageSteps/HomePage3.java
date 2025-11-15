package stepDefinitions.HomePageSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePage3 {
    
    WebDriver driver = new ChromeDriver();
    @Given("On home page and viewing arrival section")
    public void On_home_page_and_viewing_arrival_section() {
        // Write code here that turns the phrase above into concrete actions
        driver.manage().window().maximize();
        driver.get("https://practice.automationtesting.in");
    }

    @When("Click on the image of Arrival")
    public void Click_on_the_image_of_Arrival() {
        // Write code here that turns the phrase above into concrete actions
        WebElement link =  driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/div[2]/div/div/div/div/div[2]"));
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("arguments[0].scrollIntoView(true);", link);

        WebElement firstProduct = link.findElement(By.xpath("./div[2]"));
        
        //click on first product image link
        System.out.println(firstProduct.findElement(By.tagName("h3")).getText());
        firstProduct.findElement(By.tagName("img")).click();
        
    }

    @Then("Navigated to product link")
    public void Navigated_to_product_link() {
        // Write code here that turns the phrase above into concrete actions
        if(driver.getCurrentUrl().contains("product")){
            System.out.println("Navigated to product page");
            driver.quit();
        }else{
            System.out.println("Navigated to wrong page");
            driver.quit();
        }
    }
}
