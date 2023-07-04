package OrangeHRM;

import Config.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

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
    private WebElement submitButton;

    public MyInfoPage() {
        PageFactory.initElements(driver, this); //ініціалізація всіх описаних елементів на сторінці
    }


    public MyInfoPage updateUserName(String firstName, String lastName) {
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        firstNameInput.clear();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        firstNameInput.sendKeys(firstName);


        middleNameInput.clear();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        middleNameInput.sendKeys(lastName);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        submitButton.click();
        return new MyInfoPage();
    }

    public String getPageTitle() {
        return myInfoHeaderData.getText();
    }

    public String getUserName() {
        return firstNameInput.getText();
    }

    public String getUserLastName() {
        return middleNameInput.getText();
    }
}