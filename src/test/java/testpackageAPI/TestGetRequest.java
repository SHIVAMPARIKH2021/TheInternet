package testpackageAPI;

import basepackage.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestGetRequest extends BaseTest{
    String path;

    public TestGetRequest() {
    }

    @BeforeClass
    public void requestSetup() {
        BaseTest.getPathThroughProperties();
        this.path = prop.getProperty("userPath");
        BaseTest.getBaseURI();
    }

    @Test
    public void testGetRequest() {
        RequestSpecification request = RestAssured.given().relaxedHTTPSValidation();
        Response response = (Response)request.request(Method.GET, this.path, new Object[0]);
        int statuscode = response.getStatusCode();
        System.out.println(statuscode);
        Assert.assertEquals(200, 200);
    }
}
