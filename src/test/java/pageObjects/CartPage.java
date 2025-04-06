package pageObjects;

import io.cucumber.java.sl.In;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {

    @FindBy(xpath = "//tr/td[@class='product-name']")
    private WebElement productName;

    @FindBy(css = "[id*='quantity']")
    private WebElement productQty;

    @FindBy(css = "a[class*='checkout']")
    private WebElement checkoutLink;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return wait.until(ExpectedConditions.visibilityOf(productName)).getText();
    }

    public int getProductQuantity() {
        return Integer.parseInt(wait.until(ExpectedConditions.visibilityOf(productQty)).getAttribute("value"));
    }

    public void navigateToCheckoutPage() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutLink)).click();
    }

}
