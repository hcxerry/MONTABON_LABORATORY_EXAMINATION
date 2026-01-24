package model;

public class Task extends AbstractTask {

    private String status;

    // These are the only allowed values
    public static final String DONE = "DONE";
    public static final String ONGOING = "ONGOING";
    public static final String NOT_STARTED = "NOT STARTED";

    public Task(int taskId, String taskName, String taskDescription, String status) {
        super(taskId, taskName, taskDescription);
        setStatus(status);
    }

    
    // Overriding the status getter & setter
    @Override
    public String getStatus() {
        return status;
    }

    @Override
    public void setStatus(String status) {

        if (status.equals(DONE) || 
            status.equals(ONGOING) || 
            status.equals(NOT_STARTED)) {

            this.status = status;
        } else {
            this.status = NOT_STARTED;
        }
    }
}
