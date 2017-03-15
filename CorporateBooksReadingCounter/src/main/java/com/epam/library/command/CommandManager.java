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
        commands.put("exit", new ExitCommand());
        commands.put("menu", new ShowMenuCommand());
        commands.put("view_all", new ShowAllCommand());
        terminateCommands.add("exit");
    }

    public static boolean isTerminatingCommand(String command) {
        return terminateCommands.contains(command);
    }

    public ICommand defineCommand(String commandString) {
        return commands.get(commandString);
    }

    public static Map<String, ICommand> getCommands() {
        return commands;
    }
}
