package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Add_To_Cart_Steps {
    @Given("I am on the Store Page")
    public void iAmOnTheStorePage() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://askomdch.com/store");

    }

    @When("I add a {string} to the Cart")
    public void iAddAToTheCart(String arg0) {
    }

    @Then("I should see {int} {string} in the cart")
    public void iShouldSeeInTheCart(int arg0, String arg1) {
    }
}
