package com.epam.library.command;

/**
 *
 */
public class CommandContainer {
    private String command;
    private String params;

    public void setCommand(String command) {
        this.command = command;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public String getCommand() {
        return command;
    }

    public String getParams() {
        return params;
    }
}
