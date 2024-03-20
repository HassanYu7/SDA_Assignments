package assignments.week6;

import assignments.ExcelUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.*;

import java.time.Duration;

public class Task2 {

      /*
Go to https://testpages.eviltester.com/styled/apps/notes/simplenotes.html
Add 10 notes using data provider with excel
Run it with 3 different browsers using XML file
Run it parallel with 3 threads
 */

    WebDriver driver;

    @Parameters({"target-browser"})
    @BeforeClass
    public void setUp(@Optional("chrome") String targetBrowser){
        switch (targetBrowser){
            case "chrome" -> driver = new ChromeDriver();
            case "firefox" -> driver = new FirefoxDriver();
            case "edge" -> driver = new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }


    @Test(dataProvider = "test-data-provider")
    public void test2(String title, String note) {
        driver.navigate().to("https://testpages.eviltester.com/styled/apps/notes/simplenotes.html");
        driver.findElement(By.id("note-title-input")).sendKeys(title);
        driver.findElement(By.id("note-details-input")).sendKeys(note);
        driver.findElement(By.id("add-note")).click();
    }

    @DataProvider(name = "test-data-provider")
    public static Object[][] dataProviderMethod() {
        ExcelUtil excelUtil = new ExcelUtil("src/test/resources/testData/data-provider-excel.xlsx", "Sheet1");
        String[][] dataArray = excelUtil.getDataArray();
        excelUtil.closeWorkbook();
        return dataArray;
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}
