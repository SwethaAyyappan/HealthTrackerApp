import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MedicalDataStorageApp extends JFrame {
    private JTextField testNameField;
    private JTextField testDateField;
    private JTextArea notesArea;
    private JButton fileButton;
    private JButton submitButton;

    private String selectedFilePath = null; // store chosen file path

    public MedicalDataStorageApp() {
        // Set up the JFrame
        setTitle("Medical Test and Report Storage");
        setSize(500, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Only closes this window
        setLocationRelativeTo(null);

        // Create components
        JLabel testNameLabel = new JLabel("Test Name:");
        testNameField = new JTextField(20);

        JLabel testDateLabel = new JLabel("Test Date (yyyy-MM-dd):");
        testDateField = new JTextField(10);

        JLabel notesLabel = new JLabel("Notes:");
        notesArea = new JTextArea(5, 20);
        JScrollPane notesScrollPane = new JScrollPane(notesArea);

        fileButton = new JButton("Choose File");
        submitButton = new JButton("Submit");

        // Add action listeners
        fileButton.addActionListener(new FileButtonListener());
        submitButton.addActionListener(new SubmitButtonListener());

        // Layout using GridBagLayout
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0;
        add(testNameLabel, gbc);
        gbc.gridx = 1;
        add(testNameField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        add(testDateLabel, gbc);
        gbc.gridx = 1;
        add(testDateField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        add(notesLabel, gbc);
        gbc.gridx = 1;
        add(notesScrollPane, gbc);

        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        add(fileButton, gbc);

        gbc.gridy = 4;
        add(submitButton, gbc);
    }

    private class FileButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(MedicalDataStorageApp.this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                selectedFilePath = selectedFile.getAbsolutePath();
                JOptionPane.showMessageDialog(MedicalDataStorageApp.this,
                        "Selected File: " + selectedFilePath);
            }
        }
    }

    private class SubmitButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // Retrieve form values
            String testName = testNameField.getText().trim();
            String testDate = testDateField.getText().trim();
            String notes = notesArea.getText().trim();

            if (testName.isEmpty() || testDate.isEmpty()) {
                JOptionPane.showMessageDialog(MedicalDataStorageApp.this,
                        "Test Name and Test Date are required.",
                        "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Save to database
            try (Connection con = SQLManager.getConnection();
                 PreparedStatement stmt = con.prepareStatement(
                         "INSERT INTO medical_tests (name, date, notes, filepath) VALUES (?, ?, ?, ?)")) {
                stmt.setString(1, testName);
                stmt.setString(2, testDate);
                stmt.setString(3, notes);
                stmt.setString(4, selectedFilePath);

                stmt.executeUpdate();

                JOptionPane.showMessageDialog(MedicalDataStorageApp.this,
                        "Data stored successfully!");

                // Clear fields after confirmation
                testNameField.setText("");
                testDateField.setText("");
                notesArea.setText("");
                selectedFilePath = null;

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(MedicalDataStorageApp.this,
                        "Error saving data: " + ex.getMessage(),
                        "Database Error", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MedicalDataStorageApp().setVisible(true));
    }
}
