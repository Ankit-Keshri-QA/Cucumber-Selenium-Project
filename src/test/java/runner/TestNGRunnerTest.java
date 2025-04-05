package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        glue = {"stepDefinitions","customType","hooks","factory"},
        features = {"src/test/resources/features/add_cart.feature"}
)
public class TestNGRunnerTest extends AbstractTestNGCucumberTests {
}
