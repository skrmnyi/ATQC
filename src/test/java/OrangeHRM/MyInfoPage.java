package OrangeHRM;

import Config.BaseSeleniumPage;
import org.openqa.selenium.Keys;
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

    @FindBy(id = "id=\"oxd-toaster_1\"")
    public WebElement successfulToaster;

    public MyInfoPage() {
        PageFactory.initElements(driver, this); //ініціалізація всіх описаних елементів на сторінці
    }

    public MyInfoPage updateUserName(String firstName, String lastName) {
        firstNameInput.clear();
        firstNameInput.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), firstName);
        //driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
        middleNameInput.clear();
        middleNameInput.sendKeys(Keys.HOME, Keys.chord(Keys.SHIFT, Keys.END), lastName);
        //driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
        //submitButton.click();
        //driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
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

    public String getToasterMessage() {
        return successfulToaster.getText();
    }


}