package testpackageAPI;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.gson.JsonArray;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import testData.GetRequestTestData;
import utility.CommonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class TestGetRequest {
    String path;
    HashMap<String,Integer> queryParameters = new HashMap<>();
    Response response;
    ObjectMapper objectMapper;
    public TestGetRequest() {
    }

    @BeforeClass
    public void requestSetup() {
        CommonUtil.getPathThroughProperties("apiConfig.properties");
        queryParameters.put("page",2);
        path=CommonUtil.getPath("userPath");
        CommonUtil.getBaseURI();
        objectMapper = new ObjectMapper();
    }

    @Test(priority = 1)
    public void testGetRequest() {
        RequestSpecification request = RestAssured.given().relaxedHTTPSValidation();
        response = request.queryParams(queryParameters).get(path);
        int statuscode = response.getStatusCode();
        Assert.assertEquals(statuscode, 200);
    }

    @Test(dependsOnMethods = {"testGetRequest"},priority = 2)
    public void testDataFieldFromResponse(){
        try {
            JsonNode jsonNode = objectMapper.readTree(response.getBody().asPrettyString());
            JsonNode dataNode = jsonNode.get("data");
            Assert.assertEquals(dataNode.get(0).get("email").asText(),"michael.lawson@reqres.in");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    @Test(dependsOnMethods = {"testGetRequest"},priority = 3)
    public void testPerPageFieldResponse(){
        try {
            GetRequestTestData getRequestTestData = objectMapper.readValue(response.getBody().asPrettyString(), GetRequestTestData.class);
            int perPageField = getRequestTestData.getPer_page();
            Assert.assertEquals(perPageField,6);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
