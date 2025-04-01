package org.example.ui.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.example.ui.components.LoginComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AmazonSignInPage extends AbstractPage {

    @FindBy(id = "authportal-main-section") // Ensure this matches the correct parent container
    private LoginComponent loginComponent;

    public AmazonSignInPage(WebDriver driver) {
        super(driver);
    }

    public LoginComponent getLoginComponent() {
        return loginComponent;
    }

    public boolean isPageOpened() {
        return loginComponent.isElementPresent();
    }
}