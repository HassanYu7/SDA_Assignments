package assignments.week3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestSimpleCalculator {

    static WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    /**
     * Test Simple Calculator Addition:
     * Click on Simple Calculator, enter numbers, calculate, and print the result.
     */
    @Test
    public void testCalculatorAddition() {
        clickButton("calculatetest");
        addInput("number1", "3");
        addInput("number2", "5");
        clickButton("calculate");

        By answerText = By.id("answer");
        String actualResult = driver.findElement(answerText).getText();
        int actualResultInt = Integer.parseInt(actualResult);

        System.out.println("The result of sum 3 + 5 is: " + actualResult);

        Assertions.assertEquals(8, actualResultInt);
    }

    private void addInput(String name, String value) {
        By input = By.name(name);
        driver.findElement(input).sendKeys(value);
    }

    private void clickButton(String buttonID) {
        By buttonName = By.id(buttonID);
        driver.findElement(buttonName).click();
    }

}

