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
        getSearchExtendedButton().click();
        fillSearchField(searchValue, typeValue, regionValue);
        getSearchExrendedButton().click();
        return new RezultSearchPage(driver);
    }

    private void fillSearchField (String searchValue, String typeValue, String regionValue) {
        getSearchField().sendKeys(searchValue);

        getUlForType().click();
        selectFromUlByValue(getUlForType(), typeValue);

        getUlForRegion().click(); //при клике на элемент UL сразу устанавливается значение Моск обл,
        getUlForRegion().click(); // поэтому здесь имитация двойного щелчка - возврат ко значению РФ
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

