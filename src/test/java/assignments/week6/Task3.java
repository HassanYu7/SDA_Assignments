package assignments.week6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Task3 {

    /*
    go to "https://practicetestautomation.com/practice-test-login/"
    enter username - "student"
    enter password - "incorrectPassword"
    and login
    SOFT ASSERT the error message shown
    SOFT ASSERT the error message is "Your password is invalid!"
    */

    WebDriver driver;


    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @Test
    public void testLoginWithIncorrectPassword() {

        SoftAssert softAssert = new SoftAssert();

        driver.findElement(By.id("username")).sendKeys("student");

        driver.findElement(By.id("password")).sendKeys("incorrectPassword");

        driver.findElement(By.id("submit")).click();

        String errorMessage = driver.findElement(By.id("error")).getText();
        softAssert.assertTrue(errorMessage.contains("Your password is invalid!"));

        softAssert.assertAll();

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
