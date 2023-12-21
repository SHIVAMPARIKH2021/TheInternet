package utility;

import com.google.gson.Gson;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.Scanner;

public class CommonUtil {
    public static FileInputStream file;
    public static Properties prop;
    Gson gson;
    public static String currentDirectory = System.getProperty("user.dir");
    public CommonUtil(){
        gson = new Gson();
    }
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

    /**
     * Utility method to read json file.
     * @param propertyKey a key of a json property
     * @param fileName a json file name
     * @return value of a json property
     */
    public static String readJson(String propertyKey,String fileName) {
        String file = readResources(fileName);
        DocumentContext jsonPath = JsonPath.parse(file);
        Object jsonObject = jsonPath.read(propertyKey);
        CommonUtil commonUtil = new CommonUtil();
        return  commonUtil.gson.toJson(jsonObject);
    }

    /**
     * Method to get a system loader to read directory.
     * @param path file name or path of the file
     * @return InputStream
     */
    public static InputStream getResources(String path){
        ClassLoader classLoader = CommonUtil.class.getClassLoader();
        return classLoader.getResourceAsStream(path);
    }

    /**
     * Method to read the file from the directory.
     * @param path file name
     * @return string token
     */
    public static String readResources (String path){
        InputStream in = getResources(path);
        Scanner scanner = new Scanner(in, StandardCharsets.UTF_8);
        scanner.useDelimiter("\\A");
        return scanner.next();
    }
}
