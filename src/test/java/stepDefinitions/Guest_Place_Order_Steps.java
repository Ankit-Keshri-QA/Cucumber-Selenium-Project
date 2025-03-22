package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class Guest_Place_Order_Steps {

    private WebDriver driver;

    @Given("I am a Guest User")
    public void iAmAGuestUser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @And("I have added a product from the cart")
    public void iHaveAddedAProductFromTheCart() {
        driver.get("https://askomdch.com/store");
        driver.findElement(By.xpath("//a[@aria-label='Add “Blue Tshirt” to your cart']")).click();
        driver.findElement(By.cssSelector("a[title='View cart']")).click();
    }

    @And("I am on the Checkout page")
    public void iAmOnTheCheckoutPage() {
        driver.findElement(By.cssSelector("a[class*='checkout']")).click();
    }

    @When("I provide the shipping details")
    public void iProvideTheShippingDetails(List<Map<String, String>> billingDetails) {
        driver.findElement(By.id("billing_first_name")).sendKeys(billingDetails.get(0).get("firstName"));
        driver.findElement(By.id("billing_last_name")).sendKeys(billingDetails.get(0).get("lastName"));
        driver.findElement(By.id("billing_address_1")).sendKeys(billingDetails.get(0).get("address_line1"));
        driver.findElement(By.id("billing_city")).sendKeys(billingDetails.get(0).get("city"));
        Select select = new Select(driver.findElement(By.id("billing_state")));
        select.selectByVisibleText(billingDetails.get(0).get("state"));
        driver.findElement(By.id("billing_postcode")).sendKeys(billingDetails.get(0).get("zipCode"));
        driver.findElement(By.id("billing_email")).sendKeys(billingDetails.get(0).get("emailID"));


    }

    @And("I place the order")
    public void iPlaceTheOrder() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='place_order']")));
        element.click();

    }

    @Then("the order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {
        String successText = driver.findElement(By.cssSelector(".woocommerce-notice")).getText();

        Assert.assertEquals(successText, "Thank you. Your order has been received.");
    }
}
