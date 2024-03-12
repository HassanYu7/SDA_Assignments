package assignments.week3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SecondAssignment {

    static WebDriver driver;

    @BeforeEach
    public void beforeEach(){
        driver = new ChromeDriver();
        driver.get("https://www.w3schools.com/");
        driver.get("https://stackoverflow.com/");
    }

    @Test
    public void assignmentPart01(){
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }

    @Test
    public void assignmentPart02(){
        driver.manage().window().maximize();
        var actualTitle  = driver.getTitle();
        var expectedTitle = "Stack Overflow - Where Developers Learn, Share, & Build Careers";
        Assertions.assertEquals(expectedTitle,actualTitle);
    }

    @AfterEach
    public void afterEach(){
        driver.quit();
    }
}
