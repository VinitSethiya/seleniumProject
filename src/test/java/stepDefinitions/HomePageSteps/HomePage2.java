package stepDefinitions.HomePageSteps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePage2 {

    WebDriver driver = new ChromeDriver();

    List<WebElement> arrivals;

    @Given("On home page scroll down")
    public void On_home_page_scroll_down() {
        // Write code here that turns the phrase above into concrete actions
        driver.get("https://practice.automationtesting.in");
    }

    @When("Check the number of arrivals")
    public void Check_the_number_of_arrivals() {
        // Write code here that turns the phrase above into concrete actions
        arrivals = driver.findElements(By.className("products"));
        System.out.println("Products count: " + arrivals.size());
    }

    @Then("If {int} arrivals quit")
    public void If_arrivals_quit(int i) {
        // Write code here that turns the phrase above into concrete actions
        if(arrivals.size() == i){
            System.out.println("Total arrivals matched and count:" + i);
            driver.quit();
        }else{
            System.out.println("Total arrival mismatch");
            driver.quit();
        }
    }
}
