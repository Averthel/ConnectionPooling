package pl.ave.jdbc.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


import java.sql.Connection;
import java.sql.SQLException;

public class DbUtil {
    private static DbUtil dbUtil;
    private HikariDataSource dataSource;

    private DbUtil() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/urbexblog?useSSL=false&serverTimezone=UTC");
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setUsername("root");
        config.setPassword("admin");
        dataSource = new HikariDataSource(config);
    }

    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public void close() {
        dataSource.close();
    }

    public static DbUtil getInstance() {
        if (dbUtil == null) {
            dbUtil = new DbUtil();
        }
        return dbUtil;
    }
}

