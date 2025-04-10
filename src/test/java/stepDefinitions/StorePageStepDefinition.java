package stepDefinitions;

import apis.CartApi;
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
    private final TestContext context;

    public StorePageStepDefinition(TestContext context) {
        this.storePage = PageFactoryManager.getStorePage(context.driver);
        this.context = context;
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
        // storePage.addToCart("Blue Shoes"); - Commented as part of API Integration Testing Section 25

        // Section 25 - REST API Codes
        CartApi cartApi = new CartApi(context.cookies.getCookies());
        cartApi.addToCart(1215, 1);
        context.cookies.setCookies(cartApi.getCookies());
        context.cookies.injectCookiesToBrowser(context.driver);

    }
}
