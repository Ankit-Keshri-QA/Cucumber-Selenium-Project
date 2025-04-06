package stepDefinitions;

import constants.EndPoints;
import context.TestContext;
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

    private final WebDriver driver;
    private BillingDetails billingDetails;

    public Guest_Place_Order_Steps(TestContext context) {
        driver = context.driver;
    }
}
