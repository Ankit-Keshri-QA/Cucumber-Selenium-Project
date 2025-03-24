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
    private String billingFirstName;
    private String billingLastName;
    private String billingAddress;
    private String billingCity;
    private String billingState;
    private String billingZipCode;
    private String billingEmail;

    @Given("I am a Guest User")
    public void iAmAGuestUser() {
        driver = DriverFactory.getDriver();
        StorePage storePage = new StorePage(driver);
        storePage.loadUrl("https://askomdch.com/store");
    }

    @And("I have the below details")
    public void iHaveTheBelowDetails(List<Map<String, String>> billingDetails) {
        billingFirstName = billingDetails.get(0).get("firstName");
        billingLastName = billingDetails.get(0).get("lastName");
        billingAddress = billingDetails.get(0).get("address_line1");
        billingCity = billingDetails.get(0).get("city");
        billingState = billingDetails.get(0).get("state");
        billingZipCode = billingDetails.get(0).get("zipCode");
        billingEmail = billingDetails.get(0).get("emailID");
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
    public void iProvideTheShippingDetails() {
        CheckoutPage checkOutPage = new CheckoutPage(driver);
        // checkOutPage.enterBillingFirstName(billingDetails.get(0).get("firstName"));

        checkOutPage.setBillingDetails(billingFirstName, billingLastName, billingAddress, billingCity, billingState, billingZipCode, billingEmail);

    }

    @And("I place the order")
    public void iPlaceTheOrder() {
        new CheckoutPage(driver).placeOrder();
    }

    @Then("the order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {
        Assert.assertEquals(new CheckoutPage(driver).getNotice(), "Thank you. Your order has been received.");
    }


}
