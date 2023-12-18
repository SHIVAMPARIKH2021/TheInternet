package dataBaseConnectivity;

import org.apache.log4j.Logger;
import utility.ResourcePathUtil;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

abstract class DbAccess {
    private static Connection connection;
    private static final Properties properties;
    protected static final Logger log;

    static {
        properties = new Properties();
        log = Logger.getLogger(DbAccess.class);
    }

    /**
     * Method to establish connection with database.
     * @param url key for a database
     * @return jdbc connection
     */
    protected static Connection connect(String url){
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
     * @param urlKey based on which jdbc url will be fetched
     * @return jdbc url
     */
    private static String getUrl(String urlKey){
        String path = "\\src\\main\\java\\configurationpackage\\";
        try {
            properties.load(new FileReader(
    ResourcePathUtil.currentDirectory
            + path
            + "application.properties"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        String jdbcUrl =properties.getProperty(urlKey)
                + ";databaseName=" + properties.getProperty("databaseName")
                + ";integratedSecurity=" + properties.getProperty("integratedSecurity")
                + ";encrypt=" + properties.getProperty("encrypt")
                + ";trustServerCertificate=" + properties.getProperty("trustServerCertificate")
                + ";username=" + properties.getProperty("username")
                + ";password=" + properties.getProperty("password");
        return jdbcUrl;
    }

    /**
     * Method definition to connect with Database.
     * @param key which key
     * @return Connection for database connectivity
     */
    protected abstract Connection getConnection(String key);

    /**
     * Method definition to prepare the SQL query.
     * @param sqlQuery which query
     * @param arguments parameters of SQL query
     * @return PreparedStatement for query execution
     */
    protected abstract PreparedStatement prepareQuery(String sqlQuery,Object...arguments);
}

