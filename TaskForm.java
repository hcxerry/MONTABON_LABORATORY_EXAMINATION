package ui;

import controller.TaskManager;
import model.Task;

import javax.swing.*;
import java.awt.*;

public class TaskForm extends JDialog {
    public TaskForm(MainWindow parent, TaskManager manager) {
        super(parent, "Add Task", true);
        setSize(400, 300);
        setLocationRelativeTo(parent);

        JTextField idField = new JTextField(
                String.valueOf(manager.generateTaskId())
        );
        idField.setEditable(false);

        JTextField nameField = new JTextField();
        JTextArea descArea = new JTextArea();

        JComboBox<String> statusBox = new JComboBox<>(
                new String[]{"NOT STARTED", "ONGOING", "DONE"}
        );

        JButton saveBtn = new JButton("Save Task");
        saveBtn.addActionListener(e -> {
            if (nameField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Task name required");
                return;
            }

            Task task = new Task(
                    Integer.parseInt(idField.getText()),
                    nameField.getText(),
                    descArea.getText(),
                    (String) statusBox.getSelectedItem()
            );

            manager.addTask(task);
            parent.refreshTable();
            dispose();
        });

        setLayout(new GridLayout(5, 2));
        add(new JLabel("Task ID")); add(idField);
        add(new JLabel("Task Name")); add(nameField);
        add(new JLabel("Description")); add(new JScrollPane(descArea));
        add(new JLabel("Status")); add(statusBox);
        add(new JLabel()); add(saveBtn);
    }
}
