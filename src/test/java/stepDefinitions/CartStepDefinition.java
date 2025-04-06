package stepDefinitions;

import context.TestContext;
import domainObjects.Product;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.CartPage;

public class CartStepDefinition {

    private final WebDriver driver;

    public CartStepDefinition(TestContext context) {
        driver = context.driver;
    }

    @Then("I should see {int} {product} in the cart")
    public void iShouldSeeInTheCart(int quantity, Product product) {
        CartPage cartPage = new CartPage(driver);
        // Assert the product name is expected
        Assert.assertEquals(product.getName(), cartPage.getProductName());
        // Assert the product quantity added
        Assert.assertEquals(quantity, cartPage.getProductQuantity());

    }
}
