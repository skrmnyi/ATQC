package Tests;


import Config.BaseSeleniumTest;
import OrangeHRM.LoginPage;
import OrangeHRM.DashboardPage;
import OrangeHRM.MyInfoPage;
import OrangeHRM.NavigationBar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

public class CheckUpdatedUserData extends BaseSeleniumTest {
    @Test
    public void checkUpdatedUserData() {
        LoginPage loginPage = new LoginPage();
        NavigationBar navigationBar = new NavigationBar();
        MyInfoPage myInfoPage = new MyInfoPage();
        loginPage.successfulLogin("Admin", "admin123");
        navigationBar.goToMyInfoPage();
        //TO:DO please move this assert inside  goToMyInfoPage() to make sure it will be used each time
        Assertions.assertTrue(myInfoPage.getPageTitle().contains("PIM"));

        myInfoPage.updateUserName("NewName", "NewLastName");

        Assertions.assertEquals(myInfoPage.getUserName(), "NewName");
        Assertions.assertEquals(myInfoPage.getUserLastName(), ("NewLastName"));

        Assertions.assertTrue(myInfoPage.getToasterMessage().equals("Success"));


    }
}
