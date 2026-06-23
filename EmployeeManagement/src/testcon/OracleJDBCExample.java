package testcon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleJDBCExample {
    public static void main(String[] args) {
        // JDBC URL format for Oracle:
        // jdbc:oracle:thin:@host:port:serviceName
        String jdbcURL = "jdbc:oracle:thin:@localhost:1521:xe"; 
        String username = "system";   // replace with your DB username
        String password = "Oracle123";   // replace with your DB password

        Connection connection = null;

        try {
            // Load Oracle JDBC Driver
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // Establish connection
            connection = DriverManager.getConnection(jdbcURL, username, password);

            System.out.println("✅ Connected to Oracle Database successfully!");

        } catch (ClassNotFoundException e) {
            System.out.println("❌ Oracle JDBC Driver not found. Add ojdbc.jar to your project.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("❌ Connection failed. Check URL/username/password.");
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                    System.out.println("🔒 Connection closed.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
