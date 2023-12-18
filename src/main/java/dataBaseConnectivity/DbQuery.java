package dataBaseConnectivity;

import java.util.Arrays;
import java.util.List;
import java.sql.Connection;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class DbQuery extends DbAccess {
    private Connection connection;
    private ResultSet resultSet;
    private int rows;
    /**
     * Method implementation to connect with Database.
     * @param key for jdbc url
     * @return
     */
    @Override
    protected Connection getConnection(String key) {
        return connection = DbAccess.connect(key);
    }

    /**
     * Method implementation to prepare the SQL query.
     * @param sqlQuery to be passed
     * @param arguments parameters for the query to be passed
     * @return object of PreparedStatement
     */
    @Override
    protected PreparedStatement prepareQuery(String sqlQuery, Object... arguments) {
        List<Object> args = Arrays.asList(arguments);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            ParameterMetaData parameterMetaData = preparedStatement.getParameterMetaData();
            int parameterCount = parameterMetaData.getParameterCount();
            for (int i=0;i<parameterCount;i++){
                int sqlType = parameterMetaData.getParameterType(i+1);
                preparedStatement.setObject(i,args.get(i),sqlType);
            }
           return preparedStatement;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    protected ResultSet readDatabase (String sql,Object...args) {
        try {
            if (!connection.isClosed()) {
                resultSet = prepareQuery(sql, args).executeQuery();
                log.info("Data has been retrieved from database.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e +"\n"+"Failed to retrieve data from database.");
        }
        return resultSet;
    }

    protected int updateDatabase (String sql,Object...args){
        try {
            if (!connection.isClosed()) {
                rows = prepareQuery(sql, args).executeUpdate();
                log.info(rows + " rows are updated in the database");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e +"\n"+"Failed to perform operation on database.");
        }
        return rows;
    }

}
