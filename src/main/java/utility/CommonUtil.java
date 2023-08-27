package utility;

import io.restassured.RestAssured;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static utility.ResourcePathUtil.currentDirectory;

public class CommonUtil {
    private static FileInputStream file;
    protected static Properties prop;
    public CommonUtil(String whichPropertyFile) {
        try {
            prop = new Properties();
            file = new FileInputStream(currentDirectory + "\\src\\main\\java\\configurationpackage\\" + whichPropertyFile);
            prop.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static CommonUtil getPathThroughProperties(String propertyFile) {
        return new CommonUtil(propertyFile);
    }

    public static String getBaseURI() {
        return RestAssured.baseURI = "https://reqres.in/";
    }
}
