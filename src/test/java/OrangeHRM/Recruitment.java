package OrangeHRM;

import Config.BaseSeleniumPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class Recruitment extends BaseSeleniumPage {


    @FindBy(xpath = "//a[text()='Vacancies']")
    private WebElement vacancyNavButton;

    @FindBy(xpath = "//p[text()='Successfully Deleted']")
    private WebElement successDeleteToaster;


    public Recruitment() {
        PageFactory.initElements(driver, this); //ініціалізація всіх описаних елементів на сторінці
    }

    public Vacancies goToVacanciesSection() {
        vacancyNavButton.click();
        return new Vacancies();
    }

    public boolean checkVacancyIsDisplayed(String vacancy, String jobTitle, String hiringManager) {
        driver.findElement(By.xpath("//div[text()='" +vacancy+ "']")).isDisplayed();
        driver.findElement(By.xpath("//div[text()='" +jobTitle+ "']")).isDisplayed();
        driver.findElement(By.xpath("//div[text()='" +jobTitle+ "']")).isDisplayed();
        return true;
    }

    public Vacancies deleteSpecificVacancy (String vacancyName) {
        driver.findElement(By.xpath("//div[text()='"+vacancyName+"']" +
                "/parent::div/parent::div/div/div[@class=\"oxd-table-card-cell-checkbox\"]")).click();
        driver.findElement(By.xpath("//button[text()=' Delete Selected ']")).click();
        driver.findElement(By.xpath("//button[text()=' Yes, Delete ']")).click();
        successDeleteToaster.isDisplayed();
        return new Vacancies();
    }
}
