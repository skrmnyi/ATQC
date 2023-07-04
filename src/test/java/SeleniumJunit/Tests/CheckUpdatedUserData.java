package SeleniumJunit.Tests;

import SeleniumJunit.Config.BaseSeleniumTest;
import SeleniumJunit.OrangeHRM.LoginPage;
import SeleniumJunit.OrangeHRM.MainPage;
import SeleniumJunit.OrangeHRM.MyInfoPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

public class CheckUpdatedUserData extends BaseSeleniumTest {
    @Test
    public void checkUpdatedUserData() {
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = new MainPage();
        MyInfoPage myInfoPage = new MyInfoPage();

        loginPage.successfulLogin("Admin", "admin123");
        mainPage.goToMyInfoPage();
        Assertions.assertTrue(myInfoPage.getPageTitle().contains("PIM"));

        myInfoPage.updateUserName("NewUser", "UpdatedLastName");
        Assertions.assertTrue(myInfoPage.getUserLastName().equals("NewUser"));
        Assertions.assertTrue(myInfoPage.getUserLastName().equals("UpdatedLastName"));


    }
}
