import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class MedicalApp {
    private JFrame frame;
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
    private JButton addMedicalTestButton;
    private JButton TrackYourHealthButton;


        
    private Patient currentPatient;

    public MedicalApp() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame("Medical App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        nameLabel = new JLabel();
        ageLabel = new JLabel();
        genderLabel = new JLabel();

        loginButton = createButton("Login", this::login);
        profileButton = createButton("View Profile", this::viewProfile);
        medicalComplicationsButton = createButton("Add Medical Complication", this::addMedicalComplication);
        viewMedicalHistoryButton = createButton("View Medical History", this::viewMedicalHistory);
        addAppointmentButton = createButton("Add Appointment", this::addAppointment);
        viewAppointmentsButton = createButton("View Appointments", this::viewAppointments);
        addMedicationButton = createButton("Add Medication", this::addMedication);
        viewMedicationButton = createButton("View Medications", this::viewMedication);
        addMedicalTestButton = createButton("Add Medical Tests", this::addMedicalTest);
        TrackYourHealthButton = createButton("Track Your Health", this::TrackYourHealth);

        // Add components to the frame
        JPanel panel = new JPanel();
        panel.setBackground(Color.decode("#FDFDFD"));
        panel.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 1.0;
        constraints.insets = new Insets(10, 10, 10, 10);

        panel.add(nameLabel, constraints);
        constraints.gridy = 1;
        panel.add(ageLabel, constraints);
        constraints.gridy = 2;
        panel.add(genderLabel, constraints);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.decode("#FDFDFD"));
        buttonPanel.setLayout(new GridLayout(2, 4, 10, 10));
        buttonPanel.add(loginButton);
        buttonPanel.add(profileButton);
        buttonPanel.add(medicalComplicationsButton);
        buttonPanel.add(viewMedicalHistoryButton);
        buttonPanel.add(addAppointmentButton);
        buttonPanel.add(viewAppointmentsButton);
        buttonPanel.add(addMedicationButton);
        buttonPanel.add(viewMedicationButton);
        buttonPanel.add(addMedicalTestButton);
        buttonPanel.add(TrackYourHealthButton);

        frame.add(panel);
        frame.add(buttonPanel);

        // Set initial visibility of components
        nameLabel.setVisible(true);
        ageLabel.setVisible(true);
        genderLabel.setVisible(true);
        buttonPanel.setVisible(true);

        // Display the frame
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JButton createButton(String text, ActionListener listener) {
        JButton button = new JButton(text);
        button.addActionListener(listener);
        return button;
    }

    private void login(ActionEvent e) {
        String name = JOptionPane.showInputDialog("Enter your name:");
        int age = Integer.parseInt(JOptionPane.showInputDialog("Enter your age:"));
        String gender = JOptionPane.showInputDialog("Enter your gender:");

        currentPatient = new Patient(name, age, gender);

        nameLabel.setText("Name: " + currentPatient.getName());
        ageLabel.setText("Age: " + currentPatient.getAge());
        genderLabel.setText("Gender: " + currentPatient.getGender());

        nameLabel.setVisible(true);
        ageLabel.setVisible(true);
        genderLabel.setVisible(true);
        Window buttonPanel = null;
		buttonPanel.setVisible(true);

        JOptionPane.showMessageDialog(null, "Login successful.");
    }

    private void viewProfile(ActionEvent e) {
        JOptionPane.showMessageDialog(null, currentPatient.toString());
    }

    private void addMedicalComplication(ActionEvent e) {
        String complication = JOptionPane.showInputDialog("Enter the medical complication:");
        currentPatient.addMedicalComplication(complication);
        JOptionPane.showMessageDialog(null, "Medical complication added successfully.");
    }

    private void viewMedicalHistory(ActionEvent e) {
        List<String> medicalHistory = currentPatient.getMedicalHistory();
        if (medicalHistory.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No medical history found.");
        } else {
            StringBuilder message = new StringBuilder("Medical History:\n");
            for (String history : medicalHistory) {
                message.append("- ").append(history).append("\n");
            }
            JOptionPane.showMessageDialog(null, message.toString());
        }
    }

    private void addAppointment(ActionEvent e) {
        String appointmentDateTime = JOptionPane.showInputDialog("Enter the appointment date and time (yyyy-MM-dd HH:mm):");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        try {
            LocalDateTime dateTime = LocalDateTime.parse(appointmentDateTime, formatter);
            currentPatient.addAppointment(dateTime);
            JOptionPane.showMessageDialog(null, "Appointment added successfully.");
        } catch (DateTimeParseException ex) {
            JOptionPane.showMessageDialog(null, "Invalid date/time format. Please enter in yyyy-MM-dd HH:mm format.");
        }
    }

    private void viewAppointments(ActionEvent e) {
        List<LocalDateTime> appointments = currentPatient.getAppointments();
        if (appointments.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No appointments found.");
        } else {
            StringBuilder message = new StringBuilder("Appointments:\n");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            for (LocalDateTime appointment : appointments) {
                message.append("- ").append(appointment.format(formatter)).append("\n");
            }
            JOptionPane.showMessageDialog(null, message.toString());
        }
    }

    private void addMedication(ActionEvent e) {
        String medication = JOptionPane.showInputDialog("Enter the medication:");
        currentPatient.addMedication(medication);
        JOptionPane.showMessageDialog(null, "Medication added successfully.");
    }

    private void addMedicalTest(ActionEvent e) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MedicalDataStorageApp().setVisible(true);
            }
            
        });
    }
    
    
    private void TrackYourHealth(ActionEvent e) {
    	SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new HealthTrackerUI();
            }
    	});
    }

    private void viewMedication(ActionEvent e) {
        List<String> medications = currentPatient.getMedications();
        if (medications.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No medications found.");
        } else {
            StringBuilder message = new StringBuilder("Medications:\n");
            for (String medication : medications) {
                message.append("- ").append(medication).append("\n");
            }
            JOptionPane.showMessageDialog(null, message.toString());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MedicalApp::new);
    }
}
