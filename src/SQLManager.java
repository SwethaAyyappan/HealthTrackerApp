import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLManager {

    private static final String DB_URL = "jdbc:sqlite:medicaltracker.db";

    // Establish and return a connection
    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(DB_URL);
            System.out.println("✅ Connection to SQLite has been established.");
            return conn;
        } catch (SQLException e) {
            System.err.println("❌ Failed to connect to database: " + e.getMessage());
            return null;
        }
    }

    // Initialize tables if they don't exist
    public static void initializeDatabase() {
        String createMedicalHistory = "CREATE TABLE IF NOT EXISTS medical_history (history TEXT)";
        String createAppointments   = "CREATE TABLE IF NOT EXISTS appointments (date TEXT)";
        String createMedications    = "CREATE TABLE IF NOT EXISTS medications (name TEXT)";

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {
            stmt.execute(createMedicalHistory);
            stmt.execute(createAppointments);
            stmt.execute(createMedications);
            System.out.println("✅ Database tables checked/created successfully.");
        } catch (SQLException e) {
            System.err.println("❌ Error initializing database: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Run this once to check/create your DB
        initializeDatabase();
    }
}
