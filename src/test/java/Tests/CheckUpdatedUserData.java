package Tests;


import Config.BaseSeleniumTest;
import OrangeHRM.LoginPage;
import OrangeHRM.MainPage;
import OrangeHRM.MyInfoPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckUpdatedUserData extends BaseSeleniumTest {
    @Test
    public void checkUpdatedUserData() {
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = new MainPage();
        MyInfoPage myInfoPage = new MyInfoPage();

        loginPage.successfulLogin("Admin", "admin123");
        mainPage.goToMyInfoPage();

        Assertions.assertTrue(myInfoPage.getPageTitle().contains("PIM"));

        myInfoPage.updateUserName("justName_notUnique", "notUniquieAbracadabra");
        Assertions.assertTrue(myInfoPage.getUserLastName().equals("NewUser"));
        Assertions.assertTrue(myInfoPage.getUserLastName().equals("UpdatedLastName"));


    }
}
