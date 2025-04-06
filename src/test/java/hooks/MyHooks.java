package hooks;

import context.TestContext;
import factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class MyHooks {

    private WebDriver driver;
    private final TestContext context;

    public MyHooks(TestContext context) {
        this.context = context;
    }

    @Before
    public void setup(Scenario scenario) {
        context.scenarioName = scenario.getName();
        System.out.println("SCENARIO NAME: " + context.scenarioName);
        System.out.println("BEFORE THREAD ID: " + Thread.currentThread().threadId() + " , "
                + "SCENARIO NAME: " + scenario.getName());
        driver = DriverFactory.initializeDriver(System.getProperty("browser", "chrome"));
        context.driver = driver;
    }

    @After
    public void tearDown(Scenario scenario) {
        System.out.println("AFTER THREAD ID: " + Thread.currentThread().threadId() + " , "
                + "SCENARIO NAME: " + scenario.getName());
        driver.quit();
    }
}
