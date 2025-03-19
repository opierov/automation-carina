package api;

import com.zebrunner.carina.core.IAbstractTest;
import org.example.api.DeleteRepositoryMethod;
import org.example.api.GetRepositoryExistsMethod;
import org.example.api.PostRepositoryMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class DeleteGitHubTest implements IAbstractTest {

    @BeforeMethod
    public void before() {
        PostRepositoryMethod api1 = new PostRepositoryMethod();
        api1.setProperties("api/repos/_post/repository.properties");
        api1.callAPIExpectSuccess();
    }

    @AfterMethod
    public void after() {
        GetRepositoryExistsMethod api3 = new GetRepositoryExistsMethod("opierov","API-test-repo");
        api3.callAPIExpectSuccess();
    }

    @Test(description = "Delete repository")
    public void testDeleteRepository() {
        DeleteRepositoryMethod api2 = new DeleteRepositoryMethod("opierov","API-test-repo");
        api2.callAPIExpectSuccess();
    }
}