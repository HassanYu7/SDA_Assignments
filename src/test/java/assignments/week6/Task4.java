package assignments.week6;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Task4 {


    //Open the site: http://opencart.abstracta.us/index.php?route=account/login
    //Login with that credentials
    //Email: clarusway@gmail.com
    //Password: 123456789
    //Using the Search function do it with Data Provider for Mac, iPad and Samsung.

    WebDriver driver;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://opencart.abstracta.us/index.php?route=account/login");

    }

    @DataProvider(name = "searchTerms")
    public Object[][] searchData() {
        return new Object[][]{
                {"Mac"},
                {"iPad"},
                {"Samsung"}
        };
    }

    @Test
    public void loginTest() {
        driver.findElement(By.id("input-email")).sendKeys("clarusway@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("123456789");
        driver.findElement(By.xpath("//input[@value='Login']")).click();
    }

    @Test(dataProvider = "searchTerms", dependsOnMethods = "loginTest")
    public void searchProduct(String searchTerm) {
        driver.findElement(By.name("search")).clear();
        driver.findElement(By.name("search")).sendKeys(searchTerm, Keys.ENTER);
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
