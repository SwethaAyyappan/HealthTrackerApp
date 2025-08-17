import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class AppointmentReminder {
    private JFrame frame;
    private JTextField hospitalField;
    private JTextField doctorField;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AppointmentReminder::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        AppointmentReminder reminder = new AppointmentReminder();
        reminder.initialize();
    }

    private void initialize() {
        frame = new JFrame("Appointment Reminder");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 2));

        JLabel hospitalLabel = new JLabel("Hospital Name:");
        hospitalField = new JTextField(20);

        JLabel doctorLabel = new JLabel("Doctor Name:");
        doctorField = new JTextField(20);

        JButton setAppointmentButton = new JButton("Set Appointment");
        setAppointmentButton.addActionListener(new SetAppointmentListener());

        mainPanel.add(hospitalLabel);
        mainPanel.add(hospitalField);
        mainPanel.add(doctorLabel);
        mainPanel.add(doctorField);
        mainPanel.add(new JLabel()); // Empty label for alignment
        mainPanel.add(setAppointmentButton);

        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    private class SetAppointmentListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String hospitalName = hospitalField.getText();
            String doctorName = doctorField.getText();

            // Prompt the user for the appointment date
            LocalDate appointmentDate = promptForDate("Appointment Date");
            if (appointmentDate == null) {
                return; // User canceled the input
            }

            // Prompt the user for the appointment time
            LocalTime appointmentTime = promptForTime("Appointment Time");
            if (appointmentTime == null) {
                return; // User canceled the input
            }

            // Combine the appointment date and time into a LocalDateTime object
            LocalDateTime appointmentDateTime = LocalDateTime.of(appointmentDate, appointmentTime);

            // Calculate the reminder time (previous day of the appointment)
            //LocalDateTime reminderDateTime = appointmentDateTime.minusDays(1);
            LocalDateTime reminderDateTime = appointmentDateTime.minusMinutes(2);
            

            // Check if the reminder time is in the future
            LocalDateTime currentDateTime = LocalDateTime.now();
            if (reminderDateTime.isBefore(currentDateTime)) {
                JOptionPane.showMessageDialog(frame, "Invalid appointment time or reminder already passed!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Schedule the reminder using Timer
            long delay = calculateDelay(currentDateTime, reminderDateTime);
            Timer timer = new Timer((int) delay, new ReminderListener(hospitalName, doctorName, appointmentDateTime));
            timer.setRepeats(false);
            timer.start();

            JOptionPane.showMessageDialog(frame, "Appointment set successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }

        private LocalDate promptForDate(String message) {
            String input = JOptionPane.showInputDialog(frame, message, "Enter Date (YYYY-MM-DD)");
            if (input == null) {
                return null; // User canceled the input
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            return LocalDate.parse(input, formatter);
        }

        private LocalTime promptForTime(String message) {
            String input = JOptionPane.showInputDialog(frame, message, "Enter Time (HH:MM)");
            if (input == null) {
                return null; // User canceled the input
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            return LocalTime.parse(input, formatter);
        }

        private long calculateDelay(LocalDateTime currentDateTime, LocalDateTime reminderDateTime) {
            return java.time.Duration.between(currentDateTime, reminderDateTime).toMillis();
        }
    }

    private class ReminderListener implements ActionListener {
        private String hospitalName;
        private String doctorName;
        private LocalDateTime appointmentDateTime;

        public ReminderListener(String hospitalName, String doctorName, LocalDateTime appointmentDateTime) {
            this.hospitalName = hospitalName;
            this.doctorName = doctorName;
            this.appointmentDateTime = appointmentDateTime;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String appointmentTime = appointmentDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            String message = "Reminder: You have an appointment at " + hospitalName +
                    " with Dr. " + doctorName + " on " + appointmentTime;
            JOptionPane.showMessageDialog(frame, message, "Appointment Reminder", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
