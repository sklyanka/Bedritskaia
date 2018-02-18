package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage open() {
        open("http://www.1gl.ru/");
        return this;
    }

    public LoginPage openLofinForm() {
        findById("user-enter")
                .click();
        return new LoginPage(driver);
    }
}
