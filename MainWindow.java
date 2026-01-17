package ui;

import controller.TaskManager;
import model.Task;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class MainWindow extends JFrame {
    private final TaskManager manager;
    private final DefaultTableModel model;
    private TaskForm form;

    public MainWindow(TaskManager manager) {
        this.manager = manager;

        setTitle("To-Do List");
        setSize(700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JButton addBtn = new JButton("Add Task");
        addBtn.addActionListener(e -> openForm());

        model = new DefaultTableModel(
                new String[]{"Task ID", "Task Name", "Description", "Status"}, 0
        );
        JTable table = new JTable(model);

        add(addBtn, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    private void openForm() {
        if (form == null || !form.isDisplayable()) {
            form = new TaskForm(this, manager);
            form.setVisible(true);
        }
    }

    public void refreshTable() {
        model.setRowCount(0);
        for (Task t : manager.getTasks()) {
            model.addRow(new Object[]{
                    t.getTaskId(),
                    t.getTaskName(),
                    t.getTaskDescription(),
                    t.getStatus()
            });
        }
    }
}
