package OrangeHRM;

import Config.BaseSeleniumPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class Recruitment extends BaseSeleniumPage {

    @FindBy(xpath = "//li[@class=\"oxd-topbar-body-nav-tab\"]/a")
    private WebElement vacanciesSection;

    @FindBy(xpath = "//div/label[text()=\"Vacancy Name\"]")
    private WebElement vacancyNameInput;

    @FindBy(css = "[class=\"oxd-topbar-body-nav-tab\"]")
    private WebElement vacancyNavButton;


    public static By jobTitleValueAtDropDown(String jobTitle) {
        String locator = "//div[@class='oxd-select-wrapper']/div/div[text()='" + jobTitle + "']";
        return By.xpath(locator);
    }

    @FindBy(xpath = "//p[text()='Successfully Deleted']")
    private WebElement successDeleteToaster;


    public Recruitment() {
        PageFactory.initElements(driver, this); //ініціалізація всіх описаних елементів на сторінці
    }

    public Vacancies goToVacanciesSection(WebDriver driver) {
        vacancyNavButton.click();
        return new Vacancies();
    }
}
