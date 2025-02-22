package TrabajoIntegrador.config;

import TrabajoIntegrador.exception.InvalidDbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConfig {

    private static final String URL = "jdbc:h2:file:C:/Users/Lisandro/test;AUTO_SERVER=TRUE";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    static {
        try {
            Class.forName("org.h2.Driver");
        } catch (ClassNotFoundException e) {
            throw new InvalidDbConnection("Error al cargar el driver de la base de datos", e);
        }
    }

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            throw new InvalidDbConnection("Error al conectar a la base de datos", e);
        }
    }

}
