package stepDefinitions;

import context.TestContext;
import factory.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.CheckoutPage;

public class CheckoutStepDefinition {
    private final TestContext context;
    private final CheckoutPage checkOutPage;

    public CheckoutStepDefinition(TestContext context) {
        this.context = context;
        this.checkOutPage = PageFactoryManager.getCheckoutPagePage(context.driver);
    }

    @When("I provide the shipping details")
    public void iProvideTheShippingDetails() {
        checkOutPage.setBillingDetails(context.billingDetails);
    }

    @And("I place the order")
    public void iPlaceTheOrder() {
        checkOutPage.placeOrder();
    }

    @Then("the order should be placed successfully")
    public void theOrderShouldBePlacedSuccessfully() {
        Assert.assertEquals(checkOutPage.getNotice(), "Thank you. Your order has been received.");
    }

}
