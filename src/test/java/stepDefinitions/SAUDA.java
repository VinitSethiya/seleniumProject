package stepDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SAUDA {
    
    WebDriver driver = new ChromeDriver();
    @Given("User logins")
    public void User_logins() {
        // Write code here that turns the phrase above into concrete actions
        driver.manage().window().maximize();
        driver.get("https://suvidhauat.godrejagrovet.com/index.php?r=v2%2Fsignin");

        //Entering username
        driver.findElement(By.xpath("//input[@id = 'v2-login-id']")).sendKeys("somnath.chaterjee");
        driver.findElement(By.xpath("//button[text() = 'Next']")).click();

        //Entering Password
        driver.findElement(By.xpath("//input[@id = 'v2-password-id']")).sendKeys("7115");
        driver.findElement(By.xpath("//button[text() = 'Next']")).click();

        //Clicking on PO contract Option
        driver.findElement(By.xpath("//div[text() = 'PO Contract']")).click();

        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
        .withTimeout(Duration.ofSeconds(15))
        .pollingEvery(Duration.ofMillis(500))
        .ignoring(ElementNotInteractableException.class);
        WebElement element = fluentWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"inner_wrap\"]/div/div/div[2]/div/a[7]")));

        element.click();
    }

    @When("User Enters details")
    public void User_Enters_details() {
        // Write code here that turns the phrase above into concrete actions
        WebElement form = driver.findElement(By.xpath("//form[@id = 'form-create-new-sauda-entry']"));

        //Broker Entry
        form.findElement(By.xpath("//input[@id='sSBEsBrokerText']")).sendKeys("Sangeeta");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-name = 'SANGEETA COMMODITIES [5004873]']")));
        form.findElement(By.xpath("//a[@data-name = 'SANGEETA COMMODITIES [5004873]']")).click();

        //Supplier Entry
        form.findElement(By.xpath("//input[@id='sSBEsSupplierText']")).sendKeys("Vinit Jain");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@data-name = 'Vinit Jain [S79829]']")));
        form.findElement(By.xpath("//a[@data-name = 'Vinit Jain [S79829]']")).click();

        //Picking Date of SAUDA
        form.findElement(By.xpath("//input[@id = 'sSBEdDate']")).click();
        WebElement calender = driver.findElement(By.xpath("/html/body/div[5]/div[@class = 'datepicker-days']/table"));
        WebElement prev = calender.findElement(By.xpath("./thead/tr[2]/th[@class = 'prev']"));
        WebElement next = calender.findElement(By.xpath("./thead/tr[2]/th[@class = 'next']"));
        WebElement monthAndYear = calender.findElement(By.xpath("./thead/tr[2]/th[@class = 'datepicker-switch']"));
        List<WebElement> ActiveDays = calender.findElements(By.xpath(".//td[@class = 'day']"));
        ActiveDays.get(0).click();

        //Picking Delivery Date
        form.findElement(By.xpath("//input[@id = 'sSBEdDeliveryDate']")).click();
        WebElement calender2 = driver.findElement(By.xpath("/html/body/div[5]/div[@class = 'datepicker-days']/table"));
        WebElement prev2 = calender2.findElement(By.xpath("./thead/tr[2]/th[@class = 'prev']"));
        WebElement next2 = calender2.findElement(By.xpath("./thead/tr[2]/th[@class = 'next']"));
        WebElement monthAndYear2 = calender2.findElement(By.xpath("./thead/tr[2]/th[@class = 'datepicker-switch']"));
        while(!monthAndYear2.getText().equals("November 2025")){
            next2.click();
        }
        List<WebElement> ActiveDays2 = calender2.findElements(By.xpath("//td[@class = 'day']"));
        try{
            for(WebElement day : ActiveDays2){
                if(day.getText().equals("7")){
                    day.click();
                    break;
                }
            }
        }catch(StaleElementReferenceException e){
            System.out.print("Getting stale element exception normal");
        }

        //Plant Selection
        driver.findElement(By.xpath("//*[@id=\"form-create-new-sauda-entry\"]/div[1]/div/div[3]/div[1]/div/span")).click();
        List<WebElement> plants = driver.findElements(By.xpath("//ul[@id = 'select2-sSBEiPlantLocationId-results']"));
        for(WebElement plant : plants){
            if(plant.getText().contains("F311")){
                plant.click();
                break;
            }
        }

        //Material Selection
        driver.findElement(By.xpath(".//input[@id = 'sSBEsMaterialText']")).sendKeys("Wheat");
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-name = 'WHEAT ATTA [10150051]']"))).click();

        //Quantity 
        driver.findElement(By.xpath("//input[@id = 'sSBEiQuantity']")).sendKeys("7820");

        //UOM
        driver.findElement(By.xpath("//*[@id=\"form-create-new-sauda-entry\"]/div[2]/div/div[1]/div[1]/div[2]/div/span")).click();
        List<WebElement> uomList = driver.findElements(By.xpath("//ul[@id = 'select2-sSBEiUOM-results']/li"));
        for (WebElement uom : uomList) {
            if(uom.getText().equals("KG")){
                uom.click();
                break;
            }
        }

        //Rate
        driver.findElement(By.xpath("//input[@id = 'sSBEnRate']")).sendKeys("7820");

        //GST Rates
        driver.findElement(By.xpath("//*[@id=\"form-create-new-sauda-entry\"]/div[2]/div/div[1]/div[2]/div[2]/div/span/span[1]/span")).click();
        List<WebElement> gstList = driver.findElements(By.xpath("//ul[@id = 'select2-sSBEsGST-results']/li"));
        for (WebElement gst : gstList) {
            if(gst.getText().contains("18")){
                gst.click();
                break;
            }
        }
        
        //Payment Term
        driver.findElement(By.xpath("//*[@id=\"form-create-new-sauda-entry\"]/div[2]/div/div[1]/div[3]/div[2]/div/span/span[1]/span")).click();
        List<WebElement> paymentList = driver.findElements(By.xpath("//ul[@id = 'select2-sSBEiPaymentTermId-results']/li"));
        for (WebElement payment : paymentList) {
            if(payment.getText().contains("BD41")){
                payment.click();
                break;
            }
        }
        JavascriptExecutor js = (JavascriptExecutor)driver;

        js.executeScript("document.body.style.zoom = '10%'");
        //Enter Next
        driver.findElement(By.xpath("//*[@id=\"form-create-new-sauda-entry\"]/div[2]/div/div[2]/div/div[2]/div/div/button")).click();
        WebElement scrollDiv = driver.findElement(By.xpath("//*[@id=\"bootstrapStickyModel\"]/div/div/div[2]"));

         js.executeScript("arguments[0].scrollTop = arguments[0].scrollHeight", scrollDiv );
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\\\"bootstrapStickyModel\\\"]/div/div/div[2]")));
        

        Actions a = new Actions(driver);
        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(scrollDiv);
        new Actions(driver)
                .scrollFromOrigin(scrollOrigin, 0, 20)
                .perform();
        
        for (int i = 0; i < 4; i++) {
            a.keyDown(Keys.CONTROL).sendKeys(Keys.SUBTRACT).keyUp(Keys.CONTROL).build().perform();

        }

    }

    @Then("Sauda Created")
    public void Sauda_Created() {
        // Write code here that turns the phrase above into concrete actions
    }

}
