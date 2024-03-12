package engine;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;

public class ActionsBot {

    private WebDriver driver;
    private Logger logger;
    private Wait<WebDriver> wait;


    public ActionsBot(WebDriver driver, Logger logger, Wait<WebDriver> wait) {
        this.driver = driver;
        this.logger = logger;
        this.wait = wait;
    }

    public void navigate(String url) {
        logger.info("Navigated to upload page" + url);
        driver.navigate().to(url);
    }

    public void type(By locator, CharSequence text) {
        logger.info("Typing: " + text + ", into: " + locator);
        wait.until(d -> {
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
            return true;
        });
    }

    public void click(By locator) {
        logger.info("Clicking: " + locator);
        wait.until(d -> {
            driver.findElement(locator).click();
            return true;
        });
    }

    public void dragAndDrop(By sourceLocator, By targetLocator) {
        logger.info("Performing drag and drop from: " + sourceLocator + " to: " + targetLocator);
        wait.until(d -> {
            WebElement sourceElement = driver.findElement(sourceLocator);
            WebElement targetElement = driver.findElement(targetLocator);
            new Actions(driver).dragAndDrop(sourceElement, targetElement).perform();
            return true;
        });
    }
}
