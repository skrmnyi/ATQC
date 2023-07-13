package OrangeHRM;


import Config.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseSeleniumPage {
    @FindBy(xpath = "//input[@name=\"username\"]")
    private WebElement userNameField;

    @FindBy(xpath = "//input[@name=\"password\"]")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement submitButton;

    @FindBy(xpath = "//p[text()=\"Forgot your password? \"]")
    private WebElement forgotPasswordButton;


    public LoginPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    public NavigationBar successfulLogin(String userName, String password) {
        userNameField.sendKeys(userName);
        passwordField.sendKeys(password);
        submitButton.click();
        return new NavigationBar();

    }
}
