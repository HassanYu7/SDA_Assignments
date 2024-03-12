package assignments;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class TestSelectMenu {

    WebDriver driver;

    @BeforeEach
    public void setUp(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.navigate().to("https://www.selenium.dev/selenium/web/web-form.html");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testCheckSelectMenuOldStyle() {
        driver.navigate().to("https://www.selenium.dev/selenium/web/web-form.html");

        By oldSelectMenu = By.name("my-select");
        Select itemSelect = new Select(driver.findElement(oldSelectMenu));
        List<WebElement> selectedOptionElements = itemSelect.getOptions();

        for (WebElement element : selectedOptionElements) {
            System.out.println(element.getText());
        }

    }

    @Test
    public void testCheckSelectMenuOldStyle1() {

        driver.get("your_url_here");

        By inputFieldLocator = By.name("my-datalist");
        WebElement inputField = driver.findElement(inputFieldLocator);
        inputField.sendKeys("San Francisco");

        // Initialize WebDriverWait with a longer timeout duration (e.g., 30 seconds)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(32));

        // Wait for the suggestion to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//datalist[@id='my-options']//option[@value='San Francisco']")));

        // Print all the options
        System.out.println("All Options:");
        for (WebElement option : driver.findElements(By.xpath("//datalist[@id='my-options']//option"))) {
            System.out.println(option.getAttribute("value"));
        }
    }
}
