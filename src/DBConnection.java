import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static String dbURL = "jdbc:mysql://localhost:3306/library";
    private static String dbUser = "sample";
    private static String dbPass = "sample";
    private static Connection conn = null;

    /**
     * Opens a connection to the Database
     * @return The connection (conn) if successful or null + error message if the connection failed
     */
    public static Connection getConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
        return conn;
    }
}
