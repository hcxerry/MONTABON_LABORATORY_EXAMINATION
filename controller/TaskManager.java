package controller;

import model.Task;
import java.util.ArrayList;

public class TaskManager {

    private ArrayList<Task> taskList;

    public TaskManager() {
        taskList = new ArrayList<>();
    }

    // Add Task
    public void addTask(Task task) {
        taskList.add(task);
    }

    // View Tasks
    public ArrayList<Task> getTasks() {
        return taskList;
    }

    // Generate Task ID
    public int generateTaskId() {
        if (taskList.isEmpty()) {
            return 1001;
        }
        return taskList.get(taskList.size() - 1).getTaskId() + 1;
    }
}
