package pl.tomaszqw;


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import pl.tomaszqw.driver_setup.SetupDriver;
import pl.tomaszqw.driver_setup.TestDataProperties;
import pl.tomaszqw.pages.GoogleStartPage;
import pl.tomaszqw.utils.Utils;

import java.io.IOException;

public class TestGoogle {
    @Rule
    public TestName testName = new TestName();
    WebDriver webDriver;
    GoogleStartPage googleStartPage;

    @BeforeClass
    public static void clearData() throws IOException {
        Utils.clearData();
    }

    @Before
    public void init() throws IOException {
        this.webDriver = SetupDriver.getDriver(new TestDataProperties().getBrowserType());
        this.googleStartPage = new GoogleStartPage(webDriver);
    }

    @Test
    public void searchPhraseInGoogle() {
        String expectedTitle = "Quality Assurance - Szukaj w Google";
        String title = googleStartPage
                .changeLanguageToDeutsch()
                .changeLanguageToPolish()
                .acceptCookies()
                .searchPhrase("Quality Assurance").getPageTitle();

        Assert.assertEquals(title, expectedTitle);

    }

    @Test
    public void declineCookiesInGoogle() {
        String expectedTitle = "Quality Control - Szukaj w Google";
        String title = googleStartPage
                .changeLanguageToDeutsch()
                .changeLanguageToPolish()
                .rejectCookies()
                .searchPhrase("Quality Control").getPageTitle();

        Assert.assertEquals(title, expectedTitle);
    }

    @After
    public void teardown() throws IOException {
        Utils.takeScreenshot(webDriver, testName.getMethodName());
        webDriver.quit();
    }
}
