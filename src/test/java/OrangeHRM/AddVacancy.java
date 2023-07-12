package OrangeHRM;

import Config.BaseSeleniumPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Set;

public class AddVacancy extends BaseSeleniumPage {

    @FindBy(xpath = "//li[@class=\"oxd-topbar-body-nav-tab\"]/a")
    private WebElement vacanciesSection;

    //@FindBy(xpath = "//button[text()=\" Add \"];")
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    private WebElement addButton;


    @FindBy(xpath = "//label[text()=\"Vacancy Name\"]//parent::div//following-sibling::div/input")
    private WebElement vacancyNameInput;

    @FindBy(css = "[class=\"oxd-select-text--after\"]")
    private WebElement jobTitleDropDown;
    public void expandDropdown(){
        jobTitleDropDown.click();
    }

    public void jobTitleValueAtDropDown(String jobTitle) {
        jobTitleDropDown.findElement(By.xpath("//div[@class='oxd-select-wrapper']/div/div[text()='" + jobTitle + "']")).click();

    }

    public  AddVacancy() {
        PageFactory.initElements(driver, this);
    }



    public AddVacancy createNewVacancy(String vacancy) {
        addButton.click();
        vacancyNameInput.sendKeys("QA new test vacancy");
        expandDropdown();
        jobTitleValueAtDropDown(vacancy);

        int i = 0;
        return new AddVacancy();
    }

}
