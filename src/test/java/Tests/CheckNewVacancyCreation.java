package Tests;

import Config.BaseSeleniumTest;
import OrangeHRM.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static Config.BaseSeleniumPage.checkIfSuccessfulMessageDisplayed;

public class CheckNewVacancyCreation extends BaseSeleniumTest {

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
        vacancy.createNewVacancy("QA Engineer", "Vacancy for testing purpose",
                "Lisa Andrews", "1");
        vacancy.saveButton.click();

        checkIfSuccessfulMessageDisplayed("Successfully saved");
        Assertions.assertEquals(vacancy.getSubTitle(), "Edit Vacancy");

    }
}