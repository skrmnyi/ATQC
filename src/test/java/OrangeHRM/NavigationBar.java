package OrangeHRM;

import Config.BaseSeleniumPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationBar extends BaseSeleniumPage {
    MyInfoPage myInfoPage = new MyInfoPage();

    @FindBy(xpath = "//span[text()='My Info']")
    private WebElement myInfoMenuItem;

    public NavigationBar() {
        PageFactory.initElements(driver, this); //ініціалізація всіх описаних елементів на сторінці
    }

    public MyInfoPage goToMyInfoPage() {
        myInfoMenuItem.click();
        Assertions.assertTrue(myInfoPage.getPageTitle().contains("PIM"));
        return new MyInfoPage();
    }
}
