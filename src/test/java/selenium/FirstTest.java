package selenium;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.LoginPage;
import pages.MainPage;
import pages.RezultSearchPage;
import pages.UserPage;

import java.util.concurrent.TimeUnit;

public class FirstTest  extends BaseTest{
    //private static WebDriver driver;

    private LoginPage loginPage;
    private UserPage userPage;
    private RezultSearchPage rezultSearchPage;

    @Test
    public void initLK() {
        String searchValue = "налог";
        String typeValue = "Постановление";
        String regionValue = "Москва";
        loginPage = new MainPage(driver)
                .open()
                .openLofinForm();
        //loginPage = new MainPage(driver).open().openLofinForm();
        userPage = loginPage
                .assertLoginAndPass("autoUser@mailinator.com", "autoPass");
        rezultSearchPage = userPage.searchByTypeAndRegion(searchValue, typeValue, regionValue);

        // наличие указанных на скриншоте блоков
        Assert.assertTrue(rezultSearchPage.getSearchResultsSelection().isDisplayed());
        Assert.assertTrue(rezultSearchPage.getSearchH1().isDisplayed());
        Assert.assertTrue(rezultSearchPage.getSearchParamElement().isDisplayed());
        Assert.assertTrue(rezultSearchPage.getSidebar().isDisplayed());

        //соответствие текста заголовка
        Assert.assertEquals(getValueInQuotes(searchValue), rezultSearchPage.getSearchMainParam().getText());

        //соответствие выбранных значений вида и региона
        System.out.println(rezultSearchPage.getSearchParams().get(0).getText());
        System.out.println(rezultSearchPage.getSearchParams().get(1).getText());
        Assert.assertEquals(getValueInQuotes(typeValue), rezultSearchPage.getSearchParams().get(0).getText());
        Assert.assertEquals(getValueInQuotes(regionValue), rezultSearchPage.getSearchParams().get(1).getText());
    }


}
