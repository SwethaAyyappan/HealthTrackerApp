import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class MedicalTrackerApp {
    private JFrame frame;
    private JLabel nameLabel;
    private JLabel ageLabel;
    private JLabel genderLabel;
    private Patient currentPatient;

    public MedicalTrackerApp() {
        initialize();
    }

    void initialize() {
        frame = new JFrame("Medical Tracker App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        nameLabel = new JLabel();
        ageLabel = new JLabel();
        genderLabel = new JLabel();

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.decode("#CFDCF9"));

        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.insets = new Insets(10, 10, 10, 10);

        c.gridy = 0; panel.add(nameLabel, c);
        c.gridy = 1; panel.add(ageLabel, c);
        c.gridy = 2; panel.add(genderLabel, c);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 3, 5, 5));
        buttonPanel.setBackground(Color.decode("#CFDC9F"));

        buttonPanel.add(createButton("Login", this::login));
        buttonPanel.add(createButton("View Profile", this::viewProfile));
        buttonPanel.add(createButton("Add Medical Complication", this::addMedicalComplication));
        buttonPanel.add(createButton("View Medical History", this::viewMedicalHistory));
        buttonPanel.add(createButton("Add Appointment", this::addAppointment));
        buttonPanel.add(createButton("View Appointments", this::viewAppointments));
        buttonPanel.add(createButton("Add Medication", this::addMedication));
        buttonPanel.add(createButton("View Medications", this::viewMedication));
        buttonPanel.add(createButton("Schedule Appointment", this::scheduleAppointment));
        buttonPanel.add(createButton("Schedule Medication", this::scheduleMedication));
        buttonPanel.add(createButton("Add Medical Tests", this::addMedicalTest));
        buttonPanel.add(createButton("Track Your Health", this::TrackYourHealth));

        frame.add(panel);
        frame.add(buttonPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JButton createButton(String text, ActionListener listener) {
        JButton button = new JButton(text);
        button.setBackground(Color.blue);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setPreferredSize(new Dimension(300, 200));
        button.addActionListener(listener);
        return button;
    }

    private void login(ActionEvent e) {
        String name = JOptionPane.showInputDialog("Enter your name:");
        if (name == null || name.trim().isEmpty()) return;

        String ageStr = JOptionPane.showInputDialog("Enter your age:");
        if (ageStr == null || ageStr.trim().isEmpty()) return;

        int age;
        try {
            age = Integer.parseInt(ageStr.trim());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Invalid age. Please enter a number.");
            return;
        }

        String gender = JOptionPane.showInputDialog("Enter your gender:");
        if (gender == null || gender.trim().isEmpty()) return;

        currentPatient = new Patient(name, age, gender);

        nameLabel.setText("Name: " + currentPatient.getName());
        ageLabel.setText("Age: " + currentPatient.getAge());
        genderLabel.setText("Gender: " + currentPatient.getGender());

        JOptionPane.showMessageDialog(null, "Login successful.");
    }

    private void viewProfile(ActionEvent e) {
        if (currentPatient == null) {
            JOptionPane.showMessageDialog(null, "Please login first.");
            return;
        }
        JOptionPane.showMessageDialog(null, currentPatient.toString());
    }

    private void addMedicalComplication(ActionEvent e) {
        if (currentPatient == null) return;
        String complication = JOptionPane.showInputDialog("Enter the medical complication:");
        if (complication != null && !complication.trim().isEmpty()) {
            currentPatient.addMedicalComplication(complication.trim());
            JOptionPane.showMessageDialog(null, "Medical complication added successfully.");
        }
    }

    private void viewMedicalHistory(ActionEvent e) {
        if (currentPatient == null) return;
        List<String> medicalHistory = currentPatient.getMedicalHistory();
        if (medicalHistory.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No medical history found.");
        } else {
            StringBuilder msg = new StringBuilder("Medical History:\n");
            medicalHistory.forEach(h -> msg.append("- ").append(h).append("\n"));
            JOptionPane.showMessageDialog(null, msg.toString());
        }
    }

    private void addAppointment(ActionEvent e) {
        if (currentPatient == null) return;
        String dateTimeStr = JOptionPane.showInputDialog("Enter appointment (yyyy-MM-dd HH:mm):");
        if (dateTimeStr == null || dateTimeStr.trim().isEmpty()) return;

        try {
            LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            currentPatient.addAppointment(dateTime);
            JOptionPane.showMessageDialog(null, "Appointment added successfully.");
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(null, "Invalid format. Use yyyy-MM-dd HH:mm.");
        }
    }

    private void viewAppointments(ActionEvent e) {
        if (currentPatient == null) return;
        List<LocalDateTime> appointments = currentPatient.getAppointments();
        if (appointments.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No appointments found.");
        } else {
            StringBuilder msg = new StringBuilder("Appointments:\n");
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            appointments.forEach(a -> msg.append("- ").append(a.format(fmt)).append("\n"));
            JOptionPane.showMessageDialog(null, msg.toString());
        }
    }

    private void addMedication(ActionEvent e) {
        if (currentPatient == null) return;
        String med = JOptionPane.showInputDialog("Enter the medication:");
        if (med != null && !med.trim().isEmpty()) {
            currentPatient.addMedication(med.trim());
            JOptionPane.showMessageDialog(null, "Medication added successfully.");
        }
    }

    private void viewMedication(ActionEvent e) {
        if (currentPatient == null) return;
        List<String> meds = currentPatient.getMedications();
        if (meds.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No medications found.");
        } else {
            StringBuilder msg = new StringBuilder("Medications:\n");
            meds.forEach(m -> msg.append("- ").append(m).append("\n"));
            JOptionPane.showMessageDialog(null, msg.toString());
        }
    }

    private void scheduleAppointment(ActionEvent e) {
        if (currentPatient == null) return;
        String dateTimeStr = JOptionPane.showInputDialog("Enter appointment (yyyy-MM-dd HH:mm):");
        if (dateTimeStr == null || dateTimeStr.trim().isEmpty()) return;

        String reminderMsg = JOptionPane.showInputDialog("Enter reminder message:");
        if (reminderMsg == null || reminderMsg.trim().isEmpty()) return;

        try {
            LocalDateTime dateTime = LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            LocalDateTime reminderTime = dateTime.minusDays(1);

            scheduleReminder(reminderTime, reminderMsg);
            currentPatient.addAppointment(dateTime);
            JOptionPane.showMessageDialog(null, "Appointment scheduled successfully.");
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(null, "Invalid format. Use yyyy-MM-dd HH:mm.");
        }
    }

    private void scheduleMedication(ActionEvent e) {
        if (currentPatient == null) return;
        String medName = JOptionPane.showInputDialog("Enter medication name:");
        if (medName == null || medName.trim().isEmpty()) return;

        String dateTimeStr = JOptionPane.showInputDialog("Enter reminder date/time (yyyy-MM-dd HH:mm):");
        if (dateTimeStr == null || dateTimeStr.trim().isEmpty()) return;

        String reminderMsg = JOptionPane.showInputDialog("Enter reminder message:");
        if (reminderMsg == null || reminderMsg.trim().isEmpty()) return;

        try {
            LocalDateTime reminderTime = LocalDateTime.parse(dateTimeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            scheduleReminder(reminderTime, reminderMsg);
            currentPatient.addMedication(medName);
            JOptionPane.showMessageDialog(null, "Medication scheduled successfully.");
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(null, "Invalid format. Use yyyy-MM-dd HH:mm.");
        }
    }

    private void addMedicalTest(ActionEvent e) {
        SwingUtilities.invokeLater(() -> new MedicalDataStorageApp().setVisible(true));
    }

    private void TrackYourHealth(ActionEvent e) {
        SwingUtilities.invokeLater(HealthTrackerUI::new);
    }

    private void scheduleReminder(LocalDateTime reminderDateTime, String message) {
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            public void run() {
                JOptionPane.showMessageDialog(null, "Reminder: " + message);
            }
        }, java.sql.Timestamp.valueOf(reminderDateTime));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MedicalTrackerApp::new);
    }
}
