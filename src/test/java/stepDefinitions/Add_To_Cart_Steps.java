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

    private final WebDriver driver;

    public Add_To_Cart_Steps(TestContext context) {
        driver = context.driver;
    }
}
