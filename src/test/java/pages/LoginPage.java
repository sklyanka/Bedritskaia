package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends AbstractPage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public UserPage assertLoginAndPass (String login, String pass) {
        getLoginTab().click();
        getLoginField().sendKeys(login);
        getPassField().sendKeys(pass);
        getEnterButton().click();
        return new UserPage(driver);
    }

    private WebElement getLoginTab () {
        return  findByXPath("//span[@id='wf-enter']");
    }

    private WebElement getLoginField () {
        return findByXPath("//fieldset[@id='fields-auth']//input[@id='email']");
    }

    private WebElement getPassField () {
        return findByXPath("//fieldset[@id='fields-auth']//input[@id='password']");
    }

    private WebElement getEnterButton () {
        return findByXPath("//fieldset[@id='fields-auth']//input[@id='customer-enter']");
    }
}
