package dataBaseConnectivity;

import org.apache.log4j.Logger;
import utility.CommonUtil;
import utility.ResourcePathUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
abstract class DbAccess {
    private static Connection connection;
    protected static final Logger log;
    private static String configFile = "dbConfig.json";

    static {
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
        CommonUtil.getPathThroughProperties("application.properties");
        StringBuilder stringBuilder = new StringBuilder();
        ArrayList<String> dbConstantsList = new ArrayList<>();
        dbConstantsList.add(DbConstants.DATABASE_NAME);
        dbConstantsList.add(DbConstants.USERNAME);
        dbConstantsList.add(DbConstants.PASSWORD);
        dbConstantsList.add(DbConstants.TRUST_SERVER_CERTIFICATE);
        dbConstantsList.add(DbConstants.INTERGRATED_SECURITY);
        dbConstantsList.add(DbConstants.ENCRYPT);
        dbConstantsList.forEach(constant -> {
                    stringBuilder.append(constant.concat("=")
                            .concat(ResourcePathUtil.readJson(constant,configFile)
                                    .concat(";")));
                }
        );
        String jdbcUrl = CommonUtil.getPath(urlKey)
                .concat(stringBuilder.toString());
        return jdbcUrl.replace("\"", "");
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

