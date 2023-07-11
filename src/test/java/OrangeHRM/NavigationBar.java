package OrangeHRM;

import Config.BaseSeleniumPage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationBar extends BaseSeleniumPage {
    MyInfoPage myInfoPage = new MyInfoPage();

    @FindBy(xpath = "//span[text()='My Info']")
    private WebElement myInfoMenuItem;

    @FindBy(xpath = "//span[text()='Recruitment']")
    private WebElement recruitmentMenuItem;

    public static By pageHeader(String pageHeader) {
        String locator = "//h6[text()='" +pageHeader + "']";
        return By.xpath(locator);
    }



    public NavigationBar() {
        PageFactory.initElements(driver, this); //ініціалізація всіх описаних елементів на сторінці
    }

    public MyInfoPage goToMyInfoPage() {
        myInfoMenuItem.click();
        Assertions.assertTrue(myInfoPage.getPageTitle().contains("PIM"));
        return new MyInfoPage();
    }

    public Recruitment goToRecruitmentPage() {
        recruitmentMenuItem.click();
        Assertions.assertEquals(driver.findElement(pageHeader("Recruitment")).getText(), "Recruitment");
        return new Recruitment();
    }
}
