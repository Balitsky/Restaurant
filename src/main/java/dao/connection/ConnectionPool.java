package dao.connection;

import dao.DaoException;
import org.apache.commons.dbcp2.BasicDataSource;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionPool {
    private static ConnectionPool instance = new ConnectionPool();
    private BasicDataSource connectionPool;

    private ConnectionPool() {
        init();
    }

    private void init() {
        try(InputStream is = ConnectionPool.class.getClassLoader().getResourceAsStream("dbConfig/config.properties")) {
            Properties properties = new Properties();
            properties.load(is);
            connectionPool = new BasicDataSource();
            connectionPool.setDriverClassName(properties.getProperty("database.driver"));
            connectionPool.setUrl(properties.getProperty("database.url"));
            connectionPool.setUsername(properties.getProperty("database.userName"));
            connectionPool.setPassword(properties.getProperty("database.userPassword"));
            connectionPool.setMaxTotal(Integer.parseInt(properties.getProperty("database.maxConnections")));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static ConnectionPool getInstance() {
        return instance;
    }

    public DaoConnection getConnection() {
        try {
            return new DaoConnection(connectionPool.getConnection());
        } catch (SQLException e) {
            throw new DaoException("fail get dao.connection", e);
        }
    }

}
