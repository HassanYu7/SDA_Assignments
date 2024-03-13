package assignments.week5;

import assignments.TestBase;
import org.openqa.selenium.Cookie;
import org.testng.annotations.Test;

public class CookieOperations extends TestBase {

     /*
        Go to URL: http://facebook.com
        getCookies,
        addCookie,
        deleteCookieNamed,
        deleteAllCookies
     */


    @Test
    public void cookieOperations(){
        // Navigate to Facebook
        bot.navigate("https://www.facebook.com");

        // Get current cookies
        driver.manage().getCookies();

        // Add a new cookie
        Cookie newCookie = new Cookie("testCookie", "testValue");
        driver.manage().addCookie(newCookie);

        // Delete a specific cookie by name
        driver.manage().deleteCookie(newCookie);

        // Delete all cookies
        driver.manage().deleteAllCookies();

    }
}
