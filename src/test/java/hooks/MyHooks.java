package hooks;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class MyHooks {

    private WebDriver driver;

    @Before
    public void setup() {
        driver = DriverFactory.initializeDriver(System.getProperty("browser", "chrome"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
