
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HealthTrackerUI extends JFrame {
    private JLabel lblCaloriesConsumedGoal;
    private JTextField txtCaloriesConsumedGoal;
    private JLabel lblSleepHoursGoal;
    private JTextField txtSleepHoursGoal;
    private JLabel lblCaloriesBurntGoal;
    private JTextField txtCaloriesBurntGoal;
    private JLabel lblWaterIntakeGoal;
    private JTextField txtWaterIntakeGoal;
    private JLabel lblProteinIntakeGoal;
    private JTextField txtProteinIntakeGoal;
    private JLabel lblCarbohydrateIntakeGoal;
    private JTextField txtCarbohydrateIntakeGoal;
    private JLabel lblFatIntakeGoal;
    private JTextField txtFatIntakeGoal;
    private JLabel lblVitaminsIntakeGoal;
    private JTextField txtVitaminsIntakeGoal;
    private JLabel lblMineralsIntakeGoal;
    private JTextField txtMineralsIntakeGoal;

    private JLabel lblCaloriesConsumed;
    private JTextField txtCaloriesConsumed;
    private JLabel lblSleepHours;
    private JTextField txtSleepHours;
    private JLabel lblCaloriesBurnt;
    private JTextField txtCaloriesBurnt;
    private JLabel lblWaterIntake;
    private JTextField txtWaterIntake;
    private JLabel lblProteinIntake;
    private JTextField txtProteinIntake;
    private JLabel lblCarbohydrateIntake;
    private JTextField txtCarbohydrateIntake;
    private JLabel lblFatIntake;
    private JTextField txtFatIntake;
    private JLabel lblVitaminsIntake;
    private JTextField txtVitaminsIntake;
    private JLabel lblMineralsIntake;
    private JTextField txtMineralsIntake;

    private JButton btnSubmit;

    public HealthTrackerUI() {
        setTitle("Health Tracker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(0, 2, 10, 10));

        initializeComponents();
        addComponentsToFrame();

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void initializeComponents() {
        lblCaloriesConsumedGoal = new JLabel("Calories Consumed Goal:");
        txtCaloriesConsumedGoal = new JTextField();
        lblSleepHoursGoal = new JLabel("Sleep Hours Goal:");
        txtSleepHoursGoal = new JTextField();
        lblCaloriesBurntGoal = new JLabel("Calories Burnt Goal:");
        txtCaloriesBurntGoal = new JTextField();
        lblWaterIntakeGoal = new JLabel("Water Intake Goal (in ounces):");
        txtWaterIntakeGoal = new JTextField();
        lblProteinIntakeGoal = new JLabel("Protein Intake Goal (in grams):");
        txtProteinIntakeGoal = new JTextField();
        lblCarbohydrateIntakeGoal = new JLabel("Carbohydrate Intake Goal (in grams):");
        txtCarbohydrateIntakeGoal = new JTextField();
        lblFatIntakeGoal = new JLabel("Fat Intake Goal (in grams):");
        txtFatIntakeGoal = new JTextField();
        lblVitaminsIntakeGoal = new JLabel("Vitamins Intake Goal:");
        txtVitaminsIntakeGoal = new JTextField();
        lblMineralsIntakeGoal = new JLabel("Minerals Intake Goal:");
        txtMineralsIntakeGoal = new JTextField();

        lblCaloriesConsumed = new JLabel("Calories Consumed:");
        txtCaloriesConsumed = new JTextField();
        lblSleepHours = new JLabel("Sleep Hours:");
        txtSleepHours = new JTextField();
        lblCaloriesBurnt = new JLabel("Calories Burnt:");
        txtCaloriesBurnt = new JTextField();
        lblWaterIntake = new JLabel("Water Intake (in ounces):");
        txtWaterIntake = new JTextField();
        lblProteinIntake = new JLabel("Protein Intake (in grams):");
        txtProteinIntake = new JTextField();
        lblCarbohydrateIntake = new JLabel("Carbohydrate Intake (in grams):");
        txtCarbohydrateIntake = new JTextField();
        lblFatIntake = new JLabel("Fat Intake (in grams):");
        txtFatIntake = new JTextField();
        lblVitaminsIntake = new JLabel("Vitamins Intake:");
        txtVitaminsIntake = new JTextField();
        lblMineralsIntake = new JLabel("Minerals Intake:");
        txtMineralsIntake = new JTextField();

        btnSubmit = new JButton("Submit");
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submitButtonClicked();
            }
        });
    }

    private void addComponentsToFrame() {
        add(lblCaloriesConsumedGoal);
        add(txtCaloriesConsumedGoal);
        add(lblSleepHoursGoal);
        add(txtSleepHoursGoal);
        add(lblCaloriesBurntGoal);
        add(txtCaloriesBurntGoal);
        add(lblWaterIntakeGoal);
        add(txtWaterIntakeGoal);
        add(lblProteinIntakeGoal);
        add(txtProteinIntakeGoal);
        add(lblCarbohydrateIntakeGoal);
        add(txtCarbohydrateIntakeGoal);
        add(lblFatIntakeGoal);
        add(txtFatIntakeGoal);
        add(lblVitaminsIntakeGoal);
        add(txtVitaminsIntakeGoal);
        add(lblMineralsIntakeGoal);
        add(txtMineralsIntakeGoal);

        add(lblCaloriesConsumed);
        add(txtCaloriesConsumed);
        add(lblSleepHours);
        add(txtSleepHours);
        add(lblCaloriesBurnt);
        add(txtCaloriesBurnt);
        add(lblWaterIntake);
        add(txtWaterIntake);
        add(lblProteinIntake);
        add(txtProteinIntake);
        add(lblCarbohydrateIntake);
        add(txtCarbohydrateIntake);
        add(lblFatIntake);
        add(txtFatIntake);
        add(lblVitaminsIntake);
        add(txtVitaminsIntake);
        add(lblMineralsIntake);
        add(txtMineralsIntake);

        add(btnSubmit);
    }

    private void submitButtonClicked() {
        int caloriesConsumedGoal = Integer.parseInt(txtCaloriesConsumedGoal.getText());
        int sleepHoursGoal = Integer.parseInt(txtSleepHoursGoal.getText());
        int caloriesBurntGoal = Integer.parseInt(txtCaloriesBurntGoal.getText());
        int waterIntakeGoal = Integer.parseInt(txtWaterIntakeGoal.getText());
        int proteinIntakeGoal = Integer.parseInt(txtProteinIntakeGoal.getText());
        int carbohydrateIntakeGoal = Integer.parseInt(txtCarbohydrateIntakeGoal.getText());
        int fatIntakeGoal = Integer.parseInt(txtFatIntakeGoal.getText());
        String vitaminsIntakeGoal = txtVitaminsIntakeGoal.getText();
        String mineralsIntakeGoal = txtMineralsIntakeGoal.getText();

        int caloriesConsumed = Integer.parseInt(txtCaloriesConsumed.getText());
        int sleepHours = Integer.parseInt(txtSleepHours.getText());
        int caloriesBurnt = Integer.parseInt(txtCaloriesBurnt.getText());
        int waterIntake = Integer.parseInt(txtWaterIntake.getText());
        int proteinIntake = Integer.parseInt(txtProteinIntake.getText());
        int carbohydrateIntake = Integer.parseInt(txtCarbohydrateIntake.getText());
        int fatIntake = Integer.parseInt(txtFatIntake.getText());
        String vitaminsIntake = txtVitaminsIntake.getText();
        String mineralsIntake = txtMineralsIntake.getText();

        compareGoal(caloriesConsumed, caloriesConsumedGoal, "Calories Consumed");
        compareGoal(sleepHours, sleepHoursGoal, "Sleep Hours");
        compareGoal(caloriesBurnt, caloriesBurntGoal, "Calories Burnt");
        compareGoal(waterIntake, waterIntakeGoal, "Water Intake");
        compareGoal(proteinIntake, proteinIntakeGoal, "Protein Intake");
        compareGoal(carbohydrateIntake, carbohydrateIntakeGoal, "Carbohydrate Intake");
        compareGoal(fatIntake, fatIntakeGoal, "Fat Intake");
        compareGoal(vitaminsIntake, vitaminsIntakeGoal, "Vitamins Intake");
        compareGoal(mineralsIntake, mineralsIntakeGoal, "Minerals Intake");
    }

    private void compareGoal(int actualValue, int goalValue, String goalName) {
        String message = goalName + ":\n" +
                "Goal: " + goalValue + "\n" +
                "Actual: " + actualValue + "\n\n";

        if (actualValue > goalValue) {
            message += "Congratulations! You have exceeded your goal.";
        } else if (actualValue == goalValue) {
            message += "Good job! You have reached your goal.";
        } else {
            message += "Keep going! You are making progress towards your goal.";
        }

        JOptionPane.showMessageDialog(this, message);
    }

    private void compareGoal(String actualValue, String goalValue, String goalName) {
        String message = goalName + ":\n" +
                "Goal: " + goalValue + "\n" +
                "Actual: " + actualValue + "\n\n";

        if (actualValue.equalsIgnoreCase(goalValue)) {
            message += "Good job! You have reached your goal.";
        } else {
            message += "Keep going! You are making progress towards your goal.";
        }

        JOptionPane.showMessageDialog(this, message);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new HealthTrackerUI();
            }
        });
    }
}
