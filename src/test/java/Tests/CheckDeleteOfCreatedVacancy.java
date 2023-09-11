package Tests;

import Config.BaseSeleniumTest;
import OrangeHRM.LoginPage;
import OrangeHRM.NavigationBar;
import OrangeHRM.Recruitment;
import OrangeHRM.Vacancies;
import org.junit.jupiter.api.Test;

public class CheckDeleteOfCreatedVacancy extends BaseSeleniumTest {

    @Test
    public void checkDeleteOfCreatedVacancy () {
        LoginPage loginPage = new LoginPage();
        NavigationBar navigationBar = new NavigationBar();
        Recruitment recruitment = new Recruitment();
        Vacancies vacancies = new Vacancies();

        loginPage.successfulLogin("Admin", "admin123");
        navigationBar.goToRecruitmentPage();
        recruitment.goToVacanciesSection(driver);
        //ask why not working in headless
        vacancies.deleteSpecificVacancy("QA new test vacancy");
    }
}

