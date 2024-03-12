package assignments.week5;

import engine.ActionsBot;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public abstract class TestBase {

    protected WebDriver driver;
    protected Wait<WebDriver> wait;


    public static Logger logger;

    public ActionsBot bot;

    @BeforeAll
    public static void beforeAll(){
        Configurator.initialize(null,"src/main/resources/properties/log4j2.properties");
        logger = LogManager.getLogger(TestBase.class.getName());
    }


    @BeforeEach
    public void setUp() {
        logger.info("Open Chrome Browser");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        logger.info("5 seconds explicit wait");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        bot = new ActionsBot(driver,logger,wait);
    }

    @AfterEach
    public void tearDown() {
        logger.info("Close Browser");
        driver.quit();
    }
}
