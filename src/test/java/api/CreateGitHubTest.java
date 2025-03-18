package api;

import com.zebrunner.carina.core.IAbstractTest;
import org.example.api.PostRepositoryMethod;
import org.testng.annotations.Test;


public class CreateGitHubTest implements IAbstractTest {

    @Test(description = "Create repository", priority = 1)
    public void testCreateRepository() {
        PostRepositoryMethod api = new PostRepositoryMethod();
        api.callAPIExpectSuccess();
        api.validateResponse();
    }
}