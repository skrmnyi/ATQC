package Tests;


import Config.BaseSeleniumTest;
import OrangeHRM.LoginPage;
import OrangeHRM.MyInfoPage;
import OrangeHRM.NavigationBar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CheckUpdatedUserData extends BaseSeleniumTest {
    @Test
    public void checkUpdatedUserData() {
        LoginPage loginPage = new LoginPage();
        NavigationBar navigationBar = new NavigationBar();
        MyInfoPage myInfoPage = new MyInfoPage();
        loginPage.successfulLogin("Admin", "admin123");
        navigationBar.goToMyInfoPage();


        myInfoPage.updateUserName("NewName", "NewLastName");

        Assertions.assertEquals(myInfoPage.getUserName(), "NewName");
        Assertions.assertEquals(myInfoPage.getUserLastName(), ("NewLastName"));

    }
}
