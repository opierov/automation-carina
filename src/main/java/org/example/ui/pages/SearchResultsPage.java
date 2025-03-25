package org.example.ui.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends AbstractPage {

    @FindBy(css = "div.s-main-slot")
    private ExtendedWebElement resultsContainer;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public boolean hasResults() {
        return resultsContainer.isDisplayed();
    }
}