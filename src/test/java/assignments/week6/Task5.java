package assignments.week6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Task5 {


    //Go to URL: http://crossbrowsertesting.github.io/
    //Click to To-Do App
    //Checking Box to do-4 and Checking Box to do-5
    //If both clicks worked, then the following List should be have length 3.
    //Assert that this is correct
    //Assert that the to do we added is present in the list
    //Archiving old todos
    //If our archive link worked, then the following list should have length 4.
    //Assert that this is true as well
    //Doing Cross Browser Testing.


    WebDriver driver;

    @Parameters({"target-browser"})
    @BeforeClass
    public void setUp(@Optional("chrome") String targetBrowser){
        switch (targetBrowser){
            case "chrome" -> driver = new ChromeDriver();
            case "firefox" -> driver = new FirefoxDriver();
            case "edge" -> driver = new EdgeDriver();
        }
        driver.get("http://crossbrowsertesting.github.io/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test(priority = 1)
    public void verifyClickToDoApp() {
        driver.findElement(By.linkText("To-Do App")).click();
        assertTrue(driver.getTitle().contains("Todo App"));
    }

    @Test(priority = 2)
    public void verifyCheckToDoBoxes() {
        driver.findElement(By.name("todo-4")).click();
        driver.findElement(By.name("todo-5")).click();
        assertEquals("3 of 5 remaining", driver.findElement(By.xpath("//span[@class='ng-binding']")).getText());
    }

    @Test(priority = 3)
    public void verifyToDoItemsCountIsThreeBeforeArchiving() {
        driver.findElement(By.linkText("archive")).click();
        List<WebElement> todos3 = driver.findElements(By.tagName("li"));
        assertEquals(3, todos3.size());
    }

    @Test(priority = 4)
    public void verifyAddItemCountIsFourAfterArchiving() {
        driver.findElement(By.id("todotext")).sendKeys("Review code on GitHub");
        driver.findElement(By.id("addbutton")).click();
        driver.findElement(By.linkText("archive")).click();
        List<WebElement> todoListAfterArchive = driver.findElements(By.xpath("//li[@class='ng-scope']"));
        assertEquals(4, todoListAfterArchive.size());
    }


}
