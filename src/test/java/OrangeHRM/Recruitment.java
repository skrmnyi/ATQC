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

    //@FindBy(xpath = "//button[text()=\" Add \"];")
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    private WebElement addButton;

    public void checkVacancyIsDisplayed(String vacancy, String jobTitle, String hiringManager) {
        driver.findElement(By.xpath("//div[text()='" +vacancy+ "']")).isDisplayed();
        driver.findElement(By.xpath("//div[text()='" +jobTitle+ "']")).isDisplayed();
        driver.findElement(By.xpath("//div[text()='" +jobTitle+ "']")).isDisplayed();
    }

    public Vacancies deleteSpecificVacancy (String vacancyName) {
        driver.findElement(By.xpath("//div[text()='"+vacancyName+"']" +
                "/parent::div/parent::div/div/div[@class=\"oxd-table-card-cell-checkbox\"]")).click();
        driver.findElement(By.xpath("//button[text()=' Delete Selected ']")).click();
        driver.findElement(By.xpath("//button[text()=' Yes, Delete ']")).click();
        successDeleteToaster.isDisplayed();
        return new Vacancies();
    }
    @FindBy(xpath =  "//div/label[text()=\"Vacancy Name\"]")
    private WebElement vacancyNameInput;

    @FindBy (css = "[class=\"oxd-topbar-body-nav-tab\"]")
    private WebElement vacancyNavButton;


    public static By jobTitleValueAtDropDown(String jobTitle) {
        String locator = "//div[@class='oxd-select-wrapper']/div/div[text()='" +jobTitle + "']";
        return By.xpath(locator);
    }

    @FindBy(xpath = "//p[text()='Successfully Deleted']")
    private WebElement successDeleteToaster;


    public Recruitment() {
        PageFactory.initElements(driver, this); //ініціалізація всіх описаних елементів на сторінці
    }

//
//    public void createNewVacancy(String vacancy){
//        addButton.click();
//        vacancyNameInput.sendKeys("some value");
//        driver.findElement(jobTitleValueAtDropDown(vacancy)).click();
//
//    }
public Recruitment goToVacanciesSection(WebDriver driver){
    //driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/viewJobVacancy");
    vacancyNavButton.click();
    return new Recruitment();
}

    public AddVacancy createNewVacancy(String vacancy){
        //WebElement addButton2 = driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']"));
        addButton.click();
        return new AddVacancy();
    }
}
