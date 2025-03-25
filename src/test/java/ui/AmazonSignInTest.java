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
        WebDriver driver = getDriver();
        AmazonHomePage homePage = new AmazonHomePage(driver);
        homePage.open();

        System.out.println("Please resolve CAPTCHA manually in the browser, then press ENTER to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }

        AmazonSignInPage signInPage = homePage.goToSignInPage();

        Assert.assertTrue(signInPage.isPageOpened(), "Sign in page is not opened");
        signInPage.enterEmail("test@gmail.com");
        signInPage.clickContinue();
        signInPage.enterPass("your_password");
        signInPage.clickSignIn();

        Assert.assertTrue(homePage.isHelloDisplayed(), "Greeting is not displayed!");
        Assert.assertEquals(homePage.getHelloText(), "Hello, Oleksandr", "Greeting text does not match!");

    }
}