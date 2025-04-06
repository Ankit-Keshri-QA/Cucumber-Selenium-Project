package factory;

import org.openqa.selenium.WebDriver;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.StorePage;

public class PageFactoryManager {
    private static StorePage storePage;
    private static CartPage cartPage;
    private static CheckoutPage checkoutPage;

    public static StorePage getStorePage(WebDriver driver) {
        return storePage == null ? new StorePage(driver) : storePage;
    }

    public static CartPage getCartPage(WebDriver driver) {
        return storePage == null ? new CartPage(driver) : cartPage;
    }

    public static CheckoutPage getCheckoutPagePage(WebDriver driver) {
        return storePage == null ? new CheckoutPage(driver) : checkoutPage;
    }

}
