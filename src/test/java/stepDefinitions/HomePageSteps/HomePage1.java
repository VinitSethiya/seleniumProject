package stepDefinitions.HomePageSteps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePage1 {

    WebDriver driver = new ChromeDriver();

    @Given("On home page")
    public void On_home_page(){
        driver.manage().window().maximize();
        driver.get("http://practice.automationtesting.in/");
    }

    List<WebElement> sliderImg;
    @When("Check the number of slider")
    public void Check_the_number_of_slider(){
        
        WebElement slider = driver.findElement(By.className("n2-ss-slider-3"));
        sliderImg = slider.findElements(By.tagName("img"));

        System.out.println("Number of Sliders:" + sliderImg.size());
    }

    @Then("If {int} slider quit")
    public void If_three_slider_quit(int sliders){
        if(sliderImg.size() == sliders){
            System.out.println("There are 3 slider images");
            driver.quit();
        }
    }

}
