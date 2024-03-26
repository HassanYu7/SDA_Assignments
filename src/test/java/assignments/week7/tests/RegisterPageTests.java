package assignments.week7.tests;

import assignments.TestBase;
import org.testng.annotations.Test;
import pages.RegisterPage;

public class RegisterPageTests extends TestBase {

         /*
            go to url : https://ecommerce-playground.lambdatest.io/index.php?route=account/register
            register account test with fluent page object approach
         */

    @Test
    public void test() {
        new RegisterPage(driver, bot)
                .navigateToRegisterPage()
                .register("ahmed",
                        "mohamed",
                        "dsads@hotmail.com",
                        "09666e34",
                        "2323",
                        true
                );

    }


}
