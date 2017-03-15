package com.epam.library.app;

import com.epam.library.command.CommandContainer;
import com.epam.library.command.CommandManager;
import com.epam.library.controller.Controller;

/**
 *
 */
public class App {
    private static final String START_MESSAGE = "You are using Library CLI. Print 'menu' to view available operations.";

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        System.out.println(START_MESSAGE);
        Controller controller = new Controller();
        CommandContainer commandContainer;
        do {
            commandContainer = controller.read();
            controller.process(commandContainer);
        }
        while (!CommandManager.isTerminatingCommand(commandContainer.getCommand()));
    }
}
