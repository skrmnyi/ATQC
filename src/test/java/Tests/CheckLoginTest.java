package Tests;


import Config.BaseSeleniumTest;
import OrangeHRM.LoginPage;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class CheckLoginTest extends BaseSeleniumTest {
   @Order(1)
    @Test
    public void checkLoginTest() {
        LoginPage loginPage = new LoginPage();
        loginPage.successfulLogin("Admin", "admin123");
    }
}
