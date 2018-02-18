package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AbstractPage {

    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    protected void open(String relativePath) {
        driver.get(relativePath);
    }

    protected WebElement findByXPath(String xpathLocator) {
        return driver.findElement(By.xpath(xpathLocator));
    }

    protected WebElement findById(String id) {
        return driver.findElement(By.id(id));
    }

    protected void selectFromUlByValue(WebElement webElementUL, String value) {
        List<WebElement> liList=webElementUL.findElements(By.tagName("li"));
        for (WebElement li : liList) {
            if (li.getText().equals(value)) {
                li.click();
                break;
            }
        }
    }

}
