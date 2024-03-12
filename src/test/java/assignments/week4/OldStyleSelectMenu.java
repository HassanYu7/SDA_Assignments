package assignments.week4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OldStyleSelectMenu {


    WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
        driver.navigate().to("https://demoqa.com/select-menu");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testCheckSelectMenuOldStyle() {
        By oldSelectMenu = By.id("oldSelectMenu");
        Select itemSelect = new Select(driver.findElement(oldSelectMenu));

        //Get all the options of the dropdown
        List<WebElement> getOptions = itemSelect.getOptions();

        //print the Options size
        System.out.println("Options size: " + getOptions.size());

        //Print all options
        for (WebElement element : getOptions) {
            System.out.println(element.getText());
        }

        //Print FirstSelectedOptionTest
        System.out.println("Print FirstSelectedOptionTest: " + itemSelect.getFirstSelectedOption().getText());

        //Select option "Yellow"
        itemSelect.selectByVisibleText("Yellow");

        //Verify the dropdown has option "Black"
        boolean isBlackOptionPresent = false;

        for (WebElement element : getOptions) {
            if (element.getText().equals("Black")) {
                isBlackOptionPresent = true;
                break;
            }
        }
        assertTrue(isBlackOptionPresent);
    }
}
