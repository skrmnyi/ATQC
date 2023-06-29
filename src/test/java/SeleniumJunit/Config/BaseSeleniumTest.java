package SeleniumJunit.Config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract public class BaseSeleniumTest {
    protected WebDriver driver;

    @BeforeEach
    public void setUp () {
        WebDriverManager.chromedriver().setup(); //закачка та інсталяція хром браузера для подальшого використання в тестах
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); //якщо сторінка не завантажиться за 10 сек.тест впаде
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS); // очікування елемента на сторінці
        BaseSeleniumPage.setDriver(driver); //для того щоб кожного разу не створювати обєкт драйвера в тесті, прописали його на кожну сторінку
    }

    @AfterAll
    public void tearDown() {
        driver.close();
        driver.quit();
    }

}
