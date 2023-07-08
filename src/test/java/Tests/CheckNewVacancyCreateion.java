package Tests;

import Config.BaseSeleniumTest;
import OrangeHRM.LoginPage;
import OrangeHRM.MyInfoPage;
import OrangeHRM.NavigationBar;
import OrangeHRM.Recruitment;
import org.junit.jupiter.api.Test;

public class CheckNewVacancyCreateion extends BaseSeleniumTest {

    @Test
    public void checkNewVacancyCreateion () {
        LoginPage loginPage = new LoginPage();
        NavigationBar navigationBar = new NavigationBar();
        MyInfoPage myInfoPage = new MyInfoPage();
        loginPage.successfulLogin("Admin", "admin123");
        navigationBar.goToRecruitmentPage();
        Recruitment recruitment = new Recruitment();
        recruitment.goToVacanciesSection();

        recruitment.createNewVacancy("QA Engineer");

    }
}
