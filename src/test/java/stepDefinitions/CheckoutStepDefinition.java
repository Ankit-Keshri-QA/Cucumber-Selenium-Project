package stepDefinitions;

import context.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;

public class CheckoutStepDefinition {

    private final WebDriver driver;
    private final TestContext context;

    public CheckoutStepDefinition(TestContext context) {
        this.context = context;
        driver = context.driver;
    }

    @And("I am on the Checkout page")
    public void iAmOnTheCheckoutPage() {
        CartPage cartPage = new CartPage(driver);
        cartPage.navigateToCheckoutPage();
    }

    @When("I provide the shipping details")
    public void iProvideTheShippingDetails() {
        CheckoutPage checkOutPage = new CheckoutPage(driver);
        checkOutPage.setBillingDetails(context.billingDetails);
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
