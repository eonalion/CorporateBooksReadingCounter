package com.epam.library.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class CommandManager {
    private static Map<String, ICommand> commands = new HashMap<>();
    private static List<String> terminateCommands = new ArrayList<>();

    static {
        commands.put(AvailableOperations.MENU_COMMAND, new ViewMenuCommand());
        commands.put(AvailableOperations.VIEW_COMMAND, new ViewCommand());
        commands.put(AvailableOperations.EXIT_COMMAND, new ExitCommand());
        terminateCommands.add(AvailableOperations.EXIT_COMMAND);
    }

    public static boolean isTerminatingCommand(String command) {
        return terminateCommands.contains(command);
    }

    public ICommand defineCommand(String commandString) {
        if (commands.containsKey(commandString)) {
            return commands.get(commandString);
        } else {
            return new FailureCommand(AvailableOperations.INVALID_COMMAND_MESSAGE);
        }
    }

    public static Map<String, ICommand> getCommands() {
        return commands;
    }
}
