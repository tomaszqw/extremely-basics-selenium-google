package pl.tomaszqw.driver_setup;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.IOException;

public class SetupDriver {

    private static WebDriver webDriver = null;
    TestDataProperties testDataProperties = new TestDataProperties();


    private SetupDriver(BrowserName browserName) throws IOException {
        switch (browserName) {
            case edge:
                System.setProperty("webdriver.edge.driver", testDataProperties.getLocalEdgePath());
                webDriver = new EdgeDriver(getEdgeOptions());
                break;
            case chrome:
                System.setProperty("webdriver.chrome.driver", testDataProperties.getLocalChromeDriverPath());
                webDriver = new ChromeDriver(getChromeOptions());
                break;
            case firefox:
                System.setProperty("webdriver.gecko.driver", testDataProperties.getLocalFirefoxDriverPath());
                webDriver = new FirefoxDriver(getFirefoxOptions());
                break;
            default:
                break;
        }
    }

    private WebDriver getWebDriver() {
        return webDriver;
    }

    public static WebDriver getDriver(BrowserName browserName) throws IOException {
        webDriver = new SetupDriver(browserName).getWebDriver();
        webDriver.manage().window().maximize();
        return webDriver;
    }

    protected ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        return chromeOptions;
    }

    protected FirefoxOptions getFirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        return firefoxOptions;
    }

    protected EdgeOptions getEdgeOptions() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        return edgeOptions;
    }

}
