import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.List;

public class HealthTrackingApp {
    private JLabel nameLabel;
    private JLabel ageLabel;
    private JLabel genderLabel;
    private JButton loginButton;
    private JButton profileButton;
    private JButton medicalComplicationsButton;
    private JButton viewMedicalHistoryButton;
    private JButton addAppointmentButton;
    private JButton viewAppointmentsButton;
    private JButton addMedicationButton;
    private JButton viewMedicationButton;

    private Patient currentPatient;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HealthTrackingApp app = new HealthTrackingApp();
            app.createAndShowGUI();
        });
    }

    private void createAndShowGUI() {
        // Set look and feel to system default
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        // Create the main frame
        JFrame frame = new JFrame("Health Tracking Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.decode("#FDFDFD"));
        frame.setLayout(new GridLayout(4, 1));

        // Create the labels
        nameLabel = new JLabel("Name: ");
        ageLabel = new JLabel("Age: ");
        genderLabel = new JLabel("Gender: ");
        nameLabel.setForeground(Color.decode("#0A2463"));
        ageLabel.setForeground(Color.decode("#0A2463"));
        genderLabel.setForeground(Color.decode("#0A2463"));

        // Create the buttons
        loginButton = createButton("Login", this::login);
        profileButton = createButton("View Profile", this::viewProfile);
        medicalComplicationsButton = createButton("Add Medical Complication", this::addMedicalComplication);
        viewMedicalHistoryButton = createButton("View Medical History", this::viewMedicalHistory);
        addAppointmentButton = createButton("Add Appointment", this::addAppointment);
        viewAppointmentsButton = createButton("View Appointments", this::viewAppointments);
        addMedicationButton = createButton("Add Medication", this::addMedication);
        viewMedicationButton = createButton("View Medication", this::viewMedication);

        // Apply styling to buttons
        Font buttonFont = new Font("Arial", Font.BOLD, 14);
        Color buttonBackground = Color.decode("#B7E9C6");
        Color buttonForeground = Color.decode("#08605F");

        loginButton.setFont(buttonFont);
        loginButton.setBackground(buttonBackground);
        loginButton.setForeground(buttonForeground);

        profileButton.setFont(buttonFont);
        profileButton.setBackground(buttonBackground);
        profileButton.setForeground(buttonForeground);

        medicalComplicationsButton.setFont(buttonFont);
        medicalComplicationsButton.setBackground(buttonBackground);
        medicalComplicationsButton.setForeground(buttonForeground);

        viewMedicalHistoryButton.setFont(buttonFont);
        viewMedicalHistoryButton.setBackground(buttonBackground);
        viewMedicalHistoryButton.setForeground(buttonForeground);

        addAppointmentButton.setFont(buttonFont);
        addAppointmentButton.setBackground(buttonBackground);
        addAppointmentButton.setForeground(buttonForeground);

        viewAppointmentsButton.setFont(buttonFont);
        viewAppointmentsButton.setBackground(buttonBackground);
        viewAppointmentsButton.setForeground(buttonForeground);

        addMedicationButton.setFont(buttonFont);
        addMedicationButton.setBackground(buttonBackground);
        addMedicationButton.setForeground(buttonForeground);

        viewMedicationButton.setFont(buttonFont);
        viewMedicationButton.setBackground(buttonBackground);
        viewMedicationButton.setForeground(buttonForeground);

        // Add components to the frame
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        namePanel.setBackground(Color.decode("#FDFDFD"));
        namePanel.add(nameLabel);

        JPanel agePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        agePanel.setBackground(Color.decode("#FDFDFD"));
        agePanel.add(ageLabel);

        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        genderPanel.setBackground(Color.decode("#FDFDFD"));
        genderPanel.add(genderLabel);

        JPanel loginPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        loginPanel.setBackground(Color.decode("#FDFDFD"));
        loginPanel.add(loginButton);

        JPanel profilePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        profilePanel.setBackground(Color.decode("#FDFDFD"));
        profilePanel.add(profileButton);

        JPanel complicationsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        complicationsPanel.setBackground(Color.decode("#FDFDFD"));
        complicationsPanel.add(medicalComplicationsButton);

        JPanel historyPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        historyPanel.setBackground(Color.decode("#FDFDFD"));
        historyPanel.add(viewMedicalHistoryButton);

        JPanel appointmentsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        appointmentsPanel.setBackground(Color.decode("#FDFDFD"));
        appointmentsPanel.add(addAppointmentButton);
        appointmentsPanel.add(viewAppointmentsButton);

        JPanel medicationPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        medicationPanel.setBackground(Color.decode("#FDFDFD"));
        medicationPanel.add(addMedicationButton);
        medicationPanel.add(viewMedicationButton);

        frame.add(namePanel);
        frame.add(agePanel);
        frame.add(genderPanel);
        frame.add(loginPanel);
        frame.add(profilePanel);
        frame.add(complicationsPanel);
        frame.add(historyPanel);
        frame.add(appointmentsPanel);
        frame.add(medicationPanel);

        // Set the initial visibility of buttons
        loginButton.setVisible(true);
        profileButton.setVisible(false);
        medicalComplicationsButton.setVisible(false);
        viewMedicalHistoryButton.setVisible(false);
        addAppointmentButton.setVisible(false);
        viewAppointmentsButton.setVisible(false);
        addMedicationButton.setVisible(false);
        viewMedicationButton.setVisible(false);

        // Display the frame
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JButton createButton(String text, ActionListener listener) {
        JButton button = new JButton(text);
        button.addActionListener(listener);
        return button;
    }

    private void login(ActionEvent e) {
        String name = JOptionPane.showInputDialog(null, "Enter your name:");
        int age = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter your age:"));
        String gender = JOptionPane.showInputDialog(null, "Enter your gender:");

        currentPatient = new Patient(name, age, gender);

        nameLabel.setText("Name: " + currentPatient.getName());
        ageLabel.setText("Age: " + currentPatient.getAge());
        genderLabel.setText("Gender: " + currentPatient.getGender());

        loginButton.setVisible(false);
        profileButton.setVisible(true);
        medicalComplicationsButton.setVisible(true);
        viewMedicalHistoryButton.setVisible(true);
        addAppointmentButton.setVisible(true);
        viewAppointmentsButton.setVisible(true);
        addMedicationButton.setVisible(true);
        viewMedicationButton.setVisible(true);
    }

    private void viewProfile(ActionEvent e) {
        JOptionPane.showMessageDialog(null, currentPatient.toString(), "Profile", JOptionPane.PLAIN_MESSAGE);
    }

    private void addMedicalComplication(ActionEvent e) {
        String complication = JOptionPane.showInputDialog(null, "Enter the medical complication:");
        currentPatient.addMedicalComplication(complication);
        JOptionPane.showMessageDialog(null, "Medical complication added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private void viewMedicalHistory(ActionEvent e) {
        List<String> medicalHistory = currentPatient.getMedicalHistory();
        if (medicalHistory.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No medical history available.", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, medicalHistory, "Medical History", JOptionPane.PLAIN_MESSAGE);
        }
    }

    private void addAppointment(ActionEvent e) {
        String appointment = JOptionPane.showInputDialog(null, "Enter the appointment details:");
        currentPatient.addAppointment(appointment);
        JOptionPane.showMessageDialog(null, "Appointment added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private void viewAppointments(ActionEvent e) {
        List<LocalDateTime> appointments = currentPatient.getAppointments();
        if (appointments.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No appointments available.", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, appointments, "Appointments", JOptionPane.PLAIN_MESSAGE);
        }
    }

    private void addMedication(ActionEvent e) {
        String medication = JOptionPane.showInputDialog(null, "Enter the medication details:");
        currentPatient.addMedication(medication);
        JOptionPane.showMessageDialog(null, "Medication added successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private void viewMedication(ActionEvent e) {
        List<String> medication = currentPatient.getMedicalHistory();
        if (medication.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No medication available.", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, medication, "Medication", JOptionPane.PLAIN_MESSAGE);
        }
    }

    
            
        
    
}

