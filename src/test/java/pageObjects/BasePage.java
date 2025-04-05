package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigLoader;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    // Modified code in Section 21 - Added ConfigLoader method to call baseURL
    public void loadUrl(String endPoint) {
        driver.get(ConfigLoader.getInstance().getBaseUrl() + endPoint);
    }
}
