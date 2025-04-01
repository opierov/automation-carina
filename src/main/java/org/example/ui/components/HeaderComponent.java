package org.example.ui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HeaderComponent extends AbstractUIObject {

    @FindBy(id = "twotabsearchtextbox")
    private ExtendedWebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    private ExtendedWebElement searchButton;

    @FindBy(id = "nav-link-accountList-nav-line-1")
    private ExtendedWebElement accountGreeting;

    public HeaderComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void searchForProduct(String product) {
        searchBox.type(product);
        searchButton.click();
    }

    public boolean isAccountGreetingDisplayed() {
        return accountGreeting.isElementPresent();
    }

    public String getAccountGreetingText() {
        return accountGreeting.getText().trim();
    }
}