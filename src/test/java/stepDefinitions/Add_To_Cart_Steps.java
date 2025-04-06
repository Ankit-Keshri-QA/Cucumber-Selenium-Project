package stepDefinitions;

import constants.EndPoints;
import context.TestContext;
import domainObjects.Product;
import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.CartPage;
import pageObjects.StorePage;

public class Add_To_Cart_Steps {

    private WebDriver driver;


    public Add_To_Cart_Steps(TestContext context) {
        System.out.println("STEP DEF DI: SCENARIO NAME :-  " + context.scenarioName);
    }

    @Given("I am on the Store Page")
    public void iAmOnTheStorePage() {
        driver = DriverFactory.getDriver();
        StorePage storePage = new StorePage(driver);
        // storePage.loadUrl("https://askomdch.com/store"); - Removed in Section 21 as part of config.prop file
        storePage.loadUrl(EndPoints.STORE.url);
    }

    @When("I add a {product} to the Cart")
    public void iAddAToTheCart(Product product) {
        StorePage storePage = new StorePage(driver);
        storePage.addToCart(product.getName());
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
