import controller.TaskManager;
import ui.MainWindow;

// This is the main class used for running the program. 
public class Main {

    public static void main(String[] args) {

        TaskManager manager = new TaskManager();

        MainWindow window = new MainWindow(manager);
        window.setVisible(true);
    }
}
