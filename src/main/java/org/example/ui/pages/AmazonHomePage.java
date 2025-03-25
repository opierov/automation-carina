package org.example.ui.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AmazonHomePage extends AbstractPage {

    @FindBy(id = "twotabsearchtextbox")
    private ExtendedWebElement searchBox;

    @FindBy(id = "nav-search-submit-button")
    private ExtendedWebElement searchButton;

    @FindBy(id = "nav-logo-sprites")
    private ExtendedWebElement amazonLogo;

    @FindBy(id = "nav-link-accountList")
    private ExtendedWebElement signInButton;

    @FindBy(id = "nav-link-accountList-nav-line-1")
    private ExtendedWebElement yourAccount;

    public AmazonHomePage(WebDriver driver) {
        super(driver);
    }

    public SearchResultsPage searchForProduct(String product) {
        searchBox.type(product);
        searchButton.click();
        return new SearchResultsPage(getDriver());
    }

    public boolean isAmazonLogoDisplayed() {
        return amazonLogo.isDisplayed();
    }

    public AmazonSignInPage goToSignInPage() {
        signInButton.click();
        return new AmazonSignInPage(getDriver());
    }

    public boolean isHelloDisplayed() {
        return yourAccount.isElementPresent();
    }

    public String getHelloText() {
        return yourAccount.getText().trim();
    }
}