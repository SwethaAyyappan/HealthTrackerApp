import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Patient {
    private String name;
    private int age;
    private String gender;

    private List<String> medicalComplications; 
    private List<String> medicalHistory;       
    private List<LocalDateTime> appointments;  
    private List<String> medications;          

    public Patient(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;

        this.medicalComplications = new ArrayList<>();
        this.medicalHistory = new ArrayList<>();
        this.appointments = new ArrayList<>();
        this.medications = new ArrayList<>();
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }

    // -------------------------
    // Medical Complications
    // -------------------------
    public void addMedicalComplication(String complication) {
        medicalComplications.add(complication);
        // (Optional: persist to DB in future)
    }

    public List<String> getMedicalComplications() {
        return medicalComplications;
    }

    // -------------------------
    // Medical History (DB-backed)
    // -------------------------
    public void addMedicalHistory(String history) {
        medicalHistory.add(history);

        try (Connection con = SQLManager.getConnection();
             PreparedStatement stmt = con.prepareStatement("INSERT INTO medical_history(history) VALUES(?)")) {
            stmt.setString(1, history);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("❌ Failed to insert medical history: " + e.getMessage());
        }
    }

    public List<String> getMedicalHistory() {
        medicalHistory.clear();

        try (Connection con = SQLManager.getConnection();
             PreparedStatement stmt = con.prepareStatement("SELECT history FROM medical_history");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                medicalHistory.add(rs.getString("history"));
            }
        } catch (SQLException e) {
            System.err.println("❌ Failed to fetch medical history: " + e.getMessage());
        }

        return medicalHistory;
    }

    // -------------------------
    // Appointments (DB-backed)
    // -------------------------
    public void addAppointment(Serializable appointment) {
        if (!(appointment instanceof LocalDateTime)) {
            System.err.println("❌ Invalid appointment type. Expected LocalDateTime.");
            return;
        }

        LocalDateTime dateTime = (LocalDateTime) appointment;
        appointments.add(dateTime);

        try (Connection con = SQLManager.getConnection();
             PreparedStatement stmt = con.prepareStatement("INSERT INTO appointments(date) VALUES(?)")) {
            stmt.setString(1, dateTime.toString());
            stmt.executeUpdate();
            System.out.println("✅ Appointment inserted: " + dateTime);
        } catch (SQLException e) {
            System.err.println("❌ Failed to insert appointment: " + e.getMessage());
        }
    }

    public List<LocalDateTime> getAppointments() {
        appointments.clear();

        try (Connection con = SQLManager.getConnection();
             PreparedStatement stmt = con.prepareStatement("SELECT date FROM appointments");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                appointments.add(LocalDateTime.parse(rs.getString("date")));
            }
        } catch (SQLException e) {
            System.err.println("❌ Failed to fetch appointments: " + e.getMessage());
        }

        return appointments;
    }

    // -------------------------
    // Medications (in-memory + optional DB)
    // -------------------------
    public void addMedication(String medication) {
        medications.add(medication);

        try (Connection con = SQLManager.getConnection();
             PreparedStatement stmt = con.prepareStatement("INSERT INTO medications(name) VALUES(?)")) {
            stmt.setString(1, medication);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("❌ Failed to insert medication: " + e.getMessage());
        }
    }

    public List<String> getMedications() {
        medications.clear();

        try (Connection con = SQLManager.getConnection();
             PreparedStatement stmt = con.prepareStatement("SELECT name FROM medications");
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                medications.add(rs.getString("name"));
            }
        } catch (SQLException e) {
            System.err.println("❌ Failed to fetch medications: " + e.getMessage());
        }

        return medications;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nAge: " + age + "\nGender: " + gender;
    }
}
