package org.example.ui.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginComponent extends AbstractUIObject {

    @FindBy(id = "ap_email")
    @FindBy(xpath = "//input[@id='ap_email']")
    @FindBy(xpath = ".//input[contains(@id, 'ap_email')]")
    private ExtendedWebElement emailInput;

    @FindBy(id = "continue")
    @FindBy(xpath = "//input[@id='continue']")
    @FindBy(xpath = ".//input[contains(@id, 'continue')]")
    private ExtendedWebElement continueButton;

    @FindBy(id = "ap_password")
    @FindBy(xpath = "//input[@id='ap_password']")
    @FindBy(xpath = ".//input[contains(@id, 'ap_password')]")
    private ExtendedWebElement passInput;

    @FindBy(id = "signInSubmit")
    @FindBy(xpath = "//input[@id='signInSubmit']")
    @FindBy(xpath = ".//input[contains(@id, 'signInSubmit')]")
    private ExtendedWebElement signInButton;

    public LoginComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void enterEmail(String email) {
        emailInput.type(email);
    }

    public void clickContinue() {
        continueButton.click();
    }

    public void enterPassword(String password) {
        passInput.type(password);
    }

    public void clickSignIn() {
        signInButton.click();
    }
}