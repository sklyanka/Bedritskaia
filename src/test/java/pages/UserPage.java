package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UserPage extends AbstractPage {
    public UserPage(WebDriver driver) {
        super(driver);
    }

    public RezultSearchPage searchByTypeAndRegion(String searchValue, String typeValue, String regionValue) {
        getRightBaseLink().click();
        getSearchField().sendKeys(searchValue);
        getSearchExtendedButton().click();
        fillSearchExtendedField(typeValue, regionValue);
        getSearchExrendedButton().click();
        return new RezultSearchPage(driver);
    }

    private void fillSearchExtendedField (String typeValue, String regionValue) {
        selectFromUlByValue(getUlForType(), typeValue);
        selectFromUlByValue(getUlForRegion(), regionValue);
    }

    private WebElement getRightBaseLink() {
       return findByXPath("//li[@id='main_menu_law']/a");
    }

    private WebElement getSearchForm() {
        return findByXPath("//form[@id='search-form']");
    }

    private WebElement getSearchField() {
        return getSearchForm().findElement(By.id("search-text"));
    }

    private WebElement getSearchExtendedButton() {
        return getSearchForm().findElement(By.id("search-button-extended"));
    }

    private WebElement getSearchExtendedForm() {
        return findByXPath("//form[@id='search-form-extended']");
    }

    private WebElement getUlForType() {
        return  getSearchExtendedForm().findElement(By.xpath("//ul[@id='typelist']"));
    }

    private WebElement getUlForRegion() {
        return  getSearchExtendedForm().findElement(By.xpath("//ul[@id='regionlist']"));
    }

    private WebElement getSearchExrendedButton() {
        return getSearchExtendedForm().findElement(By.id("button-search-extended"));
    }
}

