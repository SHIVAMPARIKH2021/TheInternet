package testpackageAPI;

import basepackage.BaseTest;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utility.CommonUtil;

import java.util.HashMap;
import java.util.Properties;

public class TestGetRequest {
   public static String path;
    HashMap<String,Integer> queryParameters = new HashMap<>();
    public TestGetRequest() {
    }

    @BeforeClass
    public void requestSetup() {
        CommonUtil.getPathThroughProperties("apiConfig.properties");
        queryParameters.put("page",2);
        path=CommonUtil.getPath("userPath");
        CommonUtil.getBaseURI();
    }

    @Test
    public void testGetRequest() {
        RequestSpecification request = RestAssured.given().relaxedHTTPSValidation();
        Response response = request.queryParams(queryParameters).get(path);
        int statuscode = response.getStatusCode();
        Assert.assertEquals(statuscode, 200);
    }
}
