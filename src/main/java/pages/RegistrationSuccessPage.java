package pages;

import engine.ActionsBot;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RegistrationSuccessPage {
    private final String url = "https://ecommerce-playground.lambdatest.io/index.php?route=account/success";
    private final By successMessage = By.xpath("//h1[contains(@class,'page-title my-3')]");
    private WebDriver driver;
    private ActionsBot bot;

    public RegistrationSuccessPage(WebDriver driver, ActionsBot bot) {
        this.driver = driver;
        this.bot = bot;
    }

    public RegistrationSuccessPage navigateTo() {
        bot.navigate(url);
        return this;
    }

    public String getSuccessfulMessageText() {
        return bot.getText(successMessage);
    }

}
