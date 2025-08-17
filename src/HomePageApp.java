
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePageApp {
    private JFrame frame;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HomePageApp homePageApp = new HomePageApp();
            homePageApp.createAndShowGUI();
        });
    }

    private void createAndShowGUI() {
        frame = new JFrame("Medical Health Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.blue);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.decode("#CFDC9F"));
        JLabel titleLabel = new JLabel("WELCOME TO MEDICAL HEALTH TRACKER! ");
        titleLabel.setFont(new Font("Garamond", Font.BOLD, 50));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setBackground(Color.decode("#CFDCF9"));
        titleLabel.setForeground(Color.BLUE);
        panel.add(titleLabel, BorderLayout.CENTER);

        JButton startButton = new JButton("Start");
        startButton.setPreferredSize(new Dimension(300, 200));
       // startButton.setBounds(50,100,60,30); 
        startButton.setBackground(Color.decode("#CFDC9F"));
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openMedicalTrackerApp();
            }
        });
        panel.add(startButton, BorderLayout.SOUTH);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }

	private void openMedicalTrackerApp() {
		frame.dispose(); // Close the current window

		JFrame medicalTrackerFrame = new JFrame("Medical Tracker App");
		medicalTrackerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Add your implementation for the MedicalTrackerApp page here
		// ...

		frame.dispose(); // Close the current window

		SwingUtilities.invokeLater(() -> {
			MedicalTrackerApp medicalTrackerApp = new MedicalTrackerApp();
			medicalTrackerApp.initialize();
		});
	}}