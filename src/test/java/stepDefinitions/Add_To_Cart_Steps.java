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
import pageObjects.CartPage;
import pageObjects.StorePage;

import java.time.Duration;

public class Add_To_Cart_Steps {

    private WebDriver driver;

    @Given("I am on the Store Page")
    public void iAmOnTheStorePage() {
        driver = DriverFactory.getDriver();
        StorePage storePage = new StorePage(driver);
        storePage.loadUrl("https://askomdch.com/store");
    }

    @When("I add a {string} to the Cart")
    public void iAddAToTheCart(String productName) {
        StorePage storePage = new StorePage(driver);
        storePage.addToCart(productName);
    }


    @Then("I should see {int} {string} in the cart")
    public void iShouldSeeInTheCart(int quantity, String productName) {
        CartPage cartPage = new CartPage(driver);
        // Assert the product name is expected
        Assert.assertEquals(productName, cartPage.getProductName());
        // Assert the product quantity added
        Assert.assertEquals(quantity, cartPage.gerProductQuantity());

    }
}
