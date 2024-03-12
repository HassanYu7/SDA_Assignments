package assignments.week5;

import assignments.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class GoogleSearchKeyboardActions extends TestBase {

    /** ( This task should be managed with keyboard actions ) */
    // go to https://www.google.com/
    // search for "Scroll Methods" by using an Actions object`

    @Test
    public void searchScrollMethodsUsingKeyboard(){
        bot.navigate("https://www.google.com");
        WebElement searchInput = driver.findElement(By.id("APjFqb"));

        Actions actions = new Actions(driver);
        actions.sendKeys(searchInput, "Scroll Methods",Keys.RETURN).perform();
    }
}
