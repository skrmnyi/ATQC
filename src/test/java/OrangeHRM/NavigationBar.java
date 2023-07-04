package OrangeHRM;

import Config.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationBar extends BaseSeleniumPage {

    @FindBy(xpath = "//span[text()='My Info']")
    private WebElement myInfoMenuItem;

    public NavigationBar() {
        PageFactory.initElements(driver, this); //ініціалізація всіх описаних елементів на сторінці
    }

    public MyInfoPage goToMyInfoPage() {
        myInfoMenuItem.click();
        return new MyInfoPage();
    }

}
