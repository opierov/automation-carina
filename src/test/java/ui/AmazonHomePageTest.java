package ui;

import com.zebrunner.carina.core.IAbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.example.ui.pages.AmazonHomePage;

public class AmazonHomePageTest implements IAbstractTest {

    @Test
    public void testAmazonLogoIsDisplayed() {
        //Open Amazon home page
        AmazonHomePage homePage = new AmazonHomePage(getDriver());
        homePage.open();

        System.out.println("If a CAPTCHA appears, please pass it manually in the browser, then press ENTER...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Verify page is opened
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
        //Verify element is displayed
        Assert.assertTrue(homePage.isAmazonLogoDisplayed(), "Amazon logo is not displayed");
    }
}