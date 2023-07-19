package OrangeHRM;

import Config.BaseSeleniumPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AddVacancy extends BaseSeleniumPage {

    @FindBy(xpath = "//li[@class=\"oxd-topbar-body-nav-tab\"]/a")
    private WebElement vacanciesSection;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    private WebElement addButton;


    public String getVacancyNameText() {
        return vacancyNameInput.getAttribute("value");
    }

    @FindBy(xpath = "//label[text()=\"Vacancy Name\"]//parent::div//following-sibling::div/input")
    private WebElement vacancyNameInput;

    @FindBy(css = "[class=\"oxd-select-text--after\"]")
    private WebElement jobTitleDropDown;

    @FindBy(xpath = "//textarea[@placeholder]")
    private WebElement vacancyDescriptionInput;

    @FindBy(xpath = "//input[@placeholder=\"Type for hints...\"]")
    private WebElement hiringManagerInput;

    @FindBy(xpath = "//div[@role=\"listbox\"]/div/span")
    WebElement returnedSearchedManagerValue;

    @FindBy(xpath = "//*[text()=\"Number of Positions\"]/parent::div/following-sibling::div/input")
    WebElement numberOfPositionsInput;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    public
    WebElement saveButton;

    @FindBy(xpath = "//div[@class=\"orangehrm-card-container\"]//h6")
    WebElement pageSubTitle;

    public String getSubTitle() {
        return pageSubTitle.getText();
    }

    public void expandDropdown() {
        jobTitleDropDown.click();
    }

    public void jobTitleValueAtDropDown(String jobTitle) {
        jobTitleDropDown.findElement(By.xpath("//div[@role=\"option\"]/span[text()='" + jobTitle + "']")).click();
    }


    public AddVacancy createNewVacancy(String vacancy, String vacancyDesc, String hiringManager, String numberOfPositions) {
        addButton.click();
        vacancyNameInput.sendKeys("QA new test vacancy");
        expandDropdown();
        jobTitleValueAtDropDown(vacancy);
        vacancyDescriptionInput.sendKeys(vacancyDesc);
        hiringManagerInput.sendKeys(hiringManager);
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(driver -> driver.findElement(By.xpath("//div[@role=\"listbox\"]")));
        returnedSearchedManagerValue.click();
        numberOfPositionsInput.sendKeys(numberOfPositions);
        //openSelectDropDownValue(jobTitleDropDown, jobTitleValueAtDropDown("QA Engineer"));
        // cant do it through general method, cause dont know how to make returned webelement in jobTitleValueAtDropDown argument
        return new AddVacancy();
    }

    public EditVacancy saveChanges (){
        saveButton.click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return new EditVacancy();
    }
}
