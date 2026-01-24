package model;

public abstract class AbstractTask {

    protected int taskId;
    protected String taskName;
    protected String taskDescription;

    // Default Constructor
    public AbstractTask() {
    }

    // Parameterized Constructor
    public AbstractTask(int taskId, String taskName, String taskDescription) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
    }

    // Abstract Getter and Setter for Status
    public abstract String getStatus();
    public abstract void setStatus(String status);

    // Normal Getters and Setters
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
}
