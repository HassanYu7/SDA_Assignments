package assignments.week3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Task 2: breakout task: (in a separate class) navigate to this url https://www.saucedemo.com/v1/inventory.html,
 * add the first item you find to your cart, open your cart, assert that the item name is correct inside the cart
 */
public class SauceDemoCartTest {

    static WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to("https://www.saucedemo.com/v1/inventory.html");
    }

    @Test
    public void addFirstItem() {
        By firstItem = By.xpath("(//button[@class='btn_primary btn_inventory'])[1]");
        driver.findElement(firstItem).click();

        driver.navigate().to("https://www.saucedemo.com/v1/cart.html");
        By itemName = By.xpath("(//div[@class='inventory_item_name'])[1]");
        var actualValue = driver.findElement(itemName).getText();

        Assertions.assertEquals("Sauce Labs Backpack", actualValue);
    }


}
