package OrangeHRM;


import Config.BaseSeleniumPage;
import Config.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.LoggerFactory;

import static Config.ColorPrinter.printColorMessage;

public class LoginPage extends BaseSeleniumPage {

    Logger log;
    public final static String TITLE = "Home page";


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
        log = LogManager.getLogger(this.TITLE);
        printColorMessage("Successful authorization", log, Level.INFO);
        return new NavigationBar();
    }
}
