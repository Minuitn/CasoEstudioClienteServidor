
package CasoEstudioFlotilla;

//@autor Angel

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    private static final String URL = 
        "jdbc:mysql://localhost:3306/flotilla_xyz"
        + "?useSSL=false"
        + "&allowPublicKeyRetrieval=true"
        + "&serverTimezone=UTC";

    private static final String USER = "root"; 
    private static final String PASS = "";  

    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            throw new SQLException("Error conectando a la base de datos: " + e.getMessage());
        }
    }
}

