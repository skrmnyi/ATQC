package OrangeHRM;

import Config.BaseSeleniumPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Vacancies extends BaseSeleniumPage {

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    private WebElement addButton;

    @FindBy(xpath = "//p[text()='Successfully Deleted']")
    private WebElement successDeleteToaster;

    public AddVacancy openAddVacancyPage(){
        addButton.click();
        return new AddVacancy();
    }

    public void checkVacancyIsDisplayed(String vacancy, String jobTitle, String hiringManager) {
        driver.findElement(By.xpath("//div[text()='" + vacancy + "']")).isDisplayed();
        driver.findElement(By.xpath("//div[text()='" + jobTitle + "']")).isDisplayed();
        driver.findElement(By.xpath("//div[text()='" + jobTitle + "']")).isDisplayed();
    }

    public Vacancies deleteSpecificVacancy(String vacancyName) {
        driver.findElement(By.xpath("//div[text()='" + vacancyName + "']" +
                "/parent::div/parent::div/div/div[@class=\"oxd-table-card-cell-checkbox\"]")).click();
        driver.findElement(By.xpath("//button[text()=' Delete Selected ']")).click();
        driver.findElement(By.xpath("//button[text()=' Yes, Delete ']")).click();
        successDeleteToaster.isDisplayed();
        return new Vacancies();
    }
}
