package assignments.week3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtonTest {
     WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

//    Task 1:
//    Go to URL: https://demoqa.com/radio-button
//    Verify whether all 3 options given to the question can be selected.
//    When each option is selected, print the following texts on the console.

    @Test
    public void checkOptionsCanBeSelected() {
        driver.navigate().to("https://demoqa.com/radio-button");

        WebElement yesLabel = driver.findElement(By.xpath("//label[@for='yesRadio']"));
        yesLabel.click();
        System.out.println("Selected option: " + yesLabel.getText());

        WebElement impressiveLabel = driver.findElement(By.xpath("//label[@for='impressiveRadio']"));
        impressiveLabel.click();
        System.out.println("Selected option: " + impressiveLabel.getText());

        WebElement noLabel = driver.findElement(By.xpath("//label[@for='noRadio']"));
        noLabel.click();
        System.out.println("Selected option: " + noLabel.getText());
    }

}
