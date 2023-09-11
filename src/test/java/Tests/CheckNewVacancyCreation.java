package Tests;

import Config.BaseSeleniumTest;
import OrangeHRM.*;
import org.junit.jupiter.api.Test;

public class CheckNewVacancyCreation extends BaseSeleniumTest {

    @Test
    public void checkNewVacancyCreation() {
        LoginPage loginPage = new LoginPage();
        NavigationBar navigationBar = new NavigationBar();
        MyInfoPage myInfoPage = new MyInfoPage();
        Recruitment recruitment = new Recruitment();
        Vacancies vacanciesPage = new Vacancies();
        AddVacancy addVacancy = new AddVacancy();
        EditVacancy editVacancy = new EditVacancy();

        loginPage.successfulLogin("Admin", "admin123");
        navigationBar.goToRecruitmentPage();
        recruitment.goToVacanciesSection(driver);
        vacanciesPage.openAddVacancyPage();
        addVacancy.createNewVacancy("QA Engineer", "Vacancy for testing purpose",
                "Lisa Andrews", "1");
    }
}
