package pages;

import engine.ActionsBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RegisterPage {


    private final String url = "https://ecommerce-playground.lambdatest.io/index.php?route=account/register";
    private final By firstNameInput = By.id("input-firstname");
    private final By lastNameInput = By.id("input-lastname");
    private final By emailInput = By.id("input-email");
    private final By telephoneInput = By.id("input-telephone");
    private final By passwordInput = By.id("input-password");
    private final By passwordConfirmInput = By.id("input-confirm");

    private final By agreeInput = By.xpath("//label[@for='input-agree']");
    private final By submitButton = By.xpath("//input[@type='submit']");

    private final By failureMessage = By.className("text-danger");
    private WebDriver driver;
    private ActionsBot bot;

    public RegisterPage(WebDriver driver, ActionsBot bot) {
        this.driver = driver;
        this.bot = bot;
    }

    public RegisterPage navigateTo() {
        bot.navigate(url);
        return this;
    }

    public RegistrationSuccessPage successfulRegister(String firstname, String lastname, String email, String telephone, String password, String confirmPassword) {
        register(firstname, lastname, email, telephone, password, confirmPassword);
        return new RegistrationSuccessPage(driver, bot);
    }

    public RegisterPage failedRegister(String firstname, String lastname, String email, String telephone, String password, String confirmPassword) {
        register(firstname, lastname, email, telephone, password, confirmPassword);
        return this;
    }

    private void register(String firstname, String lastname, String email, String telephone, String password, String confirmPassword) {
        bot.type(firstNameInput, firstname);
        bot.type(lastNameInput, lastname);
        bot.type(emailInput, email);
        bot.type(telephoneInput, telephone);
        bot.type(passwordInput,password);
        bot.type(passwordConfirmInput,confirmPassword);
        bot.click(agreeInput);
        bot.click(submitButton);
    }

    public String failureMessage(){
        return bot.getText(failureMessage);
    }


}
