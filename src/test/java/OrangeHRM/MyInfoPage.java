package OrangeHRM;

import Config.BaseSeleniumPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class MyInfoPage extends BaseSeleniumPage {

    @FindBy(xpath = "//h6[text()='PIM']")
    private WebElement myInfoHeaderData;

    @FindBy(xpath = "//a[text()=\"Personal Details\"]")
    private WebElement personalDetails;


    @FindBy(name = "firstName")
    private WebElement firstNameInput;

    @FindBy(name = "middleName")
    private WebElement middleNameInput;

    @FindBy(xpath = "//*[contains(@class, 'orangehrm-form-hint')]//following-sibling::button")
    public WebElement submitButton;

    @FindBy(xpath = "//*[contains(@class, 'toast-message')]")
    public WebElement successfulToaster;


    public MyInfoPage updateUserName(String firstName, String lastName) {
        firstNameInput.clear();
        firstNameInput.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), firstName);
        middleNameInput.clear();
        middleNameInput.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), lastName);
        return new MyInfoPage();
    }

    public String getPageTitle() {
        return myInfoHeaderData.getText();
    }

    public String getUserName() {
        return firstNameInput.getAttribute("value");
    }

    public String getUserLastName() {
        return middleNameInput.getAttribute("value");
    }

    public String getToasterText() {
        return successfulToaster.getText();
    }

    public void checkIfSuccessfulMessageDisplayed() {
        submitButton.click();
        successfulToaster = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(driver -> driver.findElement(By.xpath("//*[contains(@class, 'toast-message')]")));
        Assertions.assertTrue(getToasterText().contains("Successfully Updated"));
    }

}