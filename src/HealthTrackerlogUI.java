import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class HealthTrackerlogUI extends JFrame {
    private DefaultTableModel tableModel;
    private JTable comparisonTable;

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

    public HealthTrackerlogUI() {
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
            @Override
            public void actionPerformed(ActionEvent e) {
                compareGoals();
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

        add(new JLabel());
        add(btnSubmit);
    }

    private void compareGoals() {
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

        Vector<String> columnNames = new Vector<>();
        columnNames.add("Goal");
        columnNames.add("Actual");

        Vector<Vector<String>> data = new Vector<>();
        Vector<String> row1 = new Vector<>();
        row1.add("Calories Consumed");
        row1.add(Integer.toString(caloriesConsumedGoal));
        data.add(row1);

        Vector<String> row2 = new Vector<>();
        row2.add("Sleep Hours");
        row2.add(Integer.toString(sleepHoursGoal));
        data.add(row2);

        Vector<String> row3 = new Vector<>();
        row3.add("Calories Burnt");
        row3.add(Integer.toString(caloriesBurntGoal));
        data.add(row3);

        Vector<String> row4 = new Vector<>();
        row4.add("Water Intake");
        row4.add(Integer.toString(waterIntakeGoal));
        data.add(row4);

        Vector<String> row5 = new Vector<>();
        row5.add("Protein Intake");
        row5.add(Integer.toString(proteinIntakeGoal));
        data.add(row5);

        Vector<String> row6 = new Vector<>();
        row6.add("Carbohydrate Intake");
        row6.add(Integer.toString(carbohydrateIntakeGoal));
        data.add(row6);

        Vector<String> row7 = new Vector<>();
        row7.add("Fat Intake");
        row7.add(Integer.toString(fatIntakeGoal));
        data.add(row7);

        Vector<String> row8 = new Vector<>();
        row8.add("Vitamins Intake");
        row8.add(vitaminsIntakeGoal);
        data.add(row8);

        Vector<String> row9 = new Vector<>();
        row9.add("Minerals Intake");
        row9.add(mineralsIntakeGoal);
        data.add(row9);

        Vector<String> row10 = new Vector<>();
        row10.add("Current Date");
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        row10.add(dateFormat.format(new Date()));
        data.add(row10);

        Vector<String> row11 = new Vector<>();
        row11.add("Actual Calories Consumed");
        row11.add(Integer.toString(caloriesConsumed));
        data.add(row11);

        Vector<String> row12 = new Vector<>();
        row12.add("Actual Sleep Hours");
        row12.add(Integer.toString(sleepHours));
        data.add(row12);

        Vector<String> row13 = new Vector<>();
        row13.add("Actual Calories Burnt");
        row13.add(Integer.toString(caloriesBurnt));
        data.add(row13);

        Vector<String> row14 = new Vector<>();
        row14.add("Actual Water Intake");
        row14.add(Integer.toString(waterIntake));
        data.add(row14);

        Vector<String> row15 = new Vector<>();
        row15.add("Actual Protein Intake");
        row15.add(Integer.toString(proteinIntake));
        data.add(row15);

        Vector<String> row16 = new Vector<>();
        row16.add("Actual Carbohydrate Intake");
        row16.add(Integer.toString(carbohydrateIntake));
        data.add(row16);

        Vector<String> row17 = new Vector<>();
        row17.add("Actual Fat Intake");
        row17.add(Integer.toString(fatIntake));
        data.add(row17);

        Vector<String> row18 = new Vector<>();
        row18.add("Actual Vitamins Intake");
        row18.add(vitaminsIntake);
        data.add(row18);

        Vector<String> row19 = new Vector<>();
        row19.add("Actual Minerals Intake");
        row19.add(mineralsIntake);
        data.add(row19);

        tableModel = new DefaultTableModel(data, columnNames);
        comparisonTable = new JTable(tableModel);

        JOptionPane.showMessageDialog(this, new JScrollPane(comparisonTable), "Goal Comparison", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new HealthTrackerUI();
            }
        });
    }
}