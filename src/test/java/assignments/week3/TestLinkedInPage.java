package assignments.week3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestLinkedInPage {

    static WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.navigate().to("https://www.linkedin.com/");
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    /** Locates "Email or phone", "Password", and "Sign in" button elements using relative XPath. */
    @Test
    public void signInUsingRelativeXPathLocator() {
        sendKeysToElementByXPath("//input[@name='session_key']", "test@gmail.com");
        sendKeysToElementByXPath("//input[@name='session_password']", "asdasd");

        By signInButton = By.xpath("//button[@data-id='sign-in-form__submit-btn']");
        driver.findElement(signInButton).click();

        By text = By.xpath("//*[@id=\"app__container\"]/main/h1");
        var actuclResult = driver.findElement(text).getText();

        Assertions.assertEquals("Let's do a quick security check", actuclResult);
    }


    /** Locates "Email or phone", "Password", and "Sign in" button elements using absolute XPath. */
    @Test
    public void signInUsingAbsoluteXPathLocator() {
        sendKeysToElementByXPath("//html/body/main/section[1]/div/div/form/div[1]/div[1]/div/div/input[@name='session_key']", "test@gmail.com");
        sendKeysToElementByXPath("//html/body/main/section[1]/div/div/form/div[1]/div[2]/div/div/input[@name='session_password']", "asdasd");

        By signInButton = By.xpath("//html/body/main/section[1]/div/div/form/div[2]/button[@data-id='sign-in-form__submit-btn']");
        driver.findElement(signInButton).click();

        By text = By.xpath("//*[@id=\"app__container\"]/main/h1");
        var actuclResult = driver.findElement(text).getText();

        Assertions.assertEquals("Let's do a quick security check", actuclResult);
    }

    /**
     * Find locators of web elements: id, name, className, linkText, partialLinkText
     */
    @Test
    public void findElementByID() {
        By labelContinueWithGoogle = By.id("button-label");
        assertNotNull(driver.findElement(labelContinueWithGoogle));
    }

    @Test
    public void findElementByName() {
        By emailInput = By.name("session_key");
        assertNotNull(driver.findElement(emailInput));
    }

    @Test
    public void findElementByClassName() {
        By secondaryHeading = By.className("secondary-heading");
        assertNotNull(driver.findElement(secondaryHeading));
    }

    @Test
    public void findElementByLinkText() {
        By exploreCollaborativeArticles = By.linkText("Join now");
        assertNotNull(driver.findElement(exploreCollaborativeArticles));
    }

    @Test
    public void findElementByPartialLinkText() {
        By postPartialLink = By.partialLinkText("Privacy");
        assertNotNull(driver.findElement(postPartialLink));
    }

    private void sendKeysToElementByXPath(String xpathExpression, String value) {
        By xpathInput = By.xpath(xpathExpression);
        driver.findElement(xpathInput).sendKeys(value);
    }
}
