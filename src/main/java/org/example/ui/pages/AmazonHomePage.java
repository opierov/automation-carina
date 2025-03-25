package org.example.ui.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.example.ui.components.HeaderComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AmazonHomePage extends AbstractPage {

    private HeaderComponent header;

    @FindBy(id = "nav-logo-sprites")
    private ExtendedWebElement amazonLogo;

    @FindBy(id = "nav-link-accountList")
    private ExtendedWebElement signInButton;

    public AmazonHomePage(WebDriver driver) {
        super(driver);
        this.header = new HeaderComponent(driver);
    }

    public HeaderComponent getHeader() {
        return header;
    }

    public boolean isAmazonLogoDisplayed() {
        return amazonLogo.isDisplayed();
    }

    public AmazonSignInPage goToSignInPage() {
        signInButton.click();
        return new AmazonSignInPage(getDriver());
    }
}