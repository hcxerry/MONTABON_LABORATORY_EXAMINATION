package ui;

import controller.TaskManager;
import model.Task;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MainWindow extends JFrame {

    private TaskManager taskManager;
    private JTable table;
    private DefaultTableModel tableModel;

    private TaskForm taskForm; // SINGLE INSTANCE

    public MainWindow(TaskManager manager) {

        this.taskManager = manager;

        setTitle("To-Do List Viewer");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton addBtn = new JButton("Add Task");

        addBtn.addActionListener(e -> {

            if (taskForm == null || !taskForm.isDisplayable()) {
                taskForm = new TaskForm(taskManager, this);
                taskForm.setVisible(true);
            }
        });

        String[] columns = {"Task ID", "Task Name", "Task Description", "Status"};

        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);

        refreshTable();

        JPanel topPanel = new JPanel();
        topPanel.add(addBtn);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    // Refresh JTable
    public void refreshTable() {

        tableModel.setRowCount(0);

        for (Task t : taskManager.getTasks()) {

            Object[] row = {
                    t.getTaskId(),
                    t.getTaskName(),
                    t.getTaskDescription(),
                    t.getStatus()
            };

            tableModel.addRow(row);
        }
    }
}
