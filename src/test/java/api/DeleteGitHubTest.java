package api;

import com.zebrunner.carina.core.IAbstractTest;
import org.example.api.DeleteRepositoryMethod;
import org.testng.annotations.Test;


public class DeleteGitHubTest implements IAbstractTest {

    @Test(description = "Delete repository", priority = 3)
    public void testDeleteRepository() {
        DeleteRepositoryMethod api = new DeleteRepositoryMethod("opierov","API-test-repo");
        api.callAPIExpectSuccess();
    }
}