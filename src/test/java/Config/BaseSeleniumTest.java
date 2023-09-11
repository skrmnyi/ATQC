package Config;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract public class BaseSeleniumTest {
    protected WebDriver driver;

    @BeforeEach
    public void setUp () {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        //chromeOptions.addArguments("--headless");

        WebDriverManager.getInstance(DriverManagerType.CHROME).clearResolutionCache();
        WebDriverManager.getInstance(DriverManagerType.CHROME).clearDriverCache();
        WebDriverManager.getInstance(DriverManagerType.CHROME).setup(); //закачка та інсталяція хром браузера для подальшого використання в тестах

        driver = new ChromeDriver(chromeOptions);



        //System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); //якщо сторінка не завантажиться за 10 сек.тест впаде
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); // очікування елемента на сторінці
        BaseSeleniumPage.setDriver(driver); //для того щоб кожного разу не створювати обєкт драйвера для кожної сторінки, прописали його на кожну сторінку
        //+ наслідування від бейс пейдж
    }

    @AfterAll
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}
