package stepDefinitions;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Add_To_Cart_Steps {

    private WebDriver driver;

    @Given("I am on the Store Page")
    public void iAmOnTheStorePage() {
        driver = DriverFactory.getDriver();
        System.out.println("Driver: " + driver);
        driver.get("https://askomdch.com/store");

    }

    @When("I add a {string} to the Cart")
    public void iAddAToTheCart(String productName) {
        driver.findElement(By.xpath("//a[@aria-label='Add “" + productName + "” to your cart']")).click();
        driver.findElement(By.cssSelector("a[title='View cart']")).click();
    }


    @Then("I should see {int} {string} in the cart")
    public void iShouldSeeInTheCart(int quantity, String productName) {

        WebElement prodName = driver.findElement(By.xpath("//tr/td[@class='product-name']"));
        String productQty = driver.findElement(By.cssSelector("[id*='quantity']")).getAttribute("value");

        // Assert the product name is expected
        Assert.assertEquals(productName, prodName.getText());

        // Assert the product quantity added
        Assert.assertEquals(quantity, Integer.parseInt(productQty));


    }
}
