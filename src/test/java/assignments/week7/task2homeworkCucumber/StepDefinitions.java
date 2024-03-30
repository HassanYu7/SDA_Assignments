package assignments.week7.task2homeworkCucumber;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StepDefinitions {

    WebDriver driver;

    @Given("user goes to the {string}")
    public void user_goes_to_the(String string) {
        driver = new ChromeDriver();
        driver.navigate().to(string);
    }
    @Then("user waits for {int} seconds")
    public void user_waits_for_seconds(Integer int1) throws InterruptedException {
        Thread.sleep(5000);
    }

    @Then("verifies that the page title contains the word {string}")
    public void verifies_that_the_page_title_contains_the_word(String string) {
        assertTrue(driver.getTitle().contains(string));
    }


    @Then("closes the page")
    public void closes_the_page() {
        driver.close();
        driver.quit();
    }
}


