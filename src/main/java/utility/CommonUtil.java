package utility;

import io.restassured.RestAssured;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static utility.ResourcePathUtil.currentDirectory;

public class CommonUtil {
    public static FileInputStream file;
    public static Properties prop;
    public static void getPathThroughProperties(String whichPropertyFile) {
        try {
            prop = new Properties();
            file = new FileInputStream(currentDirectory + "\\src\\main\\java\\configurationpackage\\" + whichPropertyFile);
            prop.load(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getPath(String path){
       return prop.getProperty(path);
    }
    public static String getBaseURI() {
        return RestAssured.baseURI = "https://reqres.in/";
    }
}
