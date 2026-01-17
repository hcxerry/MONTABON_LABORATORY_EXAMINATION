package main;

import controller.TaskManager;
import ui.MainWindow;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        new MainWindow(manager).setVisible(true);
    }
}
