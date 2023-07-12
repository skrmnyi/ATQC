package Tests;

import Config.BaseSeleniumTest;
import OrangeHRM.*;
import org.junit.jupiter.api.Test;

public class CheckNewVacancyCreateion extends BaseSeleniumTest {

    @Test
    public void checkNewVacancyCreation() {
        LoginPage loginPage = new LoginPage();
        NavigationBar navigationBar = new NavigationBar();
        MyInfoPage myInfoPage = new MyInfoPage();
        Recruitment recruitment = new Recruitment();
        AddVacancy vacancy = new AddVacancy();

        loginPage.successfulLogin("Admin", "admin123");
        navigationBar.goToRecruitmentPage();
        recruitment.goToVacanciesSection(driver);
        vacancy.createNewVacancy("QA Engineer");



    }
}
