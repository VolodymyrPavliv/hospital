package ua.mushroom.hospital.db;

import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Connection pool
 *
 * @author Volodymyr Pavliv
 */
public class ConnectionPool {
    private static final BasicDataSource ds = new BasicDataSource();
    private static final ResourceBundle rb = ResourceBundle.getBundle("db");

    static {
        ds.setUrl(rb.getString("url"));
        ds.setUsername(rb.getString("user"));
        ds.setPassword(rb.getString("password"));
        ds.setDriverClassName(rb.getString("driver"));
        ds.setMinIdle(5);
        ds.setMaxIdle(10);
        ds.setMaxOpenPreparedStatements(100);
    }

    private ConnectionPool(){}

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
