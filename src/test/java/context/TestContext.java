package context;

import domainObjects.BillingDetails;
import org.openqa.selenium.WebDriver;

public class TestContext {
    public String scenarioName;
    public WebDriver driver;
    public BillingDetails billingDetails;

    public TestContext() {
    }
}
