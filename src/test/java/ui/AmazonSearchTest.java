package ui;

import com.zebrunner.carina.core.IAbstractTest;
import org.example.ui.components.HeaderComponent;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.example.ui.pages.AmazonHomePage;
import org.example.ui.pages.SearchResultsPage;

public class AmazonSearchTest implements IAbstractTest {

    @Test
    public void testSearchProduct() {
        //Open Amazon home page
        AmazonHomePage homePage = new AmazonHomePage(getDriver());
        homePage.open();

        System.out.println("Please pass the CAPTCHA manually in the browser, then press ENTER to continue...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Verify page is opened
        Assert.assertTrue(homePage.isPageOpened(), "Amazon home page is not opened");
        //Search "Laptop"
        HeaderComponent header = homePage.getHeader();
        header.searchForProduct("Laptop");
        //Verify search
        SearchResultsPage resultsPage = new SearchResultsPage(getDriver());
        Assert.assertTrue(resultsPage.ifFound(), "Search results are not displayed");
    }
}