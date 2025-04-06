package stepDefinitions;

import constants.EndPoints;
import context.TestContext;
import domainObjects.BillingDetails;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pageObjects.StorePage;

public class CustomerStepDefinition {
    private final WebDriver driver;
    private final TestContext context;

    public CustomerStepDefinition(TestContext context) {
        this.context = context;
        driver = context.driver;
    }

    @Given("I am a Guest User")
    public void iAmAGuestUser() {
        StorePage storePage = new StorePage(driver);
        storePage.loadUrl(EndPoints.STORE.url);
    }

    @And("I have the below details")
    public void iHaveTheBelowDetails(BillingDetails billingDetails) {
        context.billingDetails = billingDetails;
    }

}
