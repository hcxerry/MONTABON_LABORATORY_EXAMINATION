package model;

public class Task extends AbstractTask {
    private String status;

    public static final String DONE = "DONE";
    public static final String ONGOING = "ONGOING";
    public static final String NOT_STARTED = "NOT STARTED";

    public Task() {
        this.status = NOT_STARTED;
    }

    public Task(int id, String name, String desc, String status) {
        super(id, name, desc);
        this.status = status;
    }

    @Override
    public String getStatus() { return status; }

    @Override
    public void setStatus(String status) {
        this.status = status;
    }
}

    public abstract String getStatus();
    public abstract void setStatus(String status);
}
