package com.epam.library.command;

import java.util.Map;

/**
 *
 */
public class ViewMenuCommand implements ICommand {
    @Override
    public String execute(String param) {
        String response;
        if (param.isEmpty()) {
            StringBuilder builder = new StringBuilder();
            Map<String, ICommand> commands = CommandManager.getCommands();
            commands.forEach((s, c) -> builder.append(s).append("\n"));
            response = builder.toString();
        } else {
            response = AvailableOperations.INVALID_PARAMETER_LIST_MESSAGE;
        }
        return response;
    }
}
