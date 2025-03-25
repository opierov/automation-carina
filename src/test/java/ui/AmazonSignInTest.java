package ui;

import com.zebrunner.carina.core.IAbstractTest;
import org.openqa.selenium.WebDriver;
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

        System.out.println("Please resolve CAPTCHA manually in the browser, then press ENTER to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Click and open sign in page
        AmazonSignInPage signInPage = homePage.goToSignInPage();
        //Verify sign in page
        Assert.assertTrue(signInPage.isPageOpened(), "Sign in page is not opened");
        //Enter email and click
        signInPage.enterEmail("mail@gmail.com");
        signInPage.clickContinue();
        //Enter pass and click
        signInPage.enterPass("pass");
        signInPage.clickSignIn();
        //Verify logged home page
        Assert.assertTrue(homePage.isHelloDisplayed(), "Greeting is not displayed!");
        Assert.assertEquals(homePage.getHelloText(), "Hello, Oleksandr", "Greeting text does not match!");

    }
}