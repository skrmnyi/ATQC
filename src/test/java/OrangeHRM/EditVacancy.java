package OrangeHRM;

import Config.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditVacancy extends BaseSeleniumPage {

    @FindBy(xpath = "//a[text()='Vacancies']")
    private WebElement vacancyNavButton;

    public Vacancies backToListOfVacancies() {
        vacancyNavButton.click();
        return new Vacancies();
    }
}


