package com.epam.library.command;

import com.epam.library.util.Response;

/**
 *
 */
@FunctionalInterface
public interface ICommand {
    Response execute(String params);
}
