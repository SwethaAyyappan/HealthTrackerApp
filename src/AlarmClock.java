import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

public class AlarmClock {
    private JFrame frame;
    private JTextField hourField;
    private JTextField minuteField;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AlarmClock::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        AlarmClock alarmClock = new AlarmClock();
        alarmClock.initialize();
    }

    private void initialize() {
        frame = new JFrame("Alarm Clock");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());

        JLabel hourLabel = new JLabel("Hour:");
        hourField = new JTextField(2);

        JLabel minuteLabel = new JLabel("Minute:");
        minuteField = new JTextField(2);

        JButton setAlarmButton = new JButton("Set Alarm");
        setAlarmButton.addActionListener(new SetAlarmListener());

        mainPanel.add(hourLabel);
        mainPanel.add(hourField);
        mainPanel.add(minuteLabel);
        mainPanel.add(minuteField);
        mainPanel.add(setAlarmButton);

        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setVisible(true);
    }

    private class SetAlarmListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int hour = Integer.parseInt(hourField.getText());
            int minute = Integer.parseInt(minuteField.getText());

            LocalTime currentTime = LocalTime.now();
            LocalTime alarmTime = LocalTime.of(hour, minute);

            long delay = calculateDelay(currentTime, alarmTime);
            if (delay <= 0) {
                JOptionPane.showMessageDialog(frame, "Invalid alarm time!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Timer timer = new Timer((int) delay, new AlarmListener());
            timer.setRepeats(false);
            timer.start();
        }

        private long calculateDelay(LocalTime currentTime, LocalTime alarmTime) {
            long currentMillis = currentTime.toNanoOfDay() / 1_000_000;
            long alarmMillis = alarmTime.toNanoOfDay() / 1_000_000;

            if (alarmMillis <= currentMillis) {
                return -1; // Invalid alarm time
            }

            return alarmMillis - currentMillis;
        }
    }

    private class AlarmListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(frame, "Wake up!", "Alarm", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
