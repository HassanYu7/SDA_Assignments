package assignments.week4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class IframeAssignment {

    //Go to URL: http://demo.guru99.com/test/guru99home/
    //Find the number of iframes on the page.
    //Link to the third iframe (JMeter Made Easy) (https://www.guru99.com/live selenium project.html) click here.
    //Exit the iframe and return to the main page.

     WebDriver driver;
     Wait<WebDriver> wait;

    @BeforeEach
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void iframes(){
        driver.navigate().to("http://demo.guru99.com/test/guru99home/");

        By iframes = By.xpath("//iframe");
        List<WebElement> webElements = driver.findElements(iframes);
        System.out.println("Number of iframes: " + webElements.size());

        WebElement webElement = webElements.get(3);
        driver.switchTo().frame(webElement);
        driver.findElement(By.xpath("//a")).click();

        driver.switchTo().defaultContent();
    }

}
