package api;

import com.zebrunner.carina.core.IAbstractTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.api.GetRepositoryExistsMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class CheckGitHubExistsTest implements IAbstractTest {
    private static final Logger logger = LogManager.getLogger(CheckGitHubExistsTest.class);

    @BeforeMethod
    public void before() {
        logger.info("Check if repository exists");
    }

    @DataProvider(name = "repositoryData")
    public Object[][] repositoryData() {
        return new Object[][]{
                {"opierov", "API-test-repo"},
                {"opierov", "Test-API-repo"},
        };
    }

    @Test(description = "Getting repository by name", priority = 2, dataProvider = "repositoryData")
    public void testGetRepositoryExists(String repoOwner, String repoName) {
        GetRepositoryExistsMethod api = new GetRepositoryExistsMethod(repoOwner, repoName);
        api.callAPIExpectSuccess();
        api.validateResponse();
    }

    @AfterMethod
    public void after() {
        logger.info("Repository does not exist");
    }
}