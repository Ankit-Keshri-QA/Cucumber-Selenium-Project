package pageObjects;

import domainObjects.BillingDetails;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage extends BasePage {

    @FindBy(id = "billing_first_name")
    private WebElement billing_firstName;

    @FindBy(id = "billing_last_name")
    private WebElement billing_lastName;

    @FindBy(id = "billing_address_1")
    private WebElement billing_addressLine;

    @FindBy(id = "billing_city")
    private WebElement billing_city;

    @FindBy(id = "billing_state")
    private WebElement billingState;

    @FindBy(id = "billing_postcode")
    private WebElement postCode;

    @FindBy(id = "billing_email")
    private WebElement emailID;

    @FindBy(id="place_order")
    private WebElement placeOrderButton;

    @FindBy(css = ".woocommerce-notice")
    private WebElement noticeTxt;


    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public CheckoutPage enterBillingFirstName(String firstName) {
        WebElement ele = wait.until(ExpectedConditions.visibilityOf(billing_firstName));
        ele.clear();
        ele.sendKeys(firstName);
        return this;

    }

    public CheckoutPage enterBillingLastName(String lastName) {
        WebElement ele = wait.until(ExpectedConditions.visibilityOf(billing_lastName));
        ele.clear();
        ele.sendKeys(lastName);
        return this;

    }

    public CheckoutPage enterAddress(String address) {
        WebElement ele = wait.until(ExpectedConditions.visibilityOf(billing_addressLine));
        ele.clear();
        ele.sendKeys(address);
        return this;

    }

    public CheckoutPage selectState(String state) {
        Select select = new Select(wait.until(ExpectedConditions.visibilityOf(billingState)));
        select.selectByVisibleText(state);
        return this;

    }

    public CheckoutPage enterBillingCity(String city) {
        WebElement ele = wait.until(ExpectedConditions.visibilityOf(billing_city));
        ele.clear();
        ele.sendKeys(city);
        return this;

    }

    public CheckoutPage enterBillingZip(String zip) {
        WebElement ele = wait.until(ExpectedConditions.visibilityOf(postCode));
        ele.clear();
        ele.sendKeys(zip);
        return this;

    }

    public CheckoutPage enterBillingEmail(String email) {
        WebElement ele = wait.until(ExpectedConditions.visibilityOf(emailID));
        ele.clear();
        ele.sendKeys(email);
        return this;

    }

    // Builder Pattern - Calling the individual pattern
    // Each method is returning the method of the same class
    // Return instance of the same class, and then call other methods using same instance
    public CheckoutPage setBillingDetails(String firstname, String lastname,
                                          String address, String city,
                                          String state, String zip, String email) {

        return enterBillingFirstName(firstname).
                enterBillingLastName(lastname).
                enterAddress(address).
                enterBillingCity(city).
                selectState(state).
                enterBillingZip(zip).
                enterBillingEmail(email);
    }

    public CheckoutPage setBillingDetails(BillingDetails billingDetails) {

        return enterBillingFirstName(billingDetails.getBillingFirstName()).
                enterBillingLastName(billingDetails.getBillingLastName()).
                enterAddress(billingDetails.getBillingAddress()).
                enterBillingCity(billingDetails.getBillingCity()).
                selectState(billingDetails.getBillingState()).
                enterBillingZip(billingDetails.getBillingZipCode()).
                enterBillingEmail(billingDetails.getBillingEmail());
    }

    public void placeOrder(){
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton)).click();
    }

    public String getNotice(){

        return wait.until(ExpectedConditions.visibilityOf(noticeTxt)).getText();
    }

}
