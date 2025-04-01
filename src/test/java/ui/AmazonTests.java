package ui;

import com.zebrunner.carina.core.IAbstractTest;
import org.example.ui.components.HeaderComponent;
import org.example.ui.components.LoginComponent;
import org.example.ui.pages.AmazonHomePage;
import org.example.ui.pages.AmazonSignInPage;
import org.example.ui.pages.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonTests implements IAbstractTest {

    private AmazonHomePage homePage;

    @BeforeMethod
    public void setUp() {
        homePage = new AmazonHomePage(getDriver());
        homePage.open();

        Assert.assertTrue(homePage.isPageOpened(), "Amazon home page is not opened");
    }

    @Test
    public void testAmazonLogoIsDisplayed() {
        Assert.assertTrue(homePage.isAmazonLogoDisplayed(), "Amazon logo is not displayed");
    }

    @Test
    public void testSearchProduct() {
        HeaderComponent header = homePage.getHeaderComponent();
        header.searchForProduct("Laptop");

        SearchResultsPage resultsPage = new SearchResultsPage(getDriver());
        Assert.assertTrue(resultsPage.ifFound(), "Search results are not displayed");
    }

    @Test
    public void testNavigateToSignInPage() {
        AmazonSignInPage signInPage = homePage.goToSignInPage();
        LoginComponent login = signInPage.getLoginComponent();

        login.enterEmail("username");
        login.clickContinue();
        login.enterPassword("pass");
        login.clickSignIn();

        HeaderComponent header = homePage.getHeaderComponent();
        Assert.assertTrue(header.isAccountGreetingDisplayed(), "Greeting is not displayed!");
        Assert.assertEquals(header.getAccountGreetingText(), "Hello, Oleksandr", "Greeting text does not match!");
    }
}