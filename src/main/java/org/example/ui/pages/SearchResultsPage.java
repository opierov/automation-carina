package org.example.ui.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends AbstractPage {

    @FindBy(css = "div.s-main-slot")
    @FindBy(xpath = "//div[@class='s-main-slot s-result-list s-search-results sg-row']")
    @FindBy(xpath = "//div[contains(@class, 's-main-slot')]")
    private ExtendedWebElement resultsCatalog;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public boolean ifFound() {
        return resultsCatalog.isDisplayed();
    }
}