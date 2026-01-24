package ui;

import controller.TaskManager;
import model.Task;

import javax.swing.*;
import java.awt.*;


public class TaskForm extends JFrame {

    private TaskManager taskManager;
    private MainWindow mainWindow;

    private JTextField txtId, txtName;
    private JTextArea txtDesc;
    private JComboBox<String> cmbStatus;

    public TaskForm(TaskManager manager, MainWindow window) {

        this.taskManager = manager;
        this.mainWindow = window;

        setTitle("Add Task Form");
        setSize(350, 350);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 1));

        txtId = new JTextField();
        txtId.setEditable(false);
        txtId.setText(String.valueOf(taskManager.generateTaskId()));

        txtName = new JTextField();
        txtDesc = new JTextArea();

        cmbStatus = new JComboBox<>();
        cmbStatus.addItem("Not Started");
        cmbStatus.addItem("Ongoing");
        cmbStatus.addItem("Completed");

        JButton saveBtn = new JButton("Save Task");

        saveBtn.addActionListener(e -> saveTask());

        add(new JLabel("Task ID"));
        add(txtId);

        add(new JLabel("Task Name"));
        add(txtName);

        add(new JLabel("Task Description"));
        add(new JScrollPane(txtDesc));

        add(new JLabel("Status"));
        add(cmbStatus);

        add(saveBtn);
    }

    private void saveTask() {

        // for validation
        if (txtName.getText().trim().isEmpty() ||
            txtDesc.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(this,
                    "All fields are required!");
            return;
        }

        int id = Integer.parseInt(txtId.getText());
        String name = txtName.getText();
        String desc = txtDesc.getText();

        String status;

        if (cmbStatus.getSelectedItem().equals("Completed")) {
            status = Task.DONE;
        } else if (cmbStatus.getSelectedItem().equals("Ongoing")) {
            status = Task.ONGOING;
        } else {
            status = Task.NOT_STARTED;
        }

        // Creating task object
        Task task = new Task(id, name, desc, status);

        // Passing to TaskManager
        taskManager.addTask(task);

        // Refreshing the JTable
        mainWindow.refreshTable();

        // Closing the Form
        dispose();
    }
}
