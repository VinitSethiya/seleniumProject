package stepDefinitions.HomePageSteps;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePage5{

    WebDriver driver;
    @Given("On the home page")
    public void On_the_home_page() {
        // Write code here that turns the phrase above into concrete actions
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://practice.automationtesting.in");
    }

    @When("Go on product page and give a Review")
    public void Go_on_product_page_and_give_a_Review() {
        // Write code here that turns the phrase above into concrete actions
        WebElement link =  driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div/div[2]/div/div/div/div/div[2]"));
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("arguments[0].scrollIntoView(true);", link);

        WebElement firstProduct = link.findElement(By.xpath("./div[2]"));
        
        //click on first product image link
        System.out.println(firstProduct.findElement(By.tagName("h3")).getText());
        firstProduct.findElement(By.tagName("img")).click();
        
        //adding book in cart
        WebElement reviews = driver.findElement(By.xpath("//a[@href = '#tab-reviews']"));
        ((JavascriptExecutor) driver).executeScript(
        "window.scrollBy(0, arguments[0].getBoundingClientRect().top - (window.innerHeight / 2) + (arguments[0].offsetHeight / 2));",
        reviews
        );
        reviews.click();

        j.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//h3[@id='reply-title']")));
        
        driver.findElement(By.xpath("//a[@class='star-4']")).click();
        driver.findElement(By.xpath("//textarea[@id='comment']")).sendKeys(generateRandomString(15));
        driver.findElement(By.xpath("//input[@id='author']")).sendKeys(generateRandomString(8));
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(generateRandomString(5) + "@gmail.com");
        driver.findElement(By.id("submit")).click();

        // j.executeScript("arguments[0].scrollIntoView(true)", driver.findElement(By.xpath("//h3[@id='reply-title']")));

        WebElement commentList = driver.findElement(By.xpath("//ol[@class = 'commentlist']"));

        List<WebElement> commentsDescription = commentList.findElements(By.xpath("//div[@itemprop='description']"));
        List<WebElement> commentsRating = commentList.findElements(By.xpath("//strong[@itemprop='ratingValue']"));
        
        for(int i=0;i<commentsRating.size();i++){
            System.out.println("Comment Description:" + commentsDescription.get(i).getText() + "Star Rating:" + commentsRating.get(i).getText());
        }
    }

    @Then("Review shown in product page")
    public void Review_shown_in_product_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.quit();
    }


    public static String generateRandomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }

        return sb.toString();
    }
}