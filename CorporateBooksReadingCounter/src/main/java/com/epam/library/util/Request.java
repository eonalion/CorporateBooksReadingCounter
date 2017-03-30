package com.epam.library.util;

/**
 *
 */
public class Request {
    private String command;
    private String parameters;

    public Request() {
    }

    public Request(String command, String parameters) {
        this.command = command;
        this.parameters = parameters;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public String getCommand() {
        return command;
    }

    public String getParameters() {
        return parameters;
    }
}
