package stepDefinitions;

import constants.EndPoints;
import domainObjects.BillingDetails;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.StorePage;

public class Guest_Place_Order_Steps {

    private WebDriver driver;
    private BillingDetails billingDetails;

    @Given("I am a Guest User")
    public void iAmAGuestUser() {
        driver = DriverFactory.getDriver();
        StorePage storePage = new StorePage(driver);
        // storePage.loadUrl("https://askomdch.com/store"); - Section 21 - prod_config.properties in below line
        storePage.loadUrl(EndPoints.STORE.url);
    }

    @And("I have the below details")
    public void iHaveTheBelowDetails(BillingDetails billingDetails) {
        this.billingDetails = billingDetails;
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

        // checkOutPage.setBillingDetails(billingFirstName, billingLastName, billingAddress, billingCity, billingState, billingZipCode, billingEmail);

        checkOutPage.setBillingDetails(billingDetails);
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
