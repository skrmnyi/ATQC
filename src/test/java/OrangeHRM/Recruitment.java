package OrangeHRM;

import Config.BaseSeleniumPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class Recruitment extends BaseSeleniumPage {

    @FindBy(xpath = "//li[@class=\"oxd-topbar-body-nav-tab\"]/a")
    private WebElement vacanciesSection;

    //@FindBy(xpath = "//button[text()=\" Add \"];")
    @FindBy(xpath = "//button[@class=\"oxd-button oxd-button--medium oxd-button--secondary\"]")
    private WebElement addButton;

    @FindBy(xpath =  "//div/label[text()=\"Vacancy Name\"]")
    private WebElement vacancyNameInput;

    public static By jobTitleValueAtDropDown(String jobTitle) {
        String locator = "//div[@class='oxd-select-wrapper']/div/div[text()='" +jobTitle + "']";
        return By.xpath(locator);
    }


    public void goToVacanciesSection(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/viewJobVacancy");

    }
//
//    public void createNewVacancy(String vacancy){
//        addButton.click();
//        vacancyNameInput.sendKeys("some value");
//        driver.findElement(jobTitleValueAtDropDown(vacancy)).click();
//
//    }


    public AddVacancy createNewVacancy(String vacancy){
        addButton.click();
        vacancyNameInput.sendKeys("some value");
        driver.findElement(jobTitleValueAtDropDown(vacancy)).click();
        return new AddVacancy();
    }
}
