import controller.TaskManager;
import ui.MainWindow;

public class Main {

    public static void main(String[] args) {

        TaskManager manager = new TaskManager();

        MainWindow window = new MainWindow(manager);
        window.setVisible(true);
    }
}
