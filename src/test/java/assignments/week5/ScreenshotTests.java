package assignments.week5;

import assignments.TestBase;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ScreenshotTests extends TestBase {

    // Go to amazon.com
    // Take Full Page Screenshot.
    // Take any spesific WebElement ScreenShot

    @Test
    public void takeScreenshots() throws IOException {
        bot.navigate("https://www.amazon.com");

        File fullPageScreenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileHandler.copy(fullPageScreenshot, new File(".\\test-output\\screenshots\\fullPageScreenshot.png"));

        WebElement navFooterElement = driver.findElement(By.className("navFooterVerticalRow"));

        File elementScreenshot = navFooterElement.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(elementScreenshot,new File(".\\test-output\\screenshots\\elementScreenshot.png"));

    }

}
