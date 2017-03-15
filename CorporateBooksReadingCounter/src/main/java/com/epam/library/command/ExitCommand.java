package com.epam.library.command;

/**
 *
 */
public class ExitCommand implements ICommand {
    private static final String EXIT_MESSAGE = "Application terminated";
    @Override
    public String execute(String command) {
        return EXIT_MESSAGE;
    }
}
