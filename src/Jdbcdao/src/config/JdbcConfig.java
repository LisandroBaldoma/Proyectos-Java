package Jdbcdao.src.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JdbcConfig {

        private static final String JDBC_URL = "jdbc:h2:file:C:/Users/Lisandro/test";


    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                    JDBC_URL,
                    "sa",
                    ""
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
