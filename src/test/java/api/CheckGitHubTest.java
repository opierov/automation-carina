package api;

import com.zebrunner.carina.core.IAbstractTest;
import org.example.api.GetRepositoryMethod;
import org.testng.annotations.Test;


public class CheckGitHubTest implements IAbstractTest {

    @Test(description = "Getting repository by name", priority = 2)
    public void testGetRepository() {
        GetRepositoryMethod api = new GetRepositoryMethod("opierov","API-test-repo");
        api.callAPIExpectSuccess();
        api.validateResponse();
    }
}