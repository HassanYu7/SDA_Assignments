package assignments.week4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsTask {


    protected WebDriver driver;
    protected Wait<WebDriver> wait;

    @BeforeEach
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test() {
        driver.navigate().to("http://demo.automationtesting.in/Alerts.html");

        addLocatorByLinkTextAndClick("Alert with OK");
        addLocatorByXpathAndClick("//button[contains(@class,'btn-danger')]");

        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();

        System.out.println(text);
        alert.accept();


        addLocatorByLinkTextAndClick("Alert with OK & Cancel");
        addLocatorByXpathAndClick("//button[contains(@class,'btn-primary')]");
        alert.dismiss();


        addLocatorByLinkTextAndClick("Alert with Textbox");
        addLocatorByXpathAndClick("//button[contains(@class,'btn-info')]");

        alert.sendKeys("Bootcamp");

        By message = By.id("demo1");
        var actualTest = driver.findElement(message).getText().toString();

        Assertions.assertEquals("Hello Bootcamp How are you today", actualTest);

    }

    private void addLocatorByLinkTextAndClick(String linkText){
        By locator = By.linkText(linkText);
        driver.findElement(locator).click();
    }

    private void addLocatorByXpathAndClick(String xpath){
        By locator = By.xpath(xpath);
        driver.findElement(locator).click();
    }


}
