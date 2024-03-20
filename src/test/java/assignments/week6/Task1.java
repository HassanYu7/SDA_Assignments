package assignments.week6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class Task1 {

    /*
    Create tests that depend on each other
    Create beforeClass and set up settings.
    By creating interdependent tests;
    First go to Facebook.
    Then go to Google depending on Facebook,
    Then go to Amazon depending on Google
    Close the driver.
     */

    WebDriver driver;

    @BeforeClass
    public void setUp(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
    }

    @Test
    public void testFacebook(){
        driver.navigate().to("https://www.facebook.com");
    }

    @Test(dependsOnMethods = "testFacebook")
    public void testGoogle(){
        driver.navigate().to("https://www.google.com");
    }

    @Test(dependsOnMethods = "testGoogle")
    public void testAmazon(){
        driver.navigate().to("https://www.amazon.com");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
