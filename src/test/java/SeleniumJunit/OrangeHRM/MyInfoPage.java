package SeleniumJunit.OrangeHRM;

import SeleniumJunit.Config.BaseSeleniumPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public void macCleanHack(WebElement element) {
        String inputText = element.getAttribute("value");
        if( inputText != null ) {
            for(int i=0; i<inputText.length();i++) {
                element.sendKeys(Keys.BACK_SPACE);
            }
        }

    }

    public MyInfoPage updateUserName (String firstName, String lastName){
        firstNameInput.sendKeys(firstName);
        middleNameInput.sendKeys(lastName);
        submitButton.click();
        return new MyInfoPage();
    }

    public String getPageTitle () {
        return myInfoHeaderData.getText();
    }

    public String getUserName () {
        return firstNameInput.getText();
    }

    public String getUserLastName () {
        return middleNameInput.getText();
    }
}