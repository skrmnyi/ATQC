package Config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import static Config.ColorPrinter.printColorMessage;


abstract public class BaseSeleniumPage implements WebDriver {


    protected static WebDriver driver;


//    public BaseSeleniumPage(WebDriver driver, String title) {
//        this.driver = driver;
//        this.title = title;
//        this.log = LogManager.getLogger(this.title);
//        printColorMessage("Page object of" + title + this.getClass().getName(), log, Level.DEBUG);
//
//    }

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public  BaseSeleniumPage() {
        PageFactory.initElements(driver, this);
    }

    public void openSelectDropDownValue(WebElement dropDownName, WebElement dropDownValue) {
        dropDownName.click();
        dropDownValue.click();
    }

    @FindBy(xpath = "//div[@class=\"oxd-form-actions\"]//button[@type=\"submit\"]")
    public static
    WebElement saveButton;

    @FindBy(xpath = "///p[contains(@class, 'toast-message')]")
    public static WebElement successfulToaster;

    public static String getToasterText() {
        return successfulToaster.getText();
    }

    public static void checkIfSuccessfulMessageDisplayed(String toasterMessage) {
        saveButton.click();
        successfulToaster = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(driver -> driver.findElement(By.xpath("//p[contains(@class, 'toast-message')]")));
        Assertions.assertTrue(getToasterText().contains(toasterMessage));
    }


    @Override
    public void get(String url) {
    }

    @Override
    public String getCurrentUrl() {
        return null;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public List<WebElement> findElements(By by) {
        return null;
    }

    @Override
    public WebElement findElement(By by) {
        return null;
    }

    @Override
    public String getPageSource() {
        return null;
    }

    @Override
    public void close() {

    }

    @Override
    public void quit() {

    }

    @Override
    public Set<String> getWindowHandles() {
        return null;
    }

    @Override
    public String getWindowHandle() {
        return null;
    }

    @Override
    public TargetLocator switchTo() {
        return null;
    }

    @Override
    public Navigation navigate() {
        return null;
    }

    @Override
    public Options manage() {
        return null;
    }


}
