package com.epam.library.app;

import com.epam.library.command.CommandManager;
import com.epam.library.controller.Controller;
import com.epam.library.database.ConnectionManager;
import com.epam.library.util.CLIReaderWriter;
import com.epam.library.util.Request;

/**
 *
 */
public class App {
    private App() {
    }

    private static final String START_MESSAGE = "You are running Library CLI. Enter 'menu' to view available operations.";

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        System.out.println(START_MESSAGE);
        try {
            Controller controller = new Controller();
            Request request;
            do {
                request = CLIReaderWriter.read();
                CLIReaderWriter.write(controller.process(request));
            }
            while (!CommandManager.isTerminatingCommand(request.getCommand()));
        } finally {
            ConnectionManager.closeConnection();
        }
    }


}
