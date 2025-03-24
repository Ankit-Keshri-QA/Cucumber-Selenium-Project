package stepDefinitions;

import factory.DriverFactory;
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
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.StorePage;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class Guest_Place_Order_Steps {

    private WebDriver driver;

    @Given("I am a Guest User")
    public void iAmAGuestUser() {
        driver = DriverFactory.getDriver();
        StorePage storePage = new StorePage(driver);
        storePage.loadUrl("https://askomdch.com/store");
    }

    @And("I have added a product from the cart")
    public void iHaveAddedAProductFromTheCart() {
        StorePage storePage = new StorePage(driver);
        storePage.addToCart("Blue Shoes");
    }

    @And("I am on the Checkout page")
    public void iAmOnTheCheckoutPage() {
        CartPage cartPage = new CartPage(driver);
        cartPage.navigateToCheckoutPage();
    }

    @When("I provide the shipping details")
    public void iProvideTheShippingDetails(List<Map<String, String>> billingDetails) {
        CheckoutPage checkOutPage = new CheckoutPage(driver);
        // checkOutPage.enterBillingFirstName(billingDetails.get(0).get("firstName"));

        checkOutPage.setBillingDetails(billingDetails.get(0).get("firstName"),
                billingDetails.get(0).get("lastName"),
                billingDetails.get(0).get("address_line1"),
                billingDetails.get(0).get("city"),
                billingDetails.get(0).get("state"),
                billingDetails.get(0).get("zipCode"),
                billingDetails.get(0).get("emailID"));
    }

    @And("I place the order")
    public void iPlaceTheOrder() {
        new CheckoutPage(driver).placeOrder();
    }

    @Then("the order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {
        Assert.assertEquals(new CheckoutPage(driver).getNotice(),"Thank you. Your order has been received.");
    }
}
