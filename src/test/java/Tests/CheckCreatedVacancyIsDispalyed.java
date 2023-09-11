package Tests;

import Config.BaseSeleniumTest;
import OrangeHRM.*;
import org.junit.jupiter.api.Test;

public class CheckCreatedVacancyIsDispalyed extends BaseSeleniumTest {

    @Test
    public void checkCreatedVacancyIsDispalyed() {
        LoginPage loginPage = new LoginPage();
        NavigationBar navigationBar = new NavigationBar();
        Recruitment recruitment = new Recruitment();
        Vacancies vacancies = new Vacancies();

        loginPage.successfulLogin("Admin", "admin123");
        navigationBar.goToRecruitmentPage();
        recruitment.goToVacanciesSection(driver);
        vacancies.checkVacancyIsDisplayed("QA new test vacancy", "QA Engineer", "Lisa Andrews");
    }
}