package Config;

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

import static Config.BaseSeleniumPage.getToasterText;

abstract public class BaseSeleniumPage implements WebDriver {
    protected static WebDriver driver;

    public static void setDriver(WebDriver webDriver) {
        driver = webDriver;
    }

    public BaseSeleniumPage() {
        PageFactory.initElements(driver, this);
    }

    public void openSelectDropDownValue(WebElement dropDownName, WebElement dropDownValue) {
        dropDownName.click();
        dropDownValue.click();
    }

    @FindBy(xpath = "//p[contains(@class, 'toast-message')]")
    public static WebElement successfulToaster;

    public static String getToasterText() {
        return successfulToaster.getAttribute("innerText");

    }

    public static void checkIfSuccessfulMessageDisplayed(String ToasterMessage) {
        successfulToaster = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(driver -> driver.findElement(By.xpath("//div[@class=\"oxd-toast-container oxd-toast-container--bottom\"]")));
        Assertions.assertEquals(ToasterMessage, getToasterText());
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
