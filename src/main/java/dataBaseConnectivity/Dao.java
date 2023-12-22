package dataBaseConnectivity;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;

public class Dao extends DbQuery {
    private static final String MS_SQL_FILE = "msSql.xml";
    private static Dao dao = new Dao();
    public Dao(){
        super();
    }

    /**
     * Method to get data from database.
     * @param beanId of a sql query
     * @param args of a sql query
     * @return ResultSet
     */
    public static ResultSet getSql(String beanId, Object...args) {
        return dao.readDatabase(MS_SQL_FILE,beanId,args);
    }

    /**
     * Method to update database.
     * @param beanId of a sql query
     * @param args of a sql query
     * @return number of updated rows
     */
    public static int sql(String beanId, Object...args) {
        return dao.updateDatabase(MS_SQL_FILE,beanId,args);
    }
}
