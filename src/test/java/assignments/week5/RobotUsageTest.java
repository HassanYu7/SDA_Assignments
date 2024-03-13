package assignments.week5;

import assignments.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class task3 extends TestBase {

/*
   Go to Amazon
   Scroll to the bottom of the page using a robot
   Click on the "Back to top" web element
   Click on the Amazon logo at the bottom of the page (in the footer) using JavascriptExecutor
   Use Actions to type "ClarusWay" in the search box and perform the search
*/

    @Test
    public void test() throws AWTException, InterruptedException {
        bot.navigate("https://www.amazon.sa/");

        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_END);
        robot.keyRelease(KeyEvent.VK_END);

        By backToTopButton = By.className("navFooterBackToTopText");

        wait.until(d -> {
            driver.findElement(backToTopButton).click();
            return true;
        });

        By amazonLogoBottom = By.xpath("//a[@aria-label='Amazon Saudi Arabia Home']");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        wait.until(d -> {
            js.executeScript("arguments[0].click();", driver.findElement(amazonLogoBottom));
            return true;
        });

        driver.navigate().back();


        By searchBox = By.xpath("//input[@id='twotabsearchtextbox']");
        new Actions(driver)
                .sendKeys(driver.findElement(searchBox), "ClarusWay", Keys.ENTER)
                .perform();

    }
}
