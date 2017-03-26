package com.epam.library.command;

/**
 *
 */
@FunctionalInterface
public interface ICommand {
    String execute(String params);
}
