package SeleniumJunit.Tests;


import SeleniumJunit.Config.BaseSeleniumTest;
import SeleniumJunit.OrangeHRM.LoginPage;
import org.junit.jupiter.api.Test;

public class CheckLoginTest extends BaseSeleniumTest {
    @Test
    public void checkLoginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.successfulLogin("Admin", "admin123");
    }
}
