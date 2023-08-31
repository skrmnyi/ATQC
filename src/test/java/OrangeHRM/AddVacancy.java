package OrangeHRM;

import Config.BaseSeleniumPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddVacancy extends BaseSeleniumPage {
    public void createNewVacancy(String vacancy){
        driver.findElement(By.xpath("//div/label[text()='Vacancy Name']")).sendKeys("test name");
        //driver.findElement(jobTitleValueAtDropDown(vacancy)).();

 }
    //vacancyNameInput.sendKeys("some value");
    //        driver.findElement(jobTitleValueAtDropDown(vacancy)).click();


    public static By jobTitleValueAtDropDown(String jobTitle) {
        String locator = "//div[@class='oxd-select-wrapper']/div/div[text()='" +jobTitle + "']";
        return By.xpath(locator);
    }
}
