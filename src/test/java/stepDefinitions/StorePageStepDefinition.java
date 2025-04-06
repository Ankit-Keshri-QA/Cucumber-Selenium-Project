package stepDefinitions;

import constants.EndPoints;
import context.TestContext;
import domainObjects.Product;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.StorePage;

public class StorePageStepDefinition {

    private final WebDriver driver;

    public StorePageStepDefinition(TestContext context) {
        driver = context.driver;
    }

    @Given("I am on the Store Page")
    public void iAmOnTheStorePage() {
        StorePage storePage = new StorePage(driver);
        storePage.loadUrl(EndPoints.STORE.url);
    }

    @When("I add a {product} to the Cart")
    public void iAddAToTheCart(Product product) {
        StorePage storePage = new StorePage(driver);
        storePage.addToCart(product.getName());
    }

    @And("I have added a product from the cart")
    public void iHaveAddedAProductFromTheCart() {
        StorePage storePage = new StorePage(driver);
        storePage.addToCart("Blue Shoes");
    }
}
