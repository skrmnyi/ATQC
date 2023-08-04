package Tests;

import Config.BaseSeleniumTest;
import OrangeHRM.LoginPage;
import OrangeHRM.NavigationBar;
import OrangeHRM.Recruitment;
import org.junit.jupiter.api.Test;

public class CheckDeleteOfCreatedVacancy extends BaseSeleniumTest {

    @Test
    public void checkDeleteOfCreatedVacancy () {
        LoginPage loginPage = new LoginPage();
        NavigationBar navigationBar = new NavigationBar();
        Recruitment recruitment = new Recruitment();

        loginPage.successfulLogin("Admin", "admin123");
        navigationBar.goToRecruitmentPage();
        recruitment.goToVacanciesSection();
        recruitment.deleteSpecificVacancy("QA new test vacancy");



    }
}

