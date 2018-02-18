package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class RezultSearchPage extends AbstractPage {
    public RezultSearchPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getSearchResultsSelection() {
        return findByXPath("//section[@id='searchResultsSection']");
    }

    private WebElement getMainLeft() {
        return findByXPath("//main[@id='main-left']");
    }

    public WebElement getSearchParamElement() {
        return  getMainLeft().findElement(By.className("search-extended-string"));
    }

    public WebElement getSearchH1() {
        return getMainLeft().findElement(By.tagName("h1"));
    }

    public WebElement getSearchMainParam() {
        return getSearchH1().findElement(By.tagName("strong"));
    }

    public List<WebElement> getSearchParams() {
        return  getSearchParamElement().findElements(By.tagName("span"));
    }

    public WebElement getSidebar() {
        return findByXPath("//section[@id='sidebar']");
    }

}
