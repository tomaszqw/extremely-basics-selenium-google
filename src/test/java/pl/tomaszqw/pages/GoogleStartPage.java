package pl.tomaszqw.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pl.tomaszqw.utils.Waits;

public class GoogleStartPage extends Page {

    private static final String PAGE_URL = "http://google.com";

    @FindBy(className = "V5OCtd")
    WebElement languageChanger;
    @FindBy(xpath = "//div[contains(@id, 'tbTubd')]//li[contains(@aria-label, \"Deutsch\")]")
    WebElement deutschSelect;
    @FindBy(xpath = "//div[contains(@id, 'tbTubd')]//li[contains(@aria-label, \"polski\")]")
    WebElement polishSelect;
    @FindBy(xpath = "//div[contains(@class, 'HOq4He')]//div[contains(text(), \"Zaakceptuj wszystko\")]/parent::button")
    WebElement acceptCookiesButton;
    @FindBy(xpath = "//div[contains(@class, 'HOq4He')]//div[contains(text(), \"Odrzuć wszystko\")]/parent::button")
    WebElement rejectAllCookiesButton;

    @FindBy(xpath = "//input[contains(@aria-label, 'Szukaj')]")
    WebElement searchField;
    @FindBy(xpath = "//input[contains(@aria-label, 'Szukaj w Google')]")
    WebElement searchButton;

    By bySearchResult = By.id("res");

    public GoogleStartPage(WebDriver webDriver) {
        super(webDriver);
        webDriver.get(PAGE_URL);
    }

    public GoogleStartPage changeLanguageToDeutsch() {
        languageChanger.click();
        deutschSelect.click();
        return (this);
    }

    public GoogleStartPage changeLanguageToPolish() {
        languageChanger.click();
        polishSelect.click();
        return (this);
    }

    public GoogleStartPage acceptCookies() {
        acceptCookiesButton.click();
        return (this);
    }

    public GoogleStartPage rejectCookies() {
        rejectAllCookiesButton.click();
        return (this);
    }

    public GoogleStartPage searchPhrase(String phrase) {
        searchField.sendKeys(phrase);
        searchButton.submit();
        Waits.waitForWebElement(webDriver, bySearchResult);
        return (this);
    }
}
