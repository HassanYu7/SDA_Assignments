package pages;

import engine.ActionsBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {


    private WebDriver driver;
    private ActionsBot bot;

    private final String url = "https://ecommerce-playground.lambdatest.io/index.php?route=account/register";
    private final By firstNameInput = By.id("input-firstname");
    private final By lastNameInput = By.id("input-lastname");
    private final By emailInput = By.id("input-email");
    private final By telephoneInput = By.id("input-telephone");
    private final By passwordInput = By.id("input-password");
    private final By passwordConfirmInput = By.id("input-confirm");
    private final By yesNewsletterInput = By.id("input-newsletter-yes");
    private final By noNewsletterInput = By.id("input-newsletter-no");
    private final By agreeInput = By.id("input-agree");
    private final By submitButton = By.xpath("//input[@type='submit']");

    public RegisterPage(WebDriver driver, ActionsBot bot) {
        this.driver = driver;
        this.bot = bot;
    }

    public RegisterPage navigateToRegisterPage(){
        bot.navigate(url);
        return this;
    }

    public RegisterPage register(String firstname,
                                 String lastname,
                                 String email,
                                 String telephone,
                                 String password,
                                 boolean subscribeNewsletter
    ){
        personalDetails(firstname,lastname,email,telephone,password);
        bot.click(submitButton);
        return this;
    }


    private void personalDetails(String firstname,String lastname, String email, String telephone,String password){
        bot.type(firstNameInput,firstname);
        bot.type(lastNameInput,lastname);
        bot.type(emailInput,email);
        bot.type(telephoneInput,telephone);
        bot.type(passwordInput,password);
        bot.type(passwordConfirmInput,password);
    }

}
