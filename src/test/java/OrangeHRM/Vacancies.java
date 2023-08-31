package OrangeHRM;

import Config.BaseSeleniumPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Vacancies extends BaseSeleniumPage {


    List<WebElement> allTableValues = driver.findElements(By.xpath("//div[@class=\"oxd-table-card\"]/div/div/div"));

    public void printElements() {
        for (WebElement element : allTableValues) {
            System.out.println(element.getText());
            System.out.println(element.getAttribute("value"));
        }
    }



}
