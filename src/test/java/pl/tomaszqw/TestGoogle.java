package pl.tomaszqw;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.tomaszqw.driver_setup.SetupDriver;
import pl.tomaszqw.pages.GoogleStartPage;
import pl.tomaszqw.utils.Utils;

import java.io.IOException;
import java.lang.reflect.Method;

public class TestGoogle {

    WebDriver webDriver;
    GoogleStartPage googleStartPage;

    @BeforeClass
    public static void clearData() {
        Utils.clearData();
    }

    @BeforeMethod
    public void init() throws IOException {
        this.webDriver = SetupDriver.getDriver();
        this.googleStartPage = new GoogleStartPage(webDriver);
    }

    @Test(testName = "Search ing google phrase: Quality Assurance")
    public void searchPhraseInGoogle() {
        String expectedTitle = "Quality Assurance - Szukaj w Google";
        String title = googleStartPage
                .changeLanguageToDeutsch()
                .changeLanguageToPolish()
                .acceptCookies()
                .searchPhrase("Quality Assurance").getPageTitle();

        Assert.assertEquals(title, expectedTitle);

    }

    @Test(testName = "Search ing google phrase: Quality Control")
    public void declineCookiesInGoogle() {
        String expectedTitle = "Quality Control - Szukaj w Google";
        String title = googleStartPage
                .changeLanguageToDeutsch()
                .changeLanguageToPolish()
                .rejectCookies()
                .searchPhrase("Quality Control").getPageTitle();

        Assert.assertEquals(title, expectedTitle);
    }

    @AfterMethod
    public void teardown(Method method) throws IOException {
        Utils.takeScreenshot(webDriver, method.getName());
        webDriver.quit();
    }
}
