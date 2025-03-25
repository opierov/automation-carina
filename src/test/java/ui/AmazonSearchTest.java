package ui;

import com.zebrunner.carina.core.IAbstractTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.example.ui.pages.AmazonHomePage;
import org.example.ui.pages.SearchResultsPage;

public class AmazonSearchTest implements IAbstractTest {

    @Test
    public void testSearchProduct() {
        WebDriver driver = getDriver();
        AmazonHomePage homePage = new AmazonHomePage(driver);
        homePage.open();

        System.out.println("Please resolve the CAPTCHA manually in the browser, then press ENTER to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertTrue(homePage.isPageOpened(), "Amazon home page is not opened");

        SearchResultsPage resultsPage = homePage.searchForProduct("Laptop");

        Assert.assertTrue(resultsPage.hasResults(), "Search results are not displayed");
    }
}