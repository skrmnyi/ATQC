package Tests;


import Config.BaseSeleniumTest;
import OrangeHRM.LoginPage;
import OrangeHRM.MyInfoPage;
import OrangeHRM.NavigationBar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;


public class CheckUpdatedUserData extends BaseSeleniumTest {
    @Order(2)
    @Test
    public void checkUpdatedUserData() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        NavigationBar navigationBar = new NavigationBar();
        MyInfoPage myInfoPage = new MyInfoPage();
        loginPage.successfulLogin("Admin", "admin123");
        navigationBar.goToMyInfoPage();


        myInfoPage.updateUserName("NewName", "NewLastName");

        Assertions.assertEquals( "NewName", myInfoPage.getUserName());
        Assertions.assertEquals( "NewLastName", myInfoPage.getUserLastName());
        //myInfoPage.checkIfSuccessfulMessageDisplayed();
    }
}
