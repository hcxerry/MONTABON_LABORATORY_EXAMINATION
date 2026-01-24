package model;

public abstract class AbstractTask {

    protected int taskId;
    protected String taskName;
    protected String taskDescription;
    // This is the default constructor
    public AbstractTask() {
    }

    
    // This is the parameterized constructor
    public AbstractTask(int taskId, String taskName, String taskDescription) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
    }

    // I used abstract getter & setter for status
    public abstract String getStatus();
    public abstract void setStatus(String status);

    // more normal getters and setters
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
