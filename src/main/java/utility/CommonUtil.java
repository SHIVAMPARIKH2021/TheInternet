package utility;

import com.google.gson.Gson;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import io.restassured.RestAssured;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
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
            file = new FileInputStream(currentDirectory
                    + "\\src\\main\\java\\configurationpackage\\" + whichPropertyFile);
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

    /**
     * Method to read the xml file.
     * Get the document builder.
     * Get the document.
     * @param fileName xml file name
     * @return document object
     */
    public static Document readXml(String fileName){
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        Document document = null;
        try {
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.parse(getResources(fileName));
            if (document != null) {
                document.getDocumentElement().normalize();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return document;
    }

    /**
     * Method to get node list by tag name of xml file.
     * @param file file name
     * @param tag xml file tag
     * @return NodeList
     */
    public static NodeList getNodelistByTagName(String file, String tag){
        return readXml(file).getElementsByTagName(tag);
    }

    /**
     * Method to check query is read only or not.
     * @param file file name
     * @return true if query is read only
     */
    public static boolean isReadOnlyQuery(String file,String beanId) {
        String isResultSet = "";
        NamedNodeMap nodeMap;
        NodeList list = getNodelistByTagName(file,"bean");
        int tagLength = list.getLength();
        for (int item = 0; item < tagLength; item++){
            nodeMap = list.item(item).getAttributes();
            boolean flag = list.item(item).getAttributes()
                    .item(0).getNodeValue().equals(beanId);
            if(flag) {
                isResultSet = nodeMap.item(1).getNodeValue();
                break;
            }
        }
        return Boolean.parseBoolean(isResultSet);
    }

    /**
     * Parse the xml structure.
     * Get the elements of xml file by tag name.
     * @param fileName file name of xml file
     */
    public static String getXmlValue(String fileName, String beanId){
        NodeList nodeList = getNodelistByTagName(fileName,"bean");
        Node node = null;
        String query = "";
        int nodeListLength = nodeList.getLength();
        for (int item = 0;item < nodeListLength;item++) {
            NamedNodeMap nodeMap = nodeList.item(item).getAttributes();
            String nodeValue = nodeMap.item(0).getNodeValue();
            if (nodeValue.equals(beanId)) {
                query = getNodelistByTagName(fileName,"query")
                        .item(item).getAttributes()
                        .item(0).getNodeValue();
            }
        }
        return query.trim();
    }
}
