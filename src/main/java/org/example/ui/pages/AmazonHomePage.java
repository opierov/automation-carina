package org.example.ui.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

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

/*    @Override
    public void open() {
        super.open();
    }*/

    public boolean isPageOpened() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        return searchBox.isDisplayed();
    }

    public SearchResultsPage searchForProduct(String product) {
        searchBox.type(product);
        searchButton.click();
        return new SearchResultsPage(getDriver());
    }

    public boolean isAmazonLogoDisplayed() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(amazonLogo));
        return amazonLogo.isDisplayed();
    }

    public AmazonSignInPage goToSignInPage() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(signInButton));
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