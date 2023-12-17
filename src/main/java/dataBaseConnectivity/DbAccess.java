package dataBaseConnectivity;

import org.jboss.logging.Logger;
import utility.ResourcePathUtil;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

abstract class DbAccess {
    private static Connection connection;
    private static Properties properties = new Properties();
    private static Logger log = Logger.getLogger(DbAccess.class);

    /**
     * Method to establish connection with database.
     * @param url key for a database
     * @return jdbc connection
     */
    private static Connection connect(String url){
        String jdbcUrl = getUrl(url);
        try{
            connection = DriverManager.getConnection(jdbcUrl);
        } catch (Exception e){
            log.error("Database connectivity has been failed");
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * Method to get the url.
     * @param urlKey
     * @return jdbc url
     */
    private static String getUrl(String urlKey){
        String path = "\\src\\main\\java\\configurationpackage\\";
        try {
            properties.load(new FileInputStream(ResourcePathUtil.currentDirectory+path+"application.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        String jdbcUrl =properties.getProperty(urlKey) +
                ";databaseName="+properties.getProperty("databaseName") +
                ";integratedSecurity="+properties.getProperty("integratedSecurity") +
                ";encrypt="+properties.getProperty("encrypt") +
                ";trustServerCertificate="+properties.getProperty("trustServerCertificate") +
                ";username="+properties.getProperty("username") +
                ";password="+properties.getProperty("password");
        return jdbcUrl;
    }
}

