package OrangeHRM;

import Config.BaseSeleniumPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class Recruitment extends BaseSeleniumPage {


    @FindBy(xpath = "//a[text()='Vacancies']")
    private WebElement vacancyNavButton;

    public Recruitment() {
        PageFactory.initElements(driver, this); //ініціалізація всіх описаних елементів на сторінці
    }

    public Vacancies goToVacanciesSection() {
        vacancyNavButton.click();
        return new Vacancies();
    }


}
