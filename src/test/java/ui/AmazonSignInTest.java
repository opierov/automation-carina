package ui;

import com.zebrunner.carina.core.IAbstractTest;
import org.example.ui.components.HeaderComponent;
import org.example.ui.components.LoginComponent;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.example.ui.pages.AmazonHomePage;
import org.example.ui.pages.AmazonSignInPage;

public class AmazonSignInTest implements IAbstractTest {

    @Test
    public void testNavigateToSignInPage() {
        //Open Amazon home page
        AmazonHomePage homePage = new AmazonHomePage(getDriver());
        homePage.open();

        System.out.println("Please pass CAPTCHA manually in the browser, then press ENTER to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Click and open sign in page
        AmazonSignInPage signInPage = homePage.goToSignInPage();
        LoginComponent login = signInPage.getLoginComponent();
        //Verify sign in page
        login.enterEmail("your_user");
        login.clickContinue();
        login.enterPassword("your_pass");
        login.clickSignIn();
        //Verify home page after authorization
        HeaderComponent header = homePage.getHeader();
        Assert.assertTrue(header.isAccountGreetingDisplayed(), "Greeting is not displayed!");
        Assert.assertEquals(header.getAccountGreetingText(), "Hello, Oleksandr", "Greeting text does not match!");

    }
}