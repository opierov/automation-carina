package org.example.ui.pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AmazonSignInPage extends AbstractPage {

    @FindBy(id = "ap_email")
    private ExtendedWebElement emailInput;

    @FindBy(id = "continue")
    private ExtendedWebElement continueButton;

    @FindBy(id = "ap_password")
    private ExtendedWebElement passInput;

    @FindBy(id = "signInSubmit")
    private ExtendedWebElement signInButton;

    public AmazonSignInPage(WebDriver driver) {
        super(driver);
    }

    public void enterEmail(String email) {
        emailInput.type(email);
    }

    public void clickContinue() {
        continueButton.click();
    }

    public void clickSignIn() {
        signInButton.click();
    }

    public void enterPass(String pass) {
        passInput.type(pass);
    }

    public boolean isPageOpened() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(emailInput));
        return emailInput.isDisplayed();
    }
}