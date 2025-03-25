package ui;

import com.zebrunner.carina.core.IAbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.example.ui.pages.AmazonHomePage;

public class AmazonHomePageTest implements IAbstractTest {

    @Test
    public void testAmazonLogoIsDisplayed() {
        WebDriver driver = getDriver();
        AmazonHomePage homePage = new AmazonHomePage(driver);
        homePage.open();

        System.out.println("If a CAPTCHA appears, please solve it manually in the browser, then press ENTER...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertTrue(homePage.isAmazonLogoDisplayed(), "Amazon logo is not displayed");
    }
}