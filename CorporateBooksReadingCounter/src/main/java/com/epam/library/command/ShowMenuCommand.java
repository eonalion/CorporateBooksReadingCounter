package com.epam.library.command;

import com.epam.library.service.BookService;
import com.epam.library.service.EmployeeService;

import java.util.Map;

/**
 *
 */
public class ShowMenuCommand implements ICommand {
    private static final String INVALID_PARAMS_MESSAGE = "Invalid params";

    @Override
    public String execute(String param) {
        final StringBuilder builder = new StringBuilder();
        Map<String, ICommand> commands = CommandManager.getCommands();
        commands.forEach((s, c) -> builder.append(s).append("\n"));
        return builder.toString();
    }
}
