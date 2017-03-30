package com.epam.library.controller;

import com.epam.library.util.Request;
import com.epam.library.command.CommandManager;
import com.epam.library.command.ICommand;
import com.epam.library.util.Response;

/**
 *
 */
public class Controller {
    private CommandManager commandManager;

    public Controller() {
        commandManager = new CommandManager();
    }

    public Response process(Request commandContainer) {
        ICommand command = commandManager.defineCommand(commandContainer.getCommand());
        return command.execute(commandContainer.getParameters());
    }
}
