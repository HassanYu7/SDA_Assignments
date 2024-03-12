package assignments;

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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DropdownAssignment {

    WebDriver driver;

    @BeforeEach
    public void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        driver = new ChromeDriver(chromeOptions);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testDropdown() {

//      Go to URL: https://the-internet.herokuapp.com/dropdown
        driver.navigate().to("https://the-internet.herokuapp.com/dropdown");

        By dropdown = By.id("dropdown");
        Select select = new Select(driver.findElement(dropdown));

//      Create method selectByIndexTest and Select Option 1 using index
        selectByIndexTest(select, 1);

//        Create method selectByValueTest Select Option 2 by value.
        selectByValueTest(select, "2");

//        Create method selectByVisibleTextTest Select Option 1 value by visible text.
        selectByVisibleTextTest(select, "Option 2");

//        Create method printAllTest Print all dropdown value.
        printAllTest(select);

//        Verify the dropdown has Option 2 text.
        assertTrue(dropdownHasOption2(select, "Option 2"), "Dropdown does not have Option 2 text");

//        Create method printFirstSelectedOptionTest Print first selected option.
        printFirstSelectedOptionTest(select);

//        Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.
        assertEquals(3, getSizeDropdown(select), "Expected Is Not Equal Actual");
    }

    private int getSizeDropdown(Select select) {
        return select.getOptions().size();
    }

    private void printFirstSelectedOptionTest(Select select) {
        System.out.println("Print first selected option: " + select.getFirstSelectedOption().getText());
    }

    private boolean dropdownHasOption2(Select select, String val) {
        boolean isHaveOption2 = false;
        for (WebElement option : select.getOptions()) {
            if (option.getText().equals(val)) {
                isHaveOption2 = true;
                break;
            }
        }
        return isHaveOption2;
    }


    private void printAllTest(Select select) {
        List<WebElement> getOptions = select.getOptions();
        getOptions.forEach(option -> System.out.println(option.getText()));
    }

    private void selectByVisibleTextTest(Select select, String value) {
        select.selectByVisibleText(value);
    }

    private void selectByValueTest(Select select, String value) {
        select.selectByValue(value);
    }

    private void selectByIndexTest(Select select, int index) {
        select.selectByIndex(index);
    }


}
