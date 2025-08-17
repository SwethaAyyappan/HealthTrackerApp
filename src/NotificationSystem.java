import javax.swing.*;

public class NotificationSystem {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(NotificationSystem::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Notification System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton showNotificationButton = new JButton("Show Notification");
        showNotificationButton.addActionListener(e -> showNotification());

        frame.getContentPane().add(showNotificationButton);
        frame.pack();
        frame.setVisible(true);
    }

    private static void showNotification() {
        JFrame notificationFrame = new JFrame();
        notificationFrame.setUndecorated(true);
        notificationFrame.setSize(300, 100);
        notificationFrame.setLocationRelativeTo(null); // Center on screen

        JPanel notificationPanel = new JPanel();
        notificationPanel.setBorder(BorderFactory.createEtchedBorder());
        notificationFrame.getContentPane().add(notificationPanel);

        JLabel notificationLabel = new JLabel("This is a notification!");
        notificationPanel.add(notificationLabel);

        notificationFrame.setVisible(true);

        // Close the notification after 3 seconds
        Timer timer = new Timer(3000, e -> notificationFrame.dispose());
        timer.setRepeats(false);
        timer.start();
    }
}

