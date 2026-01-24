package model;

public class TimedTask extends Task {

    private int estimatedMinutes;

    public TimedTask(int taskId, String taskName, String taskDescription,
                     String status, int estimatedMinutes) {

        super(taskId, taskName, taskDescription, status);
        this.estimatedMinutes = estimatedMinutes;
    }

    // Encapsulation is used here
    public int getEstimatedMinutes() {
        return estimatedMinutes;
    }

    public void setEstimatedMinutes(int estimatedMinutes) {
        this.estimatedMinutes = estimatedMinutes;
    }
}
