package stepDefinitions;

import constants.EndPoints;
import context.TestContext;
import domainObjects.Product;
import factory.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.StorePage;

public class StorePageStepDefinition {
    private final StorePage storePage;

    public StorePageStepDefinition(TestContext context) {
        this.storePage = PageFactoryManager.getStorePage(context.driver);
    }

    @Given("I am on the Store Page")
    public void iAmOnTheStorePage() {
        storePage.loadUrl(EndPoints.STORE.url);
    }

    @When("I add a {product} to the Cart")
    public void iAddAToTheCart(Product product) {
        storePage.addToCart(product.getName());
    }

    @And("I have added a product from the cart")
    public void iHaveAddedAProductFromTheCart() {
        storePage.addToCart("Blue Shoes");
    }
}
