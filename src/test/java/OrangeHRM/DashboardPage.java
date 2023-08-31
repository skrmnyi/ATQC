package OrangeHRM;


import Config.BaseSeleniumPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage extends BaseSeleniumPage {

    //1й спосіб -  записувати елементи а потім звертатись до них для пошуку
    // пошук елемента відбуватиметься кожен запуск теста, навіть якщо така перевірка не запланована

    //private final By dashboardMenuItemm = By.xpath("//span[text()='Dashboard']");
    //private WebElement dashboardMenuItemElement = driver.findElement(dashboardMenuItemm);

    //2 спосіб - більш зручний. через анотацію файнд бай, пошук елемента відбувається тільки тоді коли йде звернення до елемента

    @FindBy(xpath = "//h6[text()='Dashboard']")
    private WebElement dashboardHeader;

    @FindBy(xpath = "//span[text()='My Info']")
    private WebElement myInfoMenuItem;

    public DashboardPage() {
        PageFactory.initElements(driver, this); //ініціалізація всіх описаних елементів на сторінці
    }



}


