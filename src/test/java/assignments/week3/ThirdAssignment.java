package assignments.week3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ThirdAssignment {

    static WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    /**
     * Test Simple Calculator Addition: Click on Simple Calculator, enter numbers, calculate, and print the result.
     */
    @Test
    public void testCalculatorAddition() {
        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");

        clickButton("calculatetest");
        addInput("number1", "5");
        addInput("number2", "5");
        clickButton("calculate");

        By answerText = By.id("answer");
        String actualResult = driver.findElement(answerText).getText();
        int actualResultInt = Integer.parseInt(actualResult);

        System.out.println("The result of sum 5 + 5 is: " + actualResult);

        Assertions.assertEquals(10, actualResultInt);
    }

    /**
     * Go to URL: <a href="https://www.linkedin.com/">Linkedin</a> <br>
     * <b>Locate the following elements:</b>
     * <br>
     * - "Email or phone"
     * - "Password"
     * - "Sign in" button
     * <br>
     * <b>Using relative XPath</b>
     */
    @Test
    public void signInUsingRelativeXPathLocator() {
        navigateToLinkedInPage();

        sendKeysToElementByXPath("//input[@name='session_key']", "test@gmail.com");
        sendKeysToElementByXPath("//input[@name='session_password']", "asdasd");

        By signInButton = By.xpath("//button[@data-id='sign-in-form__submit-btn']");
        driver.findElement(signInButton).click();

        By text = By.xpath("//*[@id=\"app__container\"]/main/h1");
        var actuclResult = driver.findElement(text).getText();

        Assertions.assertEquals("Let's do a quick security check", actuclResult);
    }

    /**
     * Go to URL: <a href="https://www.linkedin.com/">Linkedin</a> <br>
     * <b>Locate the following elements:</b>
     * <br>
     * - "Email or phone"
     * - "Password"
     * - "Sign in" button
     * <br>
     * <b>Using absolute XPath</b>
     */
    @Test
    public void signInUsingAbsoluteXPathLocator() {
        navigateToLinkedInPage();

        sendKeysToElementByXPath("//html/body/main/section[1]/div/div/form/div[1]/div[1]/div/div/input[@name='session_key']", "test@gmail.com");
        sendKeysToElementByXPath("//html/body/main/section[1]/div/div/form/div[1]/div[2]/div/div/input[@name='session_password']", "asdasd");

        By signInButton = By.xpath("//html/body/main/section[1]/div/div/form/div[2]/button[@data-id='sign-in-form__submit-btn']");
        driver.findElement(signInButton).click();

        By text = By.xpath("//*[@id=\"app__container\"]/main/h1");
        var actuclResult = driver.findElement(text).getText();

        Assertions.assertEquals("Let's do a quick security check", actuclResult);
    }

    /**
     * Find the locators of web elements on the page
     * <a href="https://www.linkedin.com/">Linkedin</a>
     * <br>
     * <b>Locate the following elements:</b>
     * <ul>
     *   <li>id</li>
     *   <li>name</li>
     *   <li>className</li>
     *   <li>linkText</li>
     *   <li>partialLinkText</li>
     * </ul>
     */
    @Test
    public void findLinkedInPageElementLocators() {
        navigateToLinkedInPage();

        By labelContinueWithGoogle = By.id("button-label");
        var continueWithGoogleButton = driver.findElement(labelContinueWithGoogle);

        By emailInput = By.name("session_key");
        var emailInputElement = driver.findElement(emailInput);

        By secondaryHeading = By.className("secondary-heading");
        var secondaryHeadingElement = driver.findElement(secondaryHeading);

        By exploreCollaborativeArticles = By.linkText("Join now");
        var exploreCollaborativeArticlesLink = driver.findElement(exploreCollaborativeArticles);

        By postPartialLink = By.partialLinkText("Privacy");
        var postYourPartialLink = driver.findElement(postPartialLink);

        assertNotNull(continueWithGoogleButton);
        assertNotNull(emailInputElement);
        assertNotNull(secondaryHeadingElement);
        assertNotNull(exploreCollaborativeArticlesLink);
        assertNotNull(postYourPartialLink);
    }

    private void navigateToLinkedInPage() {
        driver.navigate().to("https://www.linkedin.com/");
    }

    private void addInput(String name, String value) {
        By input = By.name(name);
        driver.findElement(input).sendKeys(value);
    }

    private void clickButton(String buttonID) {
        By buttonName = By.id(buttonID);
        driver.findElement(buttonName).click();
    }

    private void sendKeysToElementByXPath(String xpathExpression, String value) {
        By xpathInput = By.xpath(xpathExpression);
        driver.findElement(xpathInput).sendKeys(value);
    }

}
