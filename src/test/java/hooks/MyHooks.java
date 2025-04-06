package hooks;

import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class MyHooks {

    private WebDriver driver;

    @Before
    public void setup(Scenario scenario) {
        System.out.println("BEFORE THREAD ID: " + Thread.currentThread().threadId() + " , "
                + "SCENARIO NAME: " + scenario.getName());
        driver = DriverFactory.initializeDriver(System.getProperty("browser", "chrome"));
    }

    @After
    public void tearDown(Scenario scenario) {
        System.out.println("AFTER THREAD ID: " + Thread.currentThread().threadId() + " , "
                + "SCENARIO NAME: " + scenario.getName());
        driver.quit();
    }
}
