package assignments.week7.task1tests;

import assignments.TestBase;
import org.testng.annotations.Test;
import pages.RegisterPage;

import static org.testng.AssertJUnit.assertEquals;

public class RegisterPageTests extends TestBase {


    @Test(description = "Verify successful registration with valid information")
    public void verifySuccessfulRegistration() {
        assertEquals("Your Account Has Been Created!",
                new RegisterPage(driver, bot)
                        .navigateTo()
                        .successfulRegister("Hassan", "Alharbi", "test9@gmail.com", "4334", "545445", "545445")
                        .getSuccessfulMessageText());
    }

    @Test(description = "Registration failure due to invalid password length")
    public void verifyFailedRegistrationInvalidPasswordLength() {
        assertEquals("Password must be between 4 and 20 characters!",
                new RegisterPage(driver, bot)
                        .navigateTo()
                        .failedRegister("Anas", "Ahmed", "test10@gmail.com", "34433", "33", "33")
                        .failureMessage());
    }


}
