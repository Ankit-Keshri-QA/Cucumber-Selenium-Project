package stepDefinitions;

import context.TestContext;
import domainObjects.Product;
import factory.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.CartPage;

public class CartStepDefinition {
    private final CartPage cartPage;

    public CartStepDefinition(TestContext context) {
        this.cartPage = PageFactoryManager.getCartPage(context.driver);
    }

    @Then("I should see {int} {product} in the cart")
    public void iShouldSeeInTheCart(int quantity, Product product) {
        Assert.assertEquals(product.getName(), cartPage.getProductName());
        Assert.assertEquals(quantity, cartPage.getProductQuantity());
    }

//    @And("I am on the Checkout page")
//    public void iAmOnTheCheckoutPage() {
//        cartPage.navigateToCheckoutPage();
//    }
}
